package github.jsonta.quiz;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Login {
    protected LoginThread thread;
    private String loggedInUser, token;
    private boolean loggedIn = false;
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
    
    public boolean getLoggedIn() {
        return loggedIn;
    }
     
    public String getLoggedInUser() {
        return loggedInUser;
    }
    
    public String getToken() {
        return token;
    }
    
    public void setLoggedIn(boolean b) {
        pcs.firePropertyChange("setLoggedIn", loggedIn, b);
        loggedIn = b;
        
        if (!loggedIn) {
            token = null;
            loggedInUser = null;
        }
    }
    
    public void setLoggedInUser(String s) {
        loggedInUser = s;
    }
    
    public void setToken(String s) {
        token = s;
    }
}
