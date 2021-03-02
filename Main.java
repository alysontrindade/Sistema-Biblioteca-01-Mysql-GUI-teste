import java.util.Scanner;
import java.io.IOException;

import javax.swing.*;

/* Sistema de controle de Biblioteca utilizando padrão MVC
*/

//versão 2.0

public class Main {
  static Scanner s = new Scanner(System.in);

  public static void main(String[] args) {
    JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
    
    janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    janelaPrincipal.setVisible(true);
  } 
}