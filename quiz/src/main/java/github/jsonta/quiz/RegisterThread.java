package github.jsonta.quiz;

public class RegisterThread extends Thread {
    private final String email, paswd, sex;
    private final boolean verification;
    private volatile boolean rgstrSuccessful;
    
    public RegisterThread(String e, String p, String s, boolean v) {
        this.email = e;
        this.paswd = p;
        this.sex = s;
        this.verification = v;
    }
    
    @Override
    public void run() {
        System.out.println(this.email);
        System.out.println(this.paswd);
        System.out.println(this.sex);
        System.out.println(this.verification);
        
        rgstrSuccessful = true;
    }
    
    public boolean getRgstrStatus() {
        return rgstrSuccessful;
    }
}
