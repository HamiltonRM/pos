
import ComboBox.rellenarComboMedida;
import ComboBox.rellenarCombos;

import ComboBox.rellenarComboSeccion;
import ComboBox.rellenarComboCategoria;

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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import models.Categoria;
import models.Marca;
import models.Medida;
import models.Producto;
import models.Seccion;
import repositorio.CategoriasRepository;
import repositorio.MarcaRepository;
import repositorio.MedidaRepository;
import repositorio.ProductoRepository;
import repositorio.SeccionRepository;

public class frmproductos extends javax.swing.JFrame {

    ConnectionSQL adaptador = new ConnectionSQL();
    Connection conexion = adaptador.Conexion();
    DefaultTableModel modelo;
    Statement st;
    ResultSet rs;
    
    // Repositorios
    ProductoRepository productoRepository;
    CategoriasRepository categoriasRepository;
    MedidaRepository medidaRepository;
    SeccionRepository seccionRepository;
    MarcaRepository marcaRepository;

    rellenarCombos re = new rellenarCombos();
    rellenarComboMedida me = new rellenarComboMedida();
    rellenarComboSeccion se = new rellenarComboSeccion();
    rellenarComboCategoria ca = new rellenarComboCategoria();

    public frmproductos() {
        initComponents();
        modelo=(DefaultTableModel)Tabla.getModel();
        SetImageLabel(jLabel7, "src/imagen/producto.png");
        this.getContentPane().setBackground(Color.PINK);
        setLocationRelativeTo(null);
        modelo = (DefaultTableModel) Tabla.getModel();
        
        // Repositorios
        productoRepository = new ProductoRepository(conexion);
        categoriasRepository = new CategoriasRepository(conexion);
        medidaRepository = new MedidaRepository(conexion);
        seccionRepository = new SeccionRepository(conexion);
        marcaRepository = new MarcaRepository(conexion);
        
        rellenarCombos();
        consulta2();
    }
    
    void rellenarCombos() {
        try {
            var categorias = categoriasRepository.read();
            var medidas = medidaRepository.read();
            var secciones = seccionRepository.read();
            var marcas = marcaRepository.read();
            
            for (Categoria categoria : categorias) {
                jComboBoxCategoria.addItem(categoria);
            }
            
            for (Medida medida : medidas) {
                jComboBoxMedida.addItem(medida);
            }
            
            for (Seccion seccion : secciones) {
                jComboBoxSeccion.addItem(seccion);
            }
            
            for (Marca marca : marcas) {
                jComboBoxMarca.addItem(marca);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmproductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jComboBoxMarca = new javax.swing.JComboBox<>();
        jComboBoxMedida = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxSeccion = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        identificador = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        btnnuevo = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 3, 18)); // NOI18N
        jLabel1.setText("Productos.");

        jLabel2.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel2.setText("Nombre");

        txtnombre.setBackground(new java.awt.Color(204, 204, 204));
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnombreKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel3.setText("Cantidad");

        txtcantidad.setBackground(new java.awt.Color(204, 204, 204));
        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcantidadKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Baskerville Old Face", 3, 14)); // NOI18N
        jLabel4.setText("Ingresar Producto.");

        jLabel5.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel5.setText("Precio");

        txtprecio.setBackground(new java.awt.Color(204, 204, 204));
        txtprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtprecioKeyPressed(evt);
            }
        });

        Tabla.setBackground(new java.awt.Color(153, 204, 255));
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nombre", "Cantidad", "Precio", "Codigo", "Marca", "Medida", "Seccion", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel6.setText("Sistema informatico.");

        btnsalir.setBackground(new java.awt.Color(255, 0, 0));
        btnsalir.setText("Salir.");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btneliminar.setBackground(new java.awt.Color(153, 204, 255));
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnguardar.setBackground(new java.awt.Color(153, 204, 255));
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnmodificar.setBackground(new java.awt.Color(153, 204, 255));
        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel8.setText("Marca ");

        jLabel9.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel9.setText("Medida");

        jComboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoriaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel10.setText("Codigo");

        txtcodigo.setBackground(new java.awt.Color(204, 204, 204));

        jComboBoxMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMarcaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel11.setText("Seccion");

        jLabel12.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel12.setText("Categoria");

        identificador.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        identificador.setText("identificador");

        txtid.setEditable(false);
        txtid.setEnabled(false);

        btnnuevo.setBackground(new java.awt.Color(153, 204, 255));
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(256, 256, 256)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsalir))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1)
                                .addGap(142, 142, 142))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBoxMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel11)
                                    .addComponent(jComboBoxSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(jComboBoxMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(58, 58, 58)
                                        .addComponent(btnguardar)
                                        .addGap(69, 69, 69)
                                        .addComponent(btnmodificar)
                                        .addGap(45, 45, 45)
                                        .addComponent(btneliminar)
                                        .addGap(44, 44, 44)
                                        .addComponent(btnnuevo))
                                    .addComponent(identificador, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(identificador)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 15, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnnuevo)
                            .addComponent(btneliminar)
                            .addComponent(btnmodificar)
                            .addComponent(btnguardar))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnsalirActionPerformed

    private void jComboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaActionPerformed

    }//GEN-LAST:event_jComboBoxCategoriaActionPerformed

    private void jComboBoxMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMarcaActionPerformed

    }//GEN-LAST:event_jComboBoxMarcaActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        agregar();


    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        modificar();
        consulta2();
        nuevo();
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        try {
            int fila = Tabla.getSelectedRow();
            int id = Integer.parseInt((Tabla.getValueAt(fila, 0).toString()));
            PreparedStatement ps;
            ResultSet rs;
            conexion = adaptador.Conexion();
            ps = adaptador.Conexion().prepareStatement("select nombre,cantidad,precio,codigo,marca_id,medida_id,seccion_id,categoria_id from producto where id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                txtid.setText(String.valueOf(id));
                txtnombre.setText(rs.getString("nombre"));
                txtcantidad.setText(rs.getString("cantidad"));
                txtprecio.setText(rs.getString("precio"));
                txtcodigo.setText(rs.getString("codigo"));
                jComboBoxMarca.getSelectedItem().toString();
                jComboBoxMedida.getSelectedItem().toString();
                jComboBoxSeccion.getSelectedItem().toString();
                jComboBoxCategoria.getSelectedItem().toString();

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_TablaMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        eliminar();
        consulta2();
        nuevo();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        nuevo();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void txtnombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtcantidad.requestFocus();

        }
    }//GEN-LAST:event_txtnombreKeyPressed

    private void txtcantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtprecio.requestFocus();

        }
    }//GEN-LAST:event_txtcantidadKeyPressed

    private void txtprecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtcodigo.requestFocus();

        }
    }//GEN-LAST:event_txtprecioKeyPressed

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
            java.util.logging.Logger.getLogger(frmproductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmproductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmproductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmproductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmproductos().setVisible(true);
            }
        });
    }

    void consulta2() {
        try {
            ArrayList<Producto> productos = productoRepository.read();

            for (Producto producto : productos) {
                Object[] fila = new Object[9];
                fila[0] = producto.getId();
                fila[1] = producto.getNombre();
                fila[2] = producto.getCantidad();
                fila[3] = producto.getPrecio();
                fila[4] = producto.getCodigo();
                fila[5] = producto.getMarca_id();
                fila[6] = producto.getMedida_id();
                fila[7] = producto.getSeccion_id();
                fila[8] = producto.getCategoria_id();

                modelo = (DefaultTableModel) Tabla.getModel();
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void limpiarTabla() {
        for (int i = 0; i < Tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    void agregar() {

        try {
            Marca marcaSeleccionada = (Marca)jComboBoxMarca.getSelectedItem();
            Seccion seccionSeleccionada=(Seccion)jComboBoxSeccion.getSelectedItem();
            Medida medidaSeleccionada=(Medida)jComboBoxMedida.getSelectedItem();
            Categoria categoriaSeleccionada=(Categoria)jComboBoxCategoria.getSelectedItem();
            
            Producto productoCREADO = productoRepository.create(
                    txtnombre.getText(), 
                    txtcantidad.getText(), 
                    txtprecio.getText(), 
                    txtcodigo.getText(), 
                    marcaSeleccionada.getId(), 
                    medidaSeleccionada.getId(),
                    seccionSeleccionada.getId(), 
                    categoriaSeleccionada.getId()
            );

            Object[] fila = new Object[9];
            fila[0] = productoCREADO.getId();
            fila[1] = productoCREADO.getNombre();
            fila[2] = productoCREADO.getCantidad();
            fila[3] = productoCREADO.getPrecio();
            fila[4] = productoCREADO.getCodigo();
            fila[5] = productoCREADO.getMarca_id();
            fila[6] = productoCREADO.getMedida_id();
            fila[7] = productoCREADO.getSeccion_id();
            fila[8] = productoCREADO.getCategoria_id();

            modelo.addRow(fila);
            JOptionPane.showMessageDialog(this, "Producto Guardado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar producto");
            System.out.println(e);
        }

    }

    void modificar() {
        int id;
        try {
            Producto productoModificado = productoRepository.update(id = Integer.parseInt(txtid.getText()), new Producto(0, txtnombre.getText(), txtcantidad.getText(), txtprecio.getText(), txtcodigo.getText(), Integer.parseInt(jComboBoxMarca.getSelectedItem().toString()), Integer.parseInt(jComboBoxMedida.getSelectedItem().toString()), Integer.parseInt(jComboBoxSeccion.getSelectedItem().toString()), Integer.parseInt(jComboBoxCategoria.getSelectedItem().toString())));
            Object[] fila = new Object[9];
            fila[0] = productoModificado.getId();
            fila[1] = productoModificado.getNombre();
            fila[2] = productoModificado.getCantidad();
            fila[3] = productoModificado.getPrecio();
            fila[4] = productoModificado.getCodigo();
            fila[5] = productoModificado.getMarca_id();
            fila[6] = productoModificado.getMedida_id();
            fila[7] = productoModificado.getSeccion_id();
            fila[8] = productoModificado.getCategoria_id();

            modelo.addRow(fila);
            limpiarTabla();
            JOptionPane.showMessageDialog(this, "Producto Modificado");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al modificar Producto");
            System.out.println(e);
        }
    }

    void eliminar() {
        int id = Integer.parseInt(txtid.getText());
        try {
            productoRepository.delete(id);
            JOptionPane.showMessageDialog(this, "Registro eliminado");
            limpiarTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
            System.out.println(e);
        }
    }

    void nuevo() {
        txtid.setText("");
        txtnombre.setText("");
        txtcantidad.setText("");
        txtprecio.setText("");
        txtcodigo.setText("");

    }

    private void SetImageLabel(JLabel labelName, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        this.repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel identificador;
    private javax.swing.JComboBox<Categoria> jComboBoxCategoria;
    private javax.swing.JComboBox<Marca> jComboBoxMarca;
    private javax.swing.JComboBox<Medida> jComboBoxMedida;
    private javax.swing.JComboBox<Seccion> jComboBoxSeccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
}
