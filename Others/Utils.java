import java.util.Scanner;

public class Utils {
  public static void limparTeclado(Scanner s) {
    s.nextLine();
  }

  public static void limpaTela() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public static void pressioneC(Scanner s) {
    char c;

    do {
      System.out.print("Digite c e pressione enter para continuar: ");
      c = (char) s.next().charAt(0);
    } while (c != 'c' && c != 'C');
  }
}