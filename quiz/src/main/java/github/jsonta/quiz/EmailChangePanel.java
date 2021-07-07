package github.jsonta.quiz;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class EmailChangePanel extends JPanel implements ThreadCompleteListener, WindowListener {
    public EmailChangePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        currentEmailTextField = new javax.swing.JTextField();
        newEmailTextField = new javax.swing.JTextField();
        userPwdField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        changeEmailButton = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        currentEmailTextField.setEditable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Stary adres e-mail");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nowy adres e-mail");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Hasło");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newEmailTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(currentEmailTextField)
                    .addComponent(userPwdField))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userPwdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        changeEmailButton.setText("Zmień adres e-mail");
        changeEmailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeEmailButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeEmailButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changeEmailButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void changeEmailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeEmailButtonActionPerformed
        uiControl(false);
        
        StringBuilder validationErrors = new StringBuilder();
        String emailNew, paswd;
        boolean emailValid, passwordValid;
        
        emailNew = newEmailTextField.getText();
        if (!emailNew.isEmpty()) {
            Matcher m = emailRegex.matcher(emailNew);
            if (m.find())
                emailValid = true;
            else {
                emailValid = false;
                validationErrors.append("Proszę podać poprawny adres e-mail.\n");
            }
        } else {
            emailValid = false;
            validationErrors.append("Proszę podać nowy adres e-mail.\n");
        }
        
        paswd = new String(userPwdField.getPassword());
        if (!paswd.isEmpty()) {
            if (paswd.length() >= 6) {
                Matcher m = paswdRegex.matcher(paswd);
                if (m.find())
                    passwordValid = true;
                else {
                    passwordValid = false;
                    validationErrors.append("Hasło musi zawierać co najmniej jeden (1) znak specjalny.\n");
                }
            } else {
                passwordValid = false;
                validationErrors.append("Hasło musi składać się z co najmniej 6 znaków.\n");
            }
        } else {
            passwordValid = false;
            validationErrors.append("Proszę podać swoje hasło.\n");
        }
        
        if (emailValid && passwordValid) {
            thread = new EmailChangeThread(emailNew, paswd, bearerAuth.toString());
            thread.setName("User e-mail change");
            thread.addListener(this);
            thread.start();
        } else {
            JOptionPane.showMessageDialog(this.getRootPane(), validationErrors.toString(), "Komunikat", JOptionPane.ERROR_MESSAGE);
            uiControl(true);
        }
    }//GEN-LAST:event_changeEmailButtonActionPerformed

    public void setLoginObj(Login obj) {
        loginObj = obj;
    }
    
    private void uiControl(boolean flip) {
        newEmailTextField.setEnabled(flip);
        userPwdField.setEnabled(flip);
        changeEmailButton.setEnabled(flip);
    }
    
    @Override
    public void notifyOfThreadComplete(Thread t) {
        if (t.getName().equals("User e-mail change")) {
            JOptionPane.showMessageDialog(this.getRootPane(), this.thread.getStatus(), "Komunikat", JOptionPane.PLAIN_MESSAGE);
            uiControl(true);
            
            /*
            if (this.thread.getStatusCode() == 200)
                loginObj.setToken(this.thread.getToken());
            */
        }
    }
        
    @Override
    public void windowOpened(WindowEvent e) {
        currentEmailTextField.setText(loginObj.getLoggedInUser());
        bearerAuth = new StringBuilder("Bearer ");
        bearerAuth.append(loginObj.getToken());
    }

    @Override
    public void windowClosing(WindowEvent e) {}

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
    
    private Login loginObj;
    private StringBuilder bearerAuth;
    private final Pattern emailRegex = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
    private final Pattern paswdRegex = Pattern.compile("[!@#$%^&*]+");
    private EmailChangeThread thread;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeEmailButton;
    private javax.swing.JTextField currentEmailTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField newEmailTextField;
    private javax.swing.JPasswordField userPwdField;
    // End of variables declaration//GEN-END:variables
}