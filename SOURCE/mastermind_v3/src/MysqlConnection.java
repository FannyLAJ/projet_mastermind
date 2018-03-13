import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


public class MysqlConnection {
    private static String url = "jdbc:mysql://localhost/mastermind";
    private static String user = "java";
    private static String password = "java";
    private static Connection connect;

    public MysqlConnection() {
        try {
            LoadBDD();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadBDD() throws Exception {
        /**
         * Chargement du driver JDBC pour MySQL
         * return false si driver non présent
         */
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance() {
        if(connect == null){
            try {
                connect = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }

    public void CloseConnection() throws Exception {
        /**
         * Ferme la connexion à la BDD
         * return true || false
         */
        try {
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
