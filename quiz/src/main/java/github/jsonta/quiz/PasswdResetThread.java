package github.jsonta.quiz;

public class PasswdResetThread extends NotifyingThread {
    private final String email;
    private volatile boolean requestSent;
    public PasswdResetThread(String e) {
        this.email = e;
    }
    
    @Override
    public void doRun() {
        System.out.println(email);
        requestSent = true;
    }
    
    public boolean didRequestSend() {
        return requestSent;
    }
}
