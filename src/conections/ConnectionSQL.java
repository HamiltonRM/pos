
package conections;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import javax.swing.JOptionPane;
    public class ConnectionSQL {
        Connection Conectar=null;

        public Connection Conexion(){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Conectar=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto","root","rouham2002");

       }catch (Exception e){
           JOptionPane.showMessageDialog(null, "Error de conexion"+e.getMessage());
       }
   
       return Conectar;
    }

  
    }

    