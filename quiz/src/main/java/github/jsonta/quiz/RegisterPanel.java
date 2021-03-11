package github.jsonta.quiz;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class RegisterPanel extends JPanel implements ThreadCompleteListener {
    public RegisterPanel() {
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

        sex = new javax.swing.ButtonGroup();
        jPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        passwordConfirmField = new javax.swing.JPasswordField();
        femaleButton = new javax.swing.JRadioButton();
        maleButton = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        verificationCheckBox = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        requestRgstrBttn = new javax.swing.JButton();

        jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("E-mail");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Hasło");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Potwierdź hasło");

        sex.add(femaleButton);
        femaleButton.setSelected(true);
        femaleButton.setText("Kobieta");

        sex.add(maleButton);
        maleButton.setText("Mężczyzna");

        jLabel4.setText("Płeć");

        verificationCheckBox.setText("Jestem człowiekiem");

        jLabel5.setText("Weryfikacja");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(verificationCheckBox)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(femaleButton)
                        .addGap(12, 12, 12)
                        .addComponent(maleButton))
                    .addComponent(passwordConfirmField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passwordConfirmField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(femaleButton)
                    .addComponent(maleButton)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verificationCheckBox)
                    .addComponent(jLabel5))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        requestRgstrBttn.setText("Zarejestruj się");
        requestRgstrBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestRgstrBttnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(requestRgstrBttn)
                    .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(requestRgstrBttn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void requestRgstrBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestRgstrBttnActionPerformed
        uiControl(false);
        
        if (validateFields()) {
            thread = new RegisterThread(email, paswd, genStr, verification);
            thread.setName("User register");
            thread.addListener(this);
            thread.start();    
        } else {
            JOptionPane.showMessageDialog(this.getRootPane(), invalidField.toString(), "Komunikat", JOptionPane.ERROR_MESSAGE);
            uiControl(true);
        }
    }//GEN-LAST:event_requestRgstrBttnActionPerformed
    
    private void uiControl(boolean flip) {
        emailTextField.setEnabled(flip);
        passwordField.setEnabled(flip);
        passwordConfirmField.setEnabled(flip);
        femaleButton.setEnabled(flip);
        maleButton.setEnabled(flip);
        verificationCheckBox.setEnabled(flip);
        requestRgstrBttn.setEnabled(flip);
    }
    
    private boolean validateFields() {
        boolean emailValid;
        boolean paswdValid = false;
        invalidField.delete(0, invalidField.length());
        
        email = emailTextField.getText();
        if (!email.isEmpty()) {
            Matcher m = emailRegex.matcher(email);
            if (m.find())
                emailValid = true;
            else {
                emailValid = false;
                invalidField.append("Proszę podać poprawny adres e-mail.\n");
            }
        } else {
            emailValid = false;
            invalidField.append("Proszę podać adres e-mail, na który ma zostać założone konto.\n");
        }
        
        paswd = new String(passwordField.getPassword());
        String paswdConfirm = new String(passwordConfirmField.getPassword());
        if (!paswd.isEmpty()) {
            if (paswd.length() >= 6) {
                if (!paswdConfirm.isEmpty()) {
                    if (paswd.equals(paswdConfirm)) {
                        Matcher m = paswdRegex.matcher(paswd);
                        if (m.find())
                            paswdValid = true;
                        else {
                            paswdValid = false;
                            invalidField.append("Hasło musi zawierać co najmniej jeden (1) znak specjalny.\n");
                        }
                    } else {
                        paswdValid = false;
                        invalidField.append("Podane hasła nie zgadzają się.\n");
                    }
                } else {
                    paswdValid = false;
                    invalidField.append("Proszę podać jeszcze raz to samo hasło.\n");
                }
            } else {
                paswdValid = false;
                invalidField.append("Hasło musi składać się z co najmniej 6 znaków.\n");
            }
        } else {
            paswdValid = false;
            invalidField.append("Proszę podać hasło dla zakładanego konta.\n");
        }
        
        if (femaleButton.isSelected())
            genStr = "Kobieta";
        else if (maleButton.isSelected())
            genStr = "Mężczyzna";
        
        verification = verificationCheckBox.isSelected();
        if (!verification)
            invalidField.append("Proszę potwierdzić, że jesteś człowiekiem.\n");
        
        if (emailValid && paswdValid && verification)
            return true;
        else
            return false;
    }
    
    @Override
    public void notifyOfThreadComplete(Thread t) {
        if (t.getName().equals("User register")) {
            JOptionPane.showMessageDialog(this.getRootPane(), this.thread.getStatus(), "Komunikat", JOptionPane.PLAIN_MESSAGE);
            uiControl(true);
        }
    }
    
    private String email, paswd, genStr;
    private boolean verification;
    private final Pattern emailRegex = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
    private final Pattern paswdRegex = Pattern.compile("[!@#$%^&*]+");
    private final StringBuilder invalidField = new StringBuilder();
    protected RegisterThread thread;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailTextField;
    private javax.swing.JRadioButton femaleButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel;
    private javax.swing.JRadioButton maleButton;
    private javax.swing.JPasswordField passwordConfirmField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton requestRgstrBttn;
    private javax.swing.ButtonGroup sex;
    private javax.swing.JCheckBox verificationCheckBox;
    // End of variables declaration//GEN-END:variables
}
