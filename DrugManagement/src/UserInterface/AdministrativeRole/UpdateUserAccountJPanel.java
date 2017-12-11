/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdministrativeRole;

import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Sumanth
 */
public class UpdateUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form UpdateUserAccountJPanel
     */
    public UpdateUserAccountJPanel() {
        
    }
    
    JPanel container;
    UserAccount u;

    UpdateUserAccountJPanel(JPanel container, UserAccount u) {
        initComponents();
        this.container = container;
        this.u = u;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vacName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(vacName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 130, 30));

        jLabel1.setText("User Name:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 90, 30));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 209, 100, 40));

        addBtn.setText("Update");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 90, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Update User");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 190, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        container.remove(this);
        Component[] componentArray = container.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageUserAccountJPanel sysAdminwjp = (ManageUserAccountJPanel) component;
        sysAdminwjp.popData();
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        String name = vacName.getText();
        if(name.trim().length()==0){
            JOptionPane.showMessageDialog(null, "Please enter User Name");
            return;
        }
        if ( !(name.matches("^[a-zA-Z0-9]+$"))) {
                  JOptionPane.showMessageDialog(null,"No Special characters for User Name");
                  return;
            }
        u.setUsername(name);
        JOptionPane.showMessageDialog(null, "Employee Updated Successfully");
    }//GEN-LAST:event_addBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField vacName;
    // End of variables declaration//GEN-END:variables
}
