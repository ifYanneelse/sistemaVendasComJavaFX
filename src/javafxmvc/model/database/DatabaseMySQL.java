package javafxmvc.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael Vargas Mesquita
 */
public class DatabaseMySQL implements Database {

    private Connection connection;

    @Override
    public Connection conectar() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
//            Class.forName("com.mysql.jdbc.Driver");
//            this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/javafxmvc", "postgres","postgres");
            final String URL = 
//                "jdbc:mysql://127.0.0.1/javafxmvc?useTimezone=true&serverTimezone=UTC";
                  "jdbc:mariadb://localhost:3306/javafxmvc";
//                "jdbc:mysql://localhost/javafxmvc?useTimezone=true&serverTimezone=UTC";
            final String USER = "root";
            final String PWD = "";
            this.connection = DriverManager.getConnection(URL, USER, PWD);
            return this.connection;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DatabasePostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void desconectar(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabasePostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
