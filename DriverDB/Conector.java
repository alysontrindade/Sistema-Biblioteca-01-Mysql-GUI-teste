import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
    //conexao remote mysql
    static String db = "lkPfVUelHy";
    static String url = "jdbc:mysql://remotemysql.com:3306/"+db;
    static String usuario = "lkPfVUelHy";
    static String senha = "7oJfPDxKPp";
    static Connection con;

    //conexao db4free
    // static String db = "exemplo01";
    // static String url = "jdbc:mysql://remotemysql.com:3306/"+db;
    // static String usuario = "alysontrindadef";
    // static String senha = "Greyhound.172510";
    // static Connection con;

    public static Connection getConexao() throws SQLException{
        try{
            if(con == null){
                con = (Connection) DriverManager.getConnection(url, usuario, senha);
            }
            return con;
        }catch(SQLException e){
            throw new SQLException(e.getMessage());
        }
    }
}