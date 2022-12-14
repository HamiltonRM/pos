/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author rouse
 */
import conections.ConnectionSQL;
import java.awt.Color;
import java.awt.HeadlessException;
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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import models.Categoria;
import repositorio.CategoriasRepository;

public class frmcategorias extends javax.swing.JFrame {

    ConnectionSQL adaptador = new ConnectionSQL();
    Connection conexion = adaptador.Conexion();
    DefaultTableModel modelo;
    Statement st;
    ResultSet rs;
    CategoriasRepository repositorio;

    public frmcategorias() {

        initComponents();
        DefaultTableModel modelo;
         SetImageLabel(jLabel5,"src/imagen/categoria.png");
         this.getContentPane().setBackground(Color.PINK);
        setLocationRelativeTo(null);
        repositorio = new CategoriasRepository(conexion);
        consulta();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        btnsalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtdescripcion = new javax.swing.JTextField();
        btnnuevo = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel1.setText("Categorias o familias de productos.");

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Codigo", "Nombre", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);

        btnsalir.setBackground(new java.awt.Color(255, 51, 51));
        btnsalir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsalir.setText("Salir.");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe Script", 3, 14)); // NOI18N
        jLabel2.setText("Codigo");

        txtcodigo.setBackground(new java.awt.Color(204, 204, 204));
        txtcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcodigoKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe Script", 3, 14)); // NOI18N
        jLabel3.setText("Nombre");

        txtnombre.setBackground(new java.awt.Color(204, 204, 204));
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnombreKeyPressed(evt);
            }
        });

        btnguardar.setBackground(new java.awt.Color(153, 204, 255));
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        btnguardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnguardarKeyPressed(evt);
            }
        });

        btneliminar.setBackground(new java.awt.Color(153, 204, 255));
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnmodificar.setBackground(new java.awt.Color(153, 204, 255));
        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe Script", 3, 14)); // NOI18N
        jLabel4.setText("Descripcion");

        txtdescripcion.setBackground(new java.awt.Color(204, 204, 204));
        txtdescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdescripcionKeyPressed(evt);
            }
        });

        btnnuevo.setBackground(new java.awt.Color(153, 204, 255));
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        txtid.setEditable(false);
        txtid.setBackground(new java.awt.Color(204, 204, 204));
        txtid.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsalir, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(60, 60, 60)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnguardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnmodificar)
                                .addGap(18, 18, 18)
                                .addComponent(btneliminar)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnnuevo)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(144, 144, 144)
                        .addComponent(btnsalir))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnnuevo)
                            .addComponent(btneliminar)
                            .addComponent(btnmodificar)
                            .addComponent(btnguardar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        modificar();
        consulta();
        nuevo();
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        agregar();

    }//GEN-LAST:event_btnguardarActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        try {
            int fila = Tabla.getSelectedRow();
            int id = Integer.parseInt(Tabla.getValueAt(fila, 0).toString());
            PreparedStatement ps;
            ResultSet rs;
            conexion = adaptador.Conexion();
            ps = adaptador.Conexion().prepareStatement("select codigo,nombre,descripcion from categoria where id=?  ");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                txtid.setText(String.valueOf(id));
                txtcodigo.setText(rs.getString("codigo"));
                txtnombre.setText(rs.getString("nombre"));
                txtdescripcion.setText(rs.getString("descripcion"));

            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_TablaMouseClicked


    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        Eliminar();
        consulta();
        nuevo();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        nuevo();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void txtcodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           txtnombre.requestFocus();
       
    }   
    }//GEN-LAST:event_txtcodigoKeyPressed

    private void txtnombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           txtdescripcion.requestFocus();
       
    }   
    }//GEN-LAST:event_txtnombreKeyPressed

    private void txtdescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           btnguardar.requestFocus();
       
    }   
    }//GEN-LAST:event_txtdescripcionKeyPressed

    private void btnguardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnguardarKeyPressed
     if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           agregar();
       
    }   
    }//GEN-LAST:event_btnguardarKeyPressed

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
            java.util.logging.Logger.getLogger(frmcategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmcategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmcategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmcategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmcategorias().setVisible(true);
            }
        });
    }

    void agregar() {
        try {
            Categoria categoriaCreada = repositorio.create(txtcodigo.getText(), txtnombre.getText(), txtdescripcion.getText());
            Object[] fila = new Object[4];
            fila[0] = categoriaCreada.getId();
            fila[1] = categoriaCreada.getCodigo();
            fila[2] = categoriaCreada.getNombre();
            fila[3] = categoriaCreada.getDescripcion();
            modelo.addRow(fila);
            JOptionPane.showMessageDialog(null, "Marca Guardada");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar Marca");
            System.out.println(e);
        }
//        PreparedStatement ps = null;
//        try {
//            ps = adaptador.Conexion().prepareStatement("insert into categoria(codigo,nombre,descripcion)values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, txtcodigo.getText());
//            ps.setString(2, txtnombre.getText());
//            ps.setString(3, txtdescripcion.getText());
//            ps.executeUpdate();
//            ResultSet keys = ps.getGeneratedKeys();
//            keys.next();
//            //categoria.getid
//            Object[] marca = new Object[4];
//            marca[0] = keys.getInt(1);
//            marca[1] = txtcodigo.getText();
//            marca[2] = txtnombre.getText();
//            marca[3] = txtdescripcion.getText();
//            modelo.addRow(marca);
//            JOptionPane.showMessageDialog(null, "Marca Guardada");
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error al guardar Marca");
//            System.out.println(e);
//
//        }

    }

    void consulta() {
        try {
            // Consulta los datos del repositorio
            ArrayList<Categoria> categorias = repositorio.read();

            // Recorre todas las categorias recolectadas por el repositorio
            for (Categoria categoria : categorias) {
                // Crea un nuevo array con los datos para insertar en la fila
                Object[] fila = new Object[4];
                fila[0] = categoria.getId();
                fila[1] = categoria.getCodigo();
                fila[2] = categoria.getNombre();
                fila[3] = categoria.getDescripcion();

                // A??ade la nueva fila a la tabla
                modelo = (DefaultTableModel) Tabla.getModel();
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    void modificar() {
        int id;
        try {
            Categoria categoriaModificada = repositorio.update(id = Integer.parseInt(txtid.getText()), new Categoria(0, txtcodigo.getText(), txtnombre.getText(), txtdescripcion.getText()));
            Object[] fila = new Object[4];
            fila[0] = categoriaModificada.getId();
            fila[1] = categoriaModificada.getCodigo();
            fila[2] = categoriaModificada.getNombre();
            fila[3] = categoriaModificada.getDescripcion();
            modelo.addRow(fila);
            limpiarTabla();
            JOptionPane.showMessageDialog(this, "Categoria modificada");

        } catch (Exception e) {
            System.out.println(e);

        }
    }
//        int id = Integer.parseInt(txtid.getText());
//        String codigo = txtcodigo.getText();
//        String nombre = txtnombre.getText();
//        String descripcion = txtdescripcion.getText();
//        try {
//            conexion = adaptador.Conexion();
//            PreparedStatement ps = null;
//            ps = adaptador.Conexion().prepareStatement("Update categoria set codigo=?,nombre=?,descripcion=? where id=?", Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, codigo);
//            ps.setString(2, nombre);
//            ps.setString(3, descripcion);
//            ps.setInt(4, id);
//            ps.executeUpdate();
//            ResultSet keys = ps.getGeneratedKeys();
//            keys.next();
//
//            JOptionPane.showMessageDialog(null, "Dato de Categoria Modificado");
//            limpiarTabla();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }

    void limpiarTabla() {
        for (int i = 0; i < Tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    void Eliminar() {
        int id = Integer.parseInt(txtid.getText());
        try {
            repositorio.delete(id);
            JOptionPane.showMessageDialog(null, "Registro eliminado");
            limpiarTabla();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void nuevo() {
        txtcodigo.setText("");
        txtnombre.setText("");
        txtdescripcion.setText("");

    }
    private void SetImageLabel(JLabel labelName,String root){
    ImageIcon image=new ImageIcon(root);
    Icon icon=new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(),labelName.getHeight(),Image.SCALE_DEFAULT));
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
