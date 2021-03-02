import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class AlunoDAO {
  public AlunoDAO() {}

  public static boolean insert(Aluno al){
    String sql = "insert into aluno (cpf, nome) values (?,?)";
    try {
      PreparedStatement ps = Conector.getConexao().prepareStatement(sql);
      ps.setString(1, al.getCpf());
      ps.setString(2, al.getNome());
    
      ps.execute(); 

      return true;
    } catch (SQLException e) {
      e.printStackTrace();

      return false;
    }
  }

  public static boolean update(Aluno al){
    String sql = "update aluno set cpf=?, nome=? where cpf=?";
    try {
      PreparedStatement ps = Conector.getConexao().prepareStatement(sql);
      ps.setString(1, al.getCpf());
      ps.setString(2, al.getNome());
      ps.setString(3, al.getCpf());

      ps.execute(); 

      return true;
    } catch (SQLException e) {
      e.printStackTrace();

      return false;
    }
  }

  public static boolean delete(Aluno al){
    String sql = "delete from aluno where cpf=?";
    try {
      PreparedStatement ps = Conector.getConexao().prepareStatement(sql);
      ps.setString(1, al.getCpf());
    
      ps.execute(); 

      return true;
    } catch (SQLException e) {
      e.printStackTrace();

      return false;
    }
  }

  public static Aluno select(String cpf){
    Aluno al = new Aluno();
    String sql = "select * from aluno where cpf=?";
    try {
      PreparedStatement ps = Conector.getConexao().prepareStatement(sql);
      ps.setString(1, cpf);
      ResultSet rs = ps.executeQuery(); //java.sql.ResultSet
      if(rs.next()){
        al.setCpf(rs.getString("cpf"));
        al.setNome(rs.getString("nome"));
      }
      else{
        al = null;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return al;
  }

  public static List select(){
    List lista = new ArrayList();
    String sql = "select * from aluno";
    try {
      PreparedStatement ps = Conector.getConexao().prepareStatement(sql);
      ResultSet rs = ps.executeQuery(); //java.sql.ResultSet
      while(rs.next()){
        Aluno al = new Aluno();
        al.setCpf(rs.getString("cpf"));
        al.setNome(rs.getString("nome"));
        lista.add(al);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    return lista;
  }
}