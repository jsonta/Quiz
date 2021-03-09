package github.jsonta.quiz;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Login {
    protected LoginThread thread;
    private String token;
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
        
    public String getToken() {
        return token;
    }
    
    public void setLoggedIn(boolean b) {
        pcs.firePropertyChange("setLoggedIn", loggedIn, b);
        loggedIn = b;
        
        if (!loggedIn)
            token = null;
    }
    
    public void setToken(String s) {
        token = s;
    }
}
