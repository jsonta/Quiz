package github.jsonta.quiz;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class NotifyingThread extends Thread {
    private final Set<ThreadCompleteListener> listeners = new CopyOnWriteArraySet<>();
    public final void addListener(final ThreadCompleteListener listener) {
        listeners.add(listener);
    }
    
    public final void removeListener(final ThreadCompleteListener listener) {
        listeners.remove(listener);
    }
    
    private void notifyListeners() {
        listeners.forEach(listener -> {
            listener.notifyOfThreadComplete(this);
        });
    }
    
    @Override
    public final void run() {
        try {
            doRun();
        } finally {
            notifyListeners();
        }
    }
    
    public abstract void doRun();
}
