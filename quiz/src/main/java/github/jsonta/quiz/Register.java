package github.jsonta.quiz;
import javax.swing.JOptionPane;

public class Register extends javax.swing.JPanel {
    private String email, paswd, sexStr;
    private boolean fieldsValid, verification;
    private final StringBuilder invalidField = new StringBuilder();
    public Register() {
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
        RegisterThread thread;
        uiControl(false);
        validateFields();
        
        if (fieldsValid) {
            thread = new RegisterThread(email, paswd, sexStr, verification);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {}   
            
            if (thread.getRgstrStatus())
                JOptionPane.showMessageDialog(null, "Rejestracja przebiegła pomyślnie.", "Komunikat", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, invalidField.toString(), "Komunikat", JOptionPane.ERROR_MESSAGE);
        }
        
        uiControl(true);
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
    
    private void validateFields() {
        boolean emailNotEmpty;
        boolean paswdNotEmpty = false;
        fieldsValid = false;
        invalidField.delete(0, invalidField.length());
        
        email = emailTextField.getText();
        if (email.equals("")) {
            emailNotEmpty = false;
            invalidField.append("Proszę podać adres e-mail, na który ma zostać założone konto.\n");
        } else
            emailNotEmpty = true;
        
        paswd = new String(passwordField.getPassword());
        if (paswd.equals("")) {
            paswdNotEmpty = false;
            invalidField.append("Proszę podać hasło dla zakładanego konta.\n");
        }
        
        String paswdConfirm = new String(passwordConfirmField.getPassword());
        if (paswdConfirm.equals("")) {
            paswdNotEmpty = false;
            invalidField.append("Proszę podać jeszcze raz to samo hasło.\n");
        }
        
        if (!paswdNotEmpty && !paswd.equals(paswdConfirm)) {
            paswdNotEmpty = false;
            invalidField.append("Podane hasła nie zgadzają się.\n");
        } else
            paswdNotEmpty = true;
        
        if (femaleButton.isSelected())
            sexStr = "Kobieta";
        else if (maleButton.isSelected())
            sexStr = "Mężczyzna";
        
        verification = verificationCheckBox.isSelected();
        if (!verification)
            invalidField.append("Proszę potwierdzić, że jesteś człowiekiem.\n");
        
        if (emailNotEmpty && paswdNotEmpty && verification)
            fieldsValid = true;
    }
    
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
