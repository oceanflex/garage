package guiIO;

import garage.CarInTerm;
import garage.CarOutTerm;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

/**
 *
 * @author Zachary
 */
public class TicketTaker extends javax.swing.JFrame {
    private CarInTerm in;
    private CarOutTerm out;
    /**
     * Creates new form TicketGiver
     */
    public TicketTaker(CarInTerm in,CarOutTerm out) {
        initComponents();
        this.in = in;
        this.out = out;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        carId = new javax.swing.JTextField();
        releaseCar = new javax.swing.JButton();
        copyTicket = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Exit");

        releaseCar.setText("check out");
        releaseCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                releaseCarActionPerformed(evt);
            }
        });

        copyTicket.setText("give ticket");
        copyTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyTicketActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(copyTicket)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(carId, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(releaseCar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(releaseCar)
                    .addComponent(copyTicket))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void releaseCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_releaseCarActionPerformed
        if(carId.getText().length()<10&&carId.getText().matches("^\\d+$")){
            out.releaseCar(Integer.parseInt(carId.getText()), true);
        }
    }//GEN-LAST:event_releaseCarActionPerformed

    private void copyTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyTicketActionPerformed
        //StringSelection selection = new StringSelection("");
        //Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        //clipboard.getContents(selection);
    }//GEN-LAST:event_copyTicketActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField carId;
    private javax.swing.JButton copyTicket;
    private javax.swing.JButton releaseCar;
    // End of variables declaration//GEN-END:variables
}
