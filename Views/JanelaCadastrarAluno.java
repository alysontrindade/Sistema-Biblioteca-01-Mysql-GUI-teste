import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JanelaCadastrarAluno extends JFrame{
  private final JLabel labelCPF;
  private final JTextField textoCPF;
  private final JLabel labelNome;
  private final JTextField textoNome;
  private final JButton botaoCadastrar;

  public JanelaCadastrarAluno(){
    super("Cadastro de Aluno");
    setLayout(new FlowLayout());

    labelCPF = new JLabel("CPF: ");
    textoCPF = new JTextField(15);
    labelNome = new JLabel("Nome: ");
    textoNome = new JTextField(25);
    botaoCadastrar = new JButton("Cadastrar Aluno");

    add(labelCPF);
    add(textoCPF);
    add(labelNome);
    add(textoNome);
    add(botaoCadastrar);

    botaoCadastrar.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if(textoCPF.getText().equals("")){
          JOptionPane.showMessageDialog(null, "Informe o CPF!");
        }
        else if(textoNome.getText().equals("")){
          JOptionPane.showMessageDialog(null, "Informe o nome!");
        }
        else{
          Aluno aluno = new Aluno();

          aluno.setCpf(textoCPF.getText());
          aluno.setNome(textoNome.getText());

          if(AlunoDAO.insert(aluno)){
            JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
            textoCPF.setText("");
            textoNome.setText("");
          }
          else{
            JOptionPane.showMessageDialog(null, "Erro em cadastro de aluno!");
          }
        }
      }
    });
  }
}