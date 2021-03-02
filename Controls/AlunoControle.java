import java.util.Scanner;
import java.util.List;

//Modelo MVC
//Controle

public class AlunoControle{
    static Scanner s = new Scanner(System.in);
    
    public static boolean cadastrarAluno(AlunoDAO dao){
        Aluno aluno = new Aluno();
        
        System.out.printf("Digite o nome do aluno: ");
        aluno.setNome(s.nextLine());
        System.out.printf("Digite o CPF do aluno: ");
        aluno.setCpf(s.nextLine());
        
        if(dao.insert(aluno)){
            System.out.printf("Aluno cadastrado com sucesso!\n");
            
            return true;
        }
        else{
            System.out.printf("Falha de cadastro de aluno!\n");
            
            return false;
        }
    }
    
    public static boolean excluirAluno(AlunoDAO dao){
        String cpf;
        
        System.out.printf("Digite o CPF do aluno que deseja excluir: ");
        cpf = s.nextLine();
        Aluno aluno = dao.select(cpf);

        if(aluno!=null){
            System.out.printf("Aluno(a) encontrado(a):\n");
            aluno.print();
            System.out.printf("Tem certeza que deseja confirmar a exclusão deste aluno(a)? (s-sim, n-não) ");
            char ch = s.next().charAt(0);
            Utils.limparTeclado(s);
            if(ch=='s' || ch=='S'){
                if(dao.delete(aluno)){ 
                    System.out.printf("Exclusão efetuada com sucesso!\n");
                    
                    return true;
                }
                else{ 
                    System.out.printf("Falha de exclusão de registro!\n");
                    
                    return false;
                }
            }
            else if(ch=='n' || ch=='N'){
                System.out.printf("Exclusão cancelada pelo usuário!\n");
                
                return false;
            }
        }
        else{
            System.out.printf("Aluno(a) não encontrado(a)!\n");
            
            return false;
        }
        
        return false;
    }
    
    public static boolean alterarAluno(AlunoDAO dao){
        String cpf;
        
        System.out.printf("Digite o CPF do aluno que deseja alterar: ");
        cpf = s.nextLine();
        Aluno aluno = dao.select(cpf);

        if(aluno!=null){
            System.out.printf("Aluno(a) encontrado(a):\n");
            aluno.print();
            
            System.out.printf("Qual campo você deseja alterar:\n");
            System.out.printf("1 - Nome\n");
            System.out.printf("2 - CPF\n");
            System.out.printf("Digite sua opção: ");
            
            int op = s.nextInt();
            Utils.limparTeclado(s);
            String alteracao;
            switch(op){
                case 1:
                    System.out.printf("Digite o novo nome: ");
                    aluno.setNome(s.nextLine());
                    break;
                case 2:
                    System.out.printf("Digite o novo CPF: ");
                    aluno.setCpf(s.nextLine());
                    break;
                default:
                    System.out.printf("Opção inválida!\n");
            }
            System.out.printf("Tem certeza que deseja confirmar a alteração deste aluno(a)? (s-sim, n-não) ");
            char ch = s.next().charAt(0);
            Utils.limparTeclado(s);
            if(ch=='s' || ch=='S'){
                if(dao.update(aluno)){ 
                    System.out.printf("Alteração efetuada com sucesso!\n");
                    
                    return true;
                }
                else{ 
                    System.out.printf("Falha de alteração de registro!\n");
                    
                    return false;
                }
            }
            else if(ch=='n' || ch=='N'){
                System.out.printf("Alteração cancelada pelo usuário!\n");
                
                return false;
            }
        }
        else{
            System.out.printf("Aluno(a) não encontrado(a)!\n");
            
            return false;
        }
        
        return false;
    }

    public static void listarAlunos(AlunoDAO dao){
      List listaAlunos = dao.select();
      Aluno aluno;

      System.out.println("-- LISTA DE ALUNOS --\n");
      for(int i=0; i<listaAlunos.size(); i++){
        aluno = (Aluno)listaAlunos.get(i);
        aluno.print();
      }
    }
}