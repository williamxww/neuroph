package org.neuroph.netbeans.visual.dialogs;

import java.util.ArrayList;
import org.neuroph.core.Neuron;
import org.neuroph.core.input.InputFunction;
import org.neuroph.core.transfer.TransferFunction;
import org.neuroph.netbeans.visual.widgets.NeuralNetworkScene;
import org.neuroph.util.Neuroph;
import org.openide.util.Exceptions;

/**
 *
 * @author Uros
 */
public class ChangeInputFunctionDialog extends javax.swing.JDialog {

    /**
     * Creates new form ChangeInputFunctionDialog
     */
    Neuron neuron;
    NeuralNetworkScene scene;
    public ChangeInputFunctionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public ChangeInputFunctionDialog(java.awt.Frame parent, boolean modal, Neuron neuron, NeuralNetworkScene scene) {
        super(parent, modal);
        this.neuron = neuron;
        this.scene = scene;
        initComponents();
        fillCombo();
    }

    public final void fillCombo() {
        ArrayList inputFuncs = Neuroph.getInstance().getInputFunctions();
        javax.swing.DefaultComboBoxModel inputFunctionComboBoxModel = (new javax.swing.DefaultComboBoxModel(inputFuncs.toArray()));
        inputFunctionComboBox.setModel(inputFunctionComboBoxModel);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel changeInputFunctionLabel = new javax.swing.JLabel();
        inputFunctionComboBox = new javax.swing.JComboBox();
        changeInputFunctionButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        org.openide.awt.Mnemonics.setLocalizedText(changeInputFunctionLabel, org.openide.util.NbBundle.getMessage(ChangeInputFunctionDialog.class, "ChangeInputFunctionDialog.changeInputFunctionLabel.text")); // NOI18N
        changeInputFunctionLabel.setToolTipText(org.openide.util.NbBundle.getMessage(ChangeInputFunctionDialog.class, "ChangeInputFunctionDialog.changeInputFunctionLabel.toolTipText")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(changeInputFunctionButton, org.openide.util.NbBundle.getMessage(ChangeInputFunctionDialog.class, "ChangeInputFunctionDialog.changeInputFunctionButton.text")); // NOI18N
        changeInputFunctionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeInputFunctionButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cancelButton, org.openide.util.NbBundle.getMessage(ChangeInputFunctionDialog.class, "ChangeInputFunctionDialog.cancelButton.text")); // NOI18N
        cancelButton.setToolTipText(org.openide.util.NbBundle.getMessage(ChangeInputFunctionDialog.class, "ChangeInputFunctionDialog.cancelButton.toolTipText")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(changeInputFunctionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputFunctionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(changeInputFunctionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeInputFunctionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputFunctionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(changeInputFunctionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changeInputFunctionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeInputFunctionButtonActionPerformed
        try {
            Class<? extends InputFunction> inputFunctionClass = (Class<? extends InputFunction>) Class.forName("org.neuroph.core.input." + ((String) inputFunctionComboBox.getSelectedItem()).trim());
            scene.getNetworkEditor().setNeuronInputFunction(neuron, inputFunctionClass.newInstance());
        } catch (InstantiationException ex) {
            Exceptions.printStackTrace(ex);
        } catch (IllegalAccessException ex) {
            Exceptions.printStackTrace(ex);
        } catch (ClassNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_changeInputFunctionButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChangeInputFunctionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeInputFunctionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeInputFunctionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeInputFunctionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChangeInputFunctionDialog dialog = new ChangeInputFunctionDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton changeInputFunctionButton;
    private javax.swing.JComboBox inputFunctionComboBox;
    // End of variables declaration//GEN-END:variables
}
