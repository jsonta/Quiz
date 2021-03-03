package github.jsonta.quiz;

public class LoginThread extends Thread {
    private volatile String email,paswd,status;
    private volatile boolean loggedIn;
    public LoginThread(String e, String p) {
        this.email = e;
        this.paswd = p;
    }
    
    @Override
    public void run() {
        String testEmail = "johndoe@domain.com";
        String testPaswd = "password";
        
        if (email.equals(testEmail)) {
            if (paswd.equals(testPaswd)) {
                loggedIn = true;
            } else {
                loggedIn = false;
                status = "Podane hasło jest nieprawidłowe";
            }
        } else {
            loggedIn = false;
            status = "Pod podanym adresem e-mail nie ma zarejestrowanego konta użytkownika";
        }
    }
    
    public String getStatus() {
        return status;
    }
    
    public boolean getLoggedIn() {
        return loggedIn;
    }
}
