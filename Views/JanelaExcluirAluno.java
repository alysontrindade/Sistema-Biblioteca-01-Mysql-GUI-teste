import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JanelaExcluirAluno extends JFrame{
  private final JLabel lblCpf;
  private final JTextField tfCpf;
  private final JButton btnExcluirAluno;

  public JanelaExcluirAluno(){
    super("Exclusão de Aluno");
    setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

    lblCpf = new JLabel("CPF: ");
    tfCpf = new JTextField(15);
    btnExcluirAluno = new JButton("Excluir Aluno");

    add(lblCpf);
    add(tfCpf);
    add(btnExcluirAluno);

    btnExcluirAluno.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        String cpf = tfCpf.getText();
        Aluno al = AlunoDAO.select(cpf);

        if(al!=null){
          if(AlunoDAO.delete(al)){
            JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso!");      
          }
          else{
            JOptionPane.showMessageDialog(null, "Falha na exclusão de aluno!");
          }
        }
        else{
          System.out.printf("Aluno nao encontrado:"+cpf);
          JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
        }       
      }
    });
  }
}