import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class JanelaPrincipal extends JFrame{
  private final JLabel labelTitutlo;
  private final JButton btnCadastrarAluno;
  private final JButton btnExcluirAluno;
  private final JButton btnAlterarAluno;
  private final JButton btnListarAlunos;

  public JanelaPrincipal(){
    super("Sistema Biblioteca Mysql-GUI 01");
    setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

    labelTitutlo = new JLabel("SISTEMA BIBLIOTECA - 1.0");
    btnCadastrarAluno = new JButton("Cadastrar Aluno");
    btnExcluirAluno = new JButton("Excluir Aluno");
    btnAlterarAluno = new JButton("Alterar Aluno");
    btnListarAlunos = new JButton("Listar Aluno");

    add(labelTitutlo);
    add(btnCadastrarAluno);
    add(btnExcluirAluno);
    add(btnAlterarAluno);
    add(btnListarAlunos);

    pack();

    btnCadastrarAluno.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        //your actions
        JanelaCadastrarAluno janelaCadastrarAluno = new JanelaCadastrarAluno();
        
        janelaCadastrarAluno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janelaCadastrarAluno.setSize(300, 150);
        janelaCadastrarAluno.setVisible(true);
      }
    });

    btnExcluirAluno.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        JanelaExcluirAluno janelaExcluirAluno = new JanelaExcluirAluno();

        janelaExcluirAluno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janelaExcluirAluno.setSize(300, 150);
        janelaExcluirAluno.setVisible(true);
      }
    });

    btnListarAlunos.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        JanelaListarAlunos janelaListarAlunos = new JanelaListarAlunos();

        janelaListarAlunos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janelaListarAlunos.setSize(300, 300);
        janelaListarAlunos.setVisible(true);
      }
    });

    btnAlterarAluno.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        JanelaAlterarAluno janelaAlterarAluno = new JanelaAlterarAluno();

        janelaAlterarAluno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janelaAlterarAluno.setSize(300, 300);
        janelaAlterarAluno.setVisible(true);
      }
    });
  }
}