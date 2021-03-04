package github.jsonta.quiz;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Main implements PropertyChangeListener {    
    private static MenuFrame menuFrame;
    private static LoginFrame loginFrame;
    private static Login loginObj;
    private static final Main listener = new Main();
        
    public static void main(String[] args) {
        menuFrame = new MenuFrame();
        loginFrame = new LoginFrame();
        loginObj = new Login();
        
        loginObj.addPropertyChangeListener(listener);
        loginFrame.setLoginObj(loginObj);
        loginFrame.setVisible(true);    
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        loginFrame.dispose();
        menuFrame.setVisible(true);
    }
}