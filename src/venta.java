
import conections.ConnectionSQL;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.ListModel;
import javax.swing.table.TableModel;
import models.Categoria;
import models.DetalleVenta;
import models.FormaPago;
import models.Marca;
import models.Medida;
import models.Producto;
import models.Seccion;
import repositorio.CategoriasRepository;
import repositorio.MarcaRepository;
import repositorio.MedidaRepository;
import repositorio.ProductoRepository;
import repositorio.SeccionRepository;
import repositorio.VentaRepository;
import models.Usuario;
import models.Venta;
import repositorio.DetallesVentaRepository;
import repositorio.FormaPagoRepository;
import repositorio.FormaPagoRepository;

public class venta extends javax.swing.JFrame {

    ConnectionSQL adaptador = new ConnectionSQL();
    Connection conexion = adaptador.Conexion();
    DefaultTableModel modelo;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;

    // Repositorios
    VentaRepository ventaRepository;
    DetallesVentaRepository detallesVentaRepository;
    FormaPagoRepository formapagoRepository;
    ProductoRepository productoRepository;

    public venta() {
        initComponents();
        modelo=(DefaultTableModel)Tabla.getModel();
        setLocationRelativeTo(null);
        modelo = (DefaultTableModel) Tabla.getModel();
        ventaRepository = new VentaRepository(conexion);
        formapagoRepository = new FormaPagoRepository(conexion);
        productoRepository = new ProductoRepository(conexion);
        detallesVentaRepository = new DetallesVentaRepository(conexion);
        SetImageLabel(jLabel7, "src/imagen/ventaa.png");
        this.getContentPane().setBackground(Color.PINK);
        rellenarCombos();
        consulta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxFormaPago = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        txtusuario = new javax.swing.JTextField();
        txtcliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        btnbuscarcliente = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtProductoBusqueda = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listProductos = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe Script", 3, 18)); // NOI18N
        jLabel1.setText("Detalle De Venta");

        jLabel2.setText("Id Usuario:");

        jLabel3.setText("Nit Cliente:");

        jLabel4.setText("Forma De Pago");

        jComboBoxFormaPago.setEditable(true);

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Producto", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabla);

        txtusuario.setBackground(new java.awt.Color(153, 153, 153));
        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });

        txtcliente.setBackground(new java.awt.Color(153, 153, 153));

        jLabel6.setText("Cantidad:");

        txtcantidad.setBackground(new java.awt.Color(153, 153, 153));
        txtcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 204, 255));
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnbuscar.setBackground(new java.awt.Color(153, 204, 255));
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btnbuscarcliente.setBackground(new java.awt.Color(153, 204, 255));
        btnbuscarcliente.setText("Buscar");
        btnbuscarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarclienteActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 204, 255));
        jButton3.setText("Eliminar");

        jButton4.setBackground(new java.awt.Color(255, 51, 51));
        jButton4.setText("Sallir.");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtProductoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductoBusquedaActionPerformed(evt);
            }
        });
        txtProductoBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProductoBusquedaKeyPressed(evt);
            }
        });

        jLabel8.setText("Producto: ");

        listProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listProductos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtusuario, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                    .addComponent(txtcliente)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnbuscar)
                                    .addComponent(btnbuscarcliente)))
                            .addComponent(jComboBoxFormaPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addGap(31, 31, 31)
                        .addComponent(jButton3)
                        .addGap(32, 32, 32)
                        .addComponent(jButton4)))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtProductoBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnbuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnbuscarcliente))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addGap(114, 114, 114))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(4, 4, 4)
                                .addComponent(txtProductoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed

    }//GEN-LAST:event_txtusuarioActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnbuscarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarclienteActionPerformed
        buscarcliente();
    }//GEN-LAST:event_btnbuscarclienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        agregar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantidadActionPerformed

    private void txtProductoBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoBusquedaKeyPressed
        try {
            // TODO add your handling code here:
            var productos = productoRepository.read();
            var model = new DefaultListModel<Producto>();
            var busqueda = txtProductoBusqueda.getText().toUpperCase();

            for (Producto producto : productos) {
                if (producto.getNombre().toUpperCase().contains(busqueda)) {
                    model.addElement(producto);
                }
            }

            listProductos.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(venta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtProductoBusquedaKeyPressed

    private void txtProductoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductoBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoBusquedaActionPerformed

    private void listProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listProductosMouseClicked
        // TODO add your handling code here:
        Producto productoSeleccionado = listProductos.getSelectedValue();
        int cantidad = Integer.parseInt(txtcantidad.getText());

        var model = (DefaultTableModel) Tabla.getModel();
        var row = new Object[3];
        row[0] = productoSeleccionado.getId();
        row[1] = productoSeleccionado.getNombre();
        row[2] = cantidad;

        model.addRow(row);

        // Limpiar Campos Producto
        listProductos.setModel(new DefaultListModel());
        txtcantidad.setText("");
        txtProductoBusqueda.setText("");
    }//GEN-LAST:event_listProductosMouseClicked

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
            java.util.logging.Logger.getLogger(venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new venta().setVisible(true);
            }
        });
    }

    void buscar() {

        try {
            ps = conexion.prepareStatement("Select * from usuario where id=?");
            ps.setString(1, txtusuario.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                txtusuario.setText(rs.getString("nombre"));
            } else {
                JOptionPane.showMessageDialog(this, "No existe una persona con ese id");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    void buscarcliente() {
        try {
            ps = conexion.prepareStatement("Select * from cliente where nit=?");
            ps.setString(1, txtcliente.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                txtcliente.setText(rs.getString("nombre"));
            } else {
                JOptionPane.showMessageDialog(this, "No existe cliente con ese id");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void rellenarCombos() {
        try {
            var formapagos = formapagoRepository.read();

            for (FormaPago formapago : formapagos) {
                jComboBoxFormaPago.addItem(formapago);
            }

        } catch (Exception e) {
            Logger.getLogger(frmformasdepago.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    void buscarproducto() {
      
    }

    void consulta() {

    }

    void agregar() {
        var formaPagoSeleccionada = (FormaPago) jComboBoxFormaPago.getSelectedItem();
        try {
            var ventaCreada = ventaRepository.create(1, 1, formaPagoSeleccionada.getId());

            TableModel productosModel = Tabla.getModel();

            for (int i = 0; i < productosModel.getRowCount(); i++) {
                var productoId = Integer.parseInt(productosModel.getValueAt(i, 0).toString());
                var cantidad = Integer.parseInt(productosModel.getValueAt(i, 2).toString());

                DetalleVenta detalleCreado = detallesVentaRepository.create(cantidad,
                        ventaCreada.getId(),
                        productoId
                );
                
                var producto = productoRepository
                        .read()
                        .stream()
                        .filter(p -> p.getId() == productoId)
                        .findFirst()
                        .orElseThrow();
                        
                var stockActual = Integer.parseInt(producto.getCantidad());
                int nuevoStock = (stockActual - cantidad);
                producto.setCantidad(String.valueOf(nuevoStock));
                
                productoRepository.update(productoId, producto);
            }
            
            JOptionPane.showMessageDialog(this, "Venta guardada");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Venta no guardada");
            Logger.getLogger(venta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void SetImageLabel(JLabel labelName, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        this.repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnbuscarcliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<FormaPago> jComboBoxFormaPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Producto> listProductos;
    private javax.swing.JTextField txtProductoBusqueda;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtcliente;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
