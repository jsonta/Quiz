package github.jsonta.quiz;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Login {
    private String email, paswd, status;
    private boolean loggedIn = false;
    private LoginThread thread;
    private final PropertyChangeSupport pcs;
    
    public Login() {
        pcs = new PropertyChangeSupport(this);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        pcs.removePropertyChangeListener(pcl);
    }
    
    public void setLoginData(String e, String p) {
        this.email = e;
        this.paswd = p;
    }
    
    public void executeLogin() {
        thread = new LoginThread(email, paswd);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {}
        
        pcs.firePropertyChange("userLoggedIn", loggedIn, thread.getLoggedIn());
        this.loggedIn = thread.getLoggedIn();
        this.status = thread.getStatus();
    }
    
    public boolean getLoggedIn() {
        return loggedIn;
    }
    
    public String getStatus() {
        return status;
    }
}
