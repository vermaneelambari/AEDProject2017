/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PreClinicalTrialRole;

import Business.ClinicalReport.ClinicalReport;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PreClinicalTrialOrganization;
import Business.Request.Request;
import Business.Request.WorkRequest;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sumanth
 */
public class PreClinicalTrialJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PreClinicalTrialJPanel
     */
    JPanel userProcessContainer;
    UserAccount account;
    Organization organization;
    Enterprise enterprise;
    EcoSystem system;

    public PreClinicalTrialJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = (PreClinicalTrialOrganization) organization;
        this.enterprise = enterprise;
        this.system = system;
        enterPrText.setText(enterprise.getName());
        orgText.setText(organization.getName());
        empNameTxt.setText(account.getEmployee().getName());
        populateTable();
    }

    void populateTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        model.setRowCount(0);
        for (Request request : organization.getRequestList().getRequestList()) {
            Object[] row = new Object[5];
            row[0] = request.getSender();
            row[1] = request;
            row[2] = request.getSender().getEmployee().getName();
            row[3] = account;
            row[4] = request.getStatus();
            model.addRow(row);
        }
    }

    boolean validateDrug(Request request) {
        for (Request r : organization.getRequestList().getRequestList()) {
            if (request.getPharmaAcc().getEmployee().getName().equals(r.getPharmaAcc().getEmployee().getName())) {
                if (!r.isDrugValid()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        approveBtn = new javax.swing.JButton();
        enterpriseLabel1 = new javax.swing.JLabel();
        empNameTxt = new javax.swing.JLabel();
        enterpriseLabel2 = new javax.swing.JLabel();
        enterPrText = new javax.swing.JLabel();
        enterpriseLabel3 = new javax.swing.JLabel();
        orgText = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User who raised request", "Message", "Sender", "Receiver", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 730, 130));

        approveBtn.setText("Process Request");
        approveBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 255, 204), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 255, 0)));
        approveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveBtnActionPerformed(evt);
            }
        });
        add(approveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 150, 40));

        enterpriseLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel1.setText("Employee Name:");
        add(enterpriseLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        empNameTxt.setText("<Value>");
        add(empNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 230, 20));

        enterpriseLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel2.setText("EnterPrise :");
        add(enterpriseLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        enterPrText.setText("<value>");
        add(enterPrText, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 260, 20));

        enterpriseLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel3.setText("Organization:");
        add(enterpriseLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 50, 130, -1));

        orgText.setText("<value>");
        add(orgText, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 300, 20));

        jButton1.setText("Complete Request");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 255, 204), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(255, 255, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 293, 130, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void approveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveBtnActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select Any Row");
            return;
        }
        String status = (String) workRequestJTable.getValueAt(selectedRow, 4);
        WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 1);
        boolean drugValid;
        drugValid = validateDrug(request);
        if (drugValid == false) {
            JOptionPane.showMessageDialog(null, "Following request has been denied as Drug is banned");
            return;
        }
        if (status.equals("Approved drug for Initial Test")) {
            PreClinicalTrialProcessJpanel muajp = new PreClinicalTrialProcessJpanel(userProcessContainer, account, organization, enterprise, system, request);
            userProcessContainer.add("PreClinicalTrialProcessJpanel", muajp);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
            populateTable();
        } else {
            JOptionPane.showMessageDialog(null, "Already approved");
            return;
        }
    }//GEN-LAST:event_approveBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select Any Row");
            return;
        }
        String status = (String) workRequestJTable.getValueAt(selectedRow, 4);
        WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 1);
        boolean drugValid;
        drugValid = validateDrug(request);
        if (drugValid == false) {
            JOptionPane.showMessageDialog(null, "Following request has been denied as Drug is banned");
            return;
        }
        if (status.equals("Approved drug for Initial Test")) {
            if (request.getClinicalReportDirectory().getClinicalReportDirectory().size() == 0) {
                JOptionPane.showMessageDialog(null, "Request is not processed");
                return;
            } else {
                PreClinicalTrialSendEmailJPanel muajp = new PreClinicalTrialSendEmailJPanel(userProcessContainer, account, organization, enterprise, system, request);
                userProcessContainer.add("PreClinicalTrialSendEmailJPanel", muajp);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Request already approved and sent");
            return;
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approveBtn;
    private javax.swing.JLabel empNameTxt;
    private javax.swing.JLabel enterPrText;
    private javax.swing.JLabel enterpriseLabel1;
    private javax.swing.JLabel enterpriseLabel2;
    private javax.swing.JLabel enterpriseLabel3;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel orgText;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
