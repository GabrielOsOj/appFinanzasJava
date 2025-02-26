
package com.gbcomp.proyjavaybdd.view;

import com.gbcomp.proyjavaybdd.contoller.DBController;
import com.gbcomp.proyjavaybdd.model.dto.DTOtransaction;
import graphs.Grafico;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author cuent
 */
public class window extends javax.swing.JFrame implements ListSelectionListener {

    DBController controlador;
    int filaSeleccionada = -1;
    ArrayList<DTOtransaction> transacciones;

    /**
     * Creates new form window
     */
    public window() {
        initComponents();
        this.cargarIcono();
        
        this.controlador = new DBController();
        this.manejadorEventosTabla();

        this.cargarDesdeBDD();
        this.cargarGrafico();
        this.cargarTotales();
    }

    /* Cargar datos*/
    
    private void cargarIcono(){
        
        /*
            \\src\\resources\\dbAppFinanzas.db
         System.getProperty("user.dir")
        
        */
        String path = System.getProperty("user.dir")+"/src/resources/financeLogo.ico";
        
        ImageIcon icon = new ImageIcon(path);
        this.setIconImage(icon.getImage());
        
    }
    
    private void cargarGrafico() {

        this.pGraficoGrafico.setLayout(new java.awt.BorderLayout());

        Grafico g = new Grafico();

        ChartPanel grafico = (ChartPanel) g.crearGrafico(this.controlador.seleccionarGastos());

        this.pGraficoGrafico.setPreferredSize(new Dimension(250, 250));

        this.pGraficoGrafico.add(grafico, BorderLayout.CENTER);
        this.pGrafico.validate();

    }

    private void cargarDesdeBDD() {

        DefaultTableModel modeloTabla = (DefaultTableModel) this.tTransacciones.getModel();
        modeloTabla.setRowCount(0);

        this.transacciones = this.controlador.seleccionarTodo();

        for (DTOtransaction dtoT : this.transacciones) {

            modeloTabla.addRow(new Object[]{dtoT.getFecha(), dtoT.getDescripcion(), dtoT.getNombreCategoria(), dtoT.getTotal()});

            
        }

    }

    private void cargarTotales() {

        this.lbteIngresos
                .setText(String.valueOf(this.controlador.obtIngresos().intValue()));

        this.lbteGastos
                .setText(String.valueOf(this.controlador.obtGastos().intValue()));

        this.lbteBalance.setText(String.valueOf(this.controlador.obtIngresos() - this.controlador.obtGastos()));

    }

    private void manejadorEventosTabla() {
        this.tTransacciones.getSelectionModel().addListSelectionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pPrincipal = new javax.swing.JPanel();
        pGrafico = new javax.swing.JPanel();
        pGraficoCabecera = new javax.swing.JPanel();
        pGraficoGrafico = new javax.swing.JPanel();
        pDetalles = new javax.swing.JPanel();
        spTransacciones = new javax.swing.JScrollPane();
        tTransacciones = new javax.swing.JTable();
        pDetallesBotones = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        pBalances = new javax.swing.JPanel();
        pIngresos = new javax.swing.JPanel();
        lbIngresos = new javax.swing.JLabel();
        lbteIngresos = new javax.swing.JLabel();
        pGastos = new javax.swing.JPanel();
        lbGastos = new javax.swing.JLabel();
        lbteGastos = new javax.swing.JLabel();
        pBalance = new javax.swing.JPanel();
        lbBalance = new javax.swing.JLabel();
        lbteBalance = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Finanzas");

        javax.swing.GroupLayout pGraficoCabeceraLayout = new javax.swing.GroupLayout(pGraficoCabecera);
        pGraficoCabecera.setLayout(pGraficoCabeceraLayout);
        pGraficoCabeceraLayout.setHorizontalGroup(
            pGraficoCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );
        pGraficoCabeceraLayout.setVerticalGroup(
            pGraficoCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pGraficoGraficoLayout = new javax.swing.GroupLayout(pGraficoGrafico);
        pGraficoGrafico.setLayout(pGraficoGraficoLayout);
        pGraficoGraficoLayout.setHorizontalGroup(
            pGraficoGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pGraficoGraficoLayout.setVerticalGroup(
            pGraficoGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pGraficoLayout = new javax.swing.GroupLayout(pGrafico);
        pGrafico.setLayout(pGraficoLayout);
        pGraficoLayout.setHorizontalGroup(
            pGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pGraficoCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pGraficoGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pGraficoLayout.setVerticalGroup(
            pGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGraficoLayout.createSequentialGroup()
                .addComponent(pGraficoCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pGraficoGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        spTransacciones.setBorder(null);

        tTransacciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Descripcion", "Categoria", "Monto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTransacciones.setViewportView(tTransacciones);
        if (tTransacciones.getColumnModel().getColumnCount() > 0) {
            tTransacciones.getColumnModel().getColumn(0).setResizable(false);
            tTransacciones.getColumnModel().getColumn(1).setResizable(false);
            tTransacciones.getColumnModel().getColumn(2).setResizable(false);
        }

        pDetallesBotones.setLayout(new java.awt.GridLayout(1, 0));

        btnAgregar.setText("Añadir");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        pDetallesBotones.add(btnAgregar);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        pDetallesBotones.add(btnEliminar);

        pBalances.setLayout(new java.awt.GridLayout(1, 3));

        pIngresos.setLayout(new java.awt.GridLayout(1, 2));

        lbIngresos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIngresos.setText("Ingresos: $");
        pIngresos.add(lbIngresos);

        lbteIngresos.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        lbteIngresos.setForeground(new java.awt.Color(0, 0, 0));
        pIngresos.add(lbteIngresos);

        pBalances.add(pIngresos);

        pGastos.setLayout(new java.awt.GridLayout(1, 0));

        lbGastos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbGastos.setText("Gastos: $");
        pGastos.add(lbGastos);

        lbteGastos.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        lbteGastos.setForeground(new java.awt.Color(0, 0, 0));
        pGastos.add(lbteGastos);

        pBalances.add(pGastos);

        pBalance.setLayout(new java.awt.GridLayout(1, 0));

        lbBalance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBalance.setText("Balance: $");
        pBalance.add(lbBalance);

        lbteBalance.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        lbteBalance.setForeground(new java.awt.Color(0, 0, 0));
        pBalance.add(lbteBalance);

        pBalances.add(pBalance);

        javax.swing.GroupLayout pDetallesLayout = new javax.swing.GroupLayout(pDetalles);
        pDetalles.setLayout(pDetallesLayout);
        pDetallesLayout.setHorizontalGroup(
            pDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDetallesLayout.createSequentialGroup()
                .addGroup(pDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDetallesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pDetallesBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spTransacciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(pDetallesLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(pBalances, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pDetallesLayout.setVerticalGroup(
            pDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spTransacciones, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(pBalances, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pDetallesBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pPrincipalLayout = new javax.swing.GroupLayout(pPrincipal);
        pPrincipal.setLayout(pPrincipalLayout);
        pPrincipalLayout.setHorizontalGroup(
            pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrincipalLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(pGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        pPrincipalLayout.setVerticalGroup(
            pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPrincipalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        AgregarTransaccion agregarTransaccion = new AgregarTransaccion(this, true);
        agregarTransaccion.setControlador(controlador);
        agregarTransaccion.setVisible(true);

        this.cargarDesdeBDD();
        this.cargarTotales();
        this.cargarGrafico();

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        if (this.filaSeleccionada == -1) {

            JOptionPane.showMessageDialog(this, "Seleccione una transaccion para eliminar!", "ERROR", JOptionPane.WARNING_MESSAGE);
            return;
        }

        this.controlador.eliminar(this.transacciones.get(filaSeleccionada).getIdTransaccion());

        this.cargarDesdeBDD();
        this.cargarTotales();
        this.cargarGrafico();
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel lbBalance;
    private javax.swing.JLabel lbGastos;
    private javax.swing.JLabel lbIngresos;
    private javax.swing.JLabel lbteBalance;
    private javax.swing.JLabel lbteGastos;
    private javax.swing.JLabel lbteIngresos;
    private javax.swing.JPanel pBalance;
    private javax.swing.JPanel pBalances;
    private javax.swing.JPanel pDetalles;
    private javax.swing.JPanel pDetallesBotones;
    private javax.swing.JPanel pGastos;
    private javax.swing.JPanel pGrafico;
    private javax.swing.JPanel pGraficoCabecera;
    private javax.swing.JPanel pGraficoGrafico;
    private javax.swing.JPanel pIngresos;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JScrollPane spTransacciones;
    private javax.swing.JTable tTransacciones;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(ListSelectionEvent e) {

        this.filaSeleccionada = this.tTransacciones.getSelectedRow();

    }
}