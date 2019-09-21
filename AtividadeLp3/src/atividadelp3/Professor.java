package atividadelp3;

public class Professor {
    
    public String cpf;
    public String nome;
    public String idade;
    public String sexo;
    public String siape;
    
    public Professor (){}
    public Professor (String cpf, String nome, String idade, String sexo, String siape){
        this.cpf=cpf;
        this.nome=nome;
        this.idade=idade;
        this.sexo=sexo;
        this.siape=siape;
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

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }
    
    
}
