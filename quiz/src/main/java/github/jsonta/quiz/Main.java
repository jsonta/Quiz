package github.jsonta.quiz;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Main implements PropertyChangeListener {    
    private static MenuFrame menuFrame;
    private static LoginFrame loginFrame;
    private static Login loginObj;
    private static final Main listener = new Main();
        
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        menuFrame = new MenuFrame();
        loginFrame = new LoginFrame();
        
        loginObj = new Login();
        loginObj.addPropertyChangeListener(listener);
        
        loginFrame.setLoginObj(loginObj);
        menuFrame.setLoginObj(loginObj);
        loginFrame.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("setLoggedIn")) {
            if ((boolean)evt.getNewValue()) {
                loginFrame.dispose();
                menuFrame.setVisible(true);
            } else {
                menuFrame.dispose();
                loginFrame.setVisible(true);
            } 
        }
    }
}