package github.jsonta.quiz;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class PasswdResetPanel extends JPanel implements ThreadCompleteListener, WindowListener {
    public PasswdResetPanel() {
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

        jLabel1 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        requestPwdRstBttn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Podaj adres e-mail użyty do rejestracji Twojego konta");

        requestPwdRstBttn.setText("Zresetuj hasło");
        requestPwdRstBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestPwdRstBttnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emailTextField))
                    .addComponent(requestPwdRstBttn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(requestPwdRstBttn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void requestPwdRstBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestPwdRstBttnActionPerformed
        uiControl(false);
        String email = emailTextField.getText();
        
        if (!email.isEmpty()) {
            Matcher m = emailRegex.matcher(email);
            if (m.find()) {
                thread = new PasswdResetThread(email);
                thread.setName("Password reset request");
                thread.addListener(this);
                thread.start();
            } else {
                 JOptionPane.showMessageDialog(this.getRootPane(), "Proszę podać poprawny adres e-mail.", "Komunikat", JOptionPane.ERROR_MESSAGE);
                 uiControl(true);
            }
        } else {
            JOptionPane.showMessageDialog(this.getRootPane(), "Proszę podać adres e-mail przypisany do konta, którego hasło chcesz zresetować.", "Komunikat", JOptionPane.ERROR_MESSAGE);
            uiControl(true);
        }
    }//GEN-LAST:event_requestPwdRstBttnActionPerformed
    
    private void uiControl(boolean flip) {
        emailTextField.setEnabled(flip);
        requestPwdRstBttn.setEnabled(flip);
    }
    
    @Override
    public void notifyOfThreadComplete(Thread t) {
        if (t.getName().equals("Password reset request")) {
            if (thread.didRequestSend())
                JOptionPane.showMessageDialog(this.getRootPane(), "Żądanie resetowania hasła zostało wysłane. Sprawdź swoją skrzynkę odbiorczą.", "Komunikat", JOptionPane.INFORMATION_MESSAGE);
            
            uiControl(true);
        }
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        JOptionPane.showMessageDialog(this.getRootPane(), "Możliwość resetowania hasła nie została jeszcze zaimplementowana.", "Komunikat", JOptionPane.WARNING_MESSAGE);
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
    
    private final Pattern emailRegex = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
    private PasswdResetThread thread;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton requestPwdRstBttn;
    // End of variables declaration//GEN-END:variables
}
