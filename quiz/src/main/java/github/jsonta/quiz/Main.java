package github.jsonta.quiz;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Main implements PropertyChangeListener {
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    public Main() {
        pcs.addPropertyChangeListener(this);
    }
    
    private static MenuFrame menuFrame;
    private static LoginFrame loginFrame;
    private static Login loginObj;
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        loginFrame.dispose();
        menuFrame.setVisible(true);
    }
    
    public static void main(String[] args) {
        menuFrame = new MenuFrame();
        loginFrame = new LoginFrame();
        
        loginObj = new Login();
        loginObj.addPropertyChangeListener(new Main());
        loginFrame.setLoginObj(loginObj);
        loginFrame.setVisible(true);    
    }
}
