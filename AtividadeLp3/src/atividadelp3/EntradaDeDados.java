
package atividadelp3;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import atividadelp3.Aluno;
import atividadelp3.Professor;
import javax.swing.JOptionPane;

 public class EntradaDeDados {
        
      static   Professor p = new Professor();
      static   Aluno a = new Aluno();
      static  CamadaDao dao = new CamadaDao();
        
        
        public void leituraAluno (Aluno a)  {
            a.setCpf(JOptionPane.showInputDialog("Entre com o CPF:"));
            a.setNome(JOptionPane.showInputDialog("Digite o Nome:"));
            a.setIdade(JOptionPane.showInputDialog("Digite a Idade :"));
            a.setRa(JOptionPane.showInputDialog("Digite o RA:"));
            a.setSexo(JOptionPane.showInputDialog("Digite o Sexo:"));
            
            
        }
        public void leituraProfessor (Professor p) {
              p.setCpf(JOptionPane.showInputDialog("Digite o CPF:"));
              p.setNome(JOptionPane.showInputDialog("Digite o Nome:"));
              p.setIdade(JOptionPane.showInputDialog("Digite a Idade:"));
              p.setSexo(JOptionPane.showInputDialog("Digite o Sexo:"));
              p.setSiape(JOptionPane.showInputDialog("Digite o SIAPE:"));
              
        }
        
        public String nome () {
             String nome = JOptionPane.showInputDialog("Digite um nome :");
             return nome;
        }
        
        public String cpf (){
            String cpf = JOptionPane.showInputDialog("Digite um CPF:");
            return cpf;
        }
        
        public String siape (){
            String siape = JOptionPane.showInputDialog("Digite um Siape:");
            return siape;
        }
        
        public String ra (){
            String ra = JOptionPane.showInputDialog("Digite um Ra:");
            return ra;
        }
        
        
        
        
    }

