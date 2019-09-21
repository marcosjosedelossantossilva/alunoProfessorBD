package atividadelp3;


public class Aluno {
    public String cpf;
    public String nome;
    public String idade;
    public String sexo;
    public String ra;
    
    public Aluno (){}
    
    public Aluno (String cpf, String nome, String idade, String sexo,String ra)
    {
        this.cpf=cpf;
        this.nome= nome;
        this.idade=idade;
        this.sexo=sexo;
        this.ra=ra;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }
    
    
}
