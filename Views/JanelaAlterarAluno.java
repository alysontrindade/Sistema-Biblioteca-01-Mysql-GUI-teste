import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.table.*;

public class JanelaAlterarAluno extends JFrame{
  private final JTable tblAlunos;
  private final JLabel lblCpf;
  private final JTextField tfCpf;
  private final JLabel lblNome;
  private final JTextField tfNome;
  private final JButton btnAlterar;

  public JanelaAlterarAluno(){
    super("Alterar Aluno");
    setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
    
    tblAlunos = new JTable(tableModelAlunos());
    lblCpf = new JLabel("CPF");
    tfCpf = new JTextField(20);
    lblNome = new JLabel("Nome");
    tfNome = new JTextField(20);
    btnAlterar = new JButton("Alterar Aluno");

    add(tblAlunos);
    add(lblCpf);
    add(tfCpf);
    add(lblNome);
    add(tfNome);
    add(btnAlterar);

    tblAlunos.addMouseListener(new MouseAdapter(){
      @Override
      public void mouseClicked(MouseEvent e){
        tfCpf.setText((String) tblAlunos.getValueAt(tblAlunos.getSelectedRow(), 0));
        tfNome.setText((String) tblAlunos.getValueAt(tblAlunos.getSelectedRow(), 1));
      }
    });

    btnAlterar.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        Aluno al = new Aluno();

        al.setCpf(tfCpf.getText());
        al.setNome(tfNome.getText());

        if(AlunoDAO.update(al)){
          JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso");
          tblAlunos.setModel(tableModelAlunos());
        }
        else{
          JOptionPane.showMessageDialog(null, "Falha em alteração de aluno");
        }
      }
    });
  }

  public DefaultTableModel tableModelAlunos(){
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

    return tableModel;
  }
}