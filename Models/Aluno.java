//Aluno: CPF*, nome*

//Padrão MVC
//Modelo

public class Aluno{
    private String cpf;
    private String nome;
    
    public Aluno(){
        cpf="";
        nome="";
    }
    
    public Aluno(String c, String n){
        cpf=c;
        nome=n;
    }
    
    public Aluno(Aluno aluno){
        cpf=aluno.getCpf();
        nome=aluno.getNome();
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public void setCpf(String cpf){
        this.cpf=cpf;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome=nome;
    }
    
    public boolean equals(Aluno aluno){
        if(this.cpf.equals(aluno.getCpf()) && this.nome.equals(aluno.getNome())) return true;
        else return false;
    }
    
    public Aluno clone(){
        Aluno aluno = new Aluno(cpf, nome);
        
        return aluno;
    }
    
    public void print(){
        System.out.printf("Nome: %s\n", nome);
        System.out.printf("CPF: %s\n", cpf);
    }

    public String toString(){
      return cpf+";"+nome;
    }
}