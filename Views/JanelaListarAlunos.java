import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.table.*;

public class JanelaListarAlunos extends JFrame{
  private final JTable tblAlunos;

  public JanelaListarAlunos(){
    super("Listagem de Alunos");
    setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
    
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("CPF");
    tableModel.addColumn("Nome");

    List listaAlunos = AlunoDAO.select();
    Aluno al;

    for(int i=0; i<listaAlunos.size(); i++){
      al = (Aluno) listaAlunos.get(i);
      tableModel.addRow(new String[]{
                        al.getCpf(), 
                        al.getNome()
                        });
    }

    tblAlunos = new JTable(tableModel);

    add(tblAlunos);
  }
}