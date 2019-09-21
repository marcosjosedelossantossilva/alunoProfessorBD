
package atividadelp3;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos José
 */
public class CamadaDao {
       
      static EntradaDeDados entrada = new EntradaDeDados();
      static  Aluno a = new Aluno();
      static Professor p = new  Professor();
       
       public void salvarProfessor(Professor p) throws SQLException{
            Connection con;
        try {
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alunoprofessor", "root", "");
        
             String sql = "insert into professores (cpf,nome,idade,sexo,siape) values(?,?,?,?,?)";
             PreparedStatement pr = con.prepareStatement(sql);
             pr.setString(1, p.getCpf());
             pr.setString(2, p.getNome());
             pr.setString(3, p.getIdade());
             pr.setString(4, p.getSexo());
             pr.setString(5, p.getSiape());
             pr.execute();
             pr.close();
             
            }catch (SQLException ex){
             JOptionPane.showInputDialog ( " Erro ao cadastrar Professor  " +ex);
        }
        
        
  }    
        public void salvarAluno (Aluno a ) throws SQLException {
             Connection con;
            try {
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alunoprofessor", "root", "");
            
                String sql ="insert into alunos (cpf,nome,idade,ra,sexo) values(?,?,?,?,?)";
                PreparedStatement pr = con.prepareStatement(sql);
                pr.setString(1, a.getCpf());
                pr.setString(2, a.getNome());
                pr.setString(3,a.getIdade());
                pr.setString(4, a.getRa());
                pr.setString(5, a.getSexo());
                pr.execute();
                pr.close();  
                JOptionPane.showMessageDialog ( null," Cadastrado!  " );
            }catch (SQLException ex ){
             JOptionPane . showInputDialog ( " Erro ao cadastrar Professor  " +ex);

            }
        }
        
        
        public void buscarProfessorNome() throws SQLException
    {
             Connection con = null;
            try 
            {
            con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/alunoprofessor", "root", "");
            String sql ="select * from professores where nome = ?";
            PreparedStatement pr = con.prepareCall(sql);
            pr.setString(1, entrada.nome());
            
            ResultSet re = pr.executeQuery();
            while(re.next())
            {
                 String nome = re.getString("nome");
                 String idade = re.getString("idade");
                 String sexo = re.getString("sexo");
                 String cpf = re.getString("cpf");
                 String siape = re.getString("siape");
               
               JOptionPane.showMessageDialog(null,"Professor Encontrado: \n\n"+"\nNome: "+nome+"\nIdade: "+idade+
               "\nSexo: "+sexo+"\nCpf: "+cpf+"\nSiape: "+siape);
            }

        }catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
        public void buscarAlunoNome() throws SQLException
            {
                Connection con = null ;
                   try 
                   {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alunoprofessor", "root", "");
                String sql ="select * from alunos where nome = ?";
                    PreparedStatement pr = con.prepareCall(sql);
                    pr.setString(1, entrada.nome());

                    ResultSet re = pr.executeQuery();
                    while(re.next())
                    {
                       String nome = re.getString("nome");
                       String idade = re.getString("idade");
                       String sexo = re.getString("sexo");
                       String cpf = re.getString("cpf");
                       String ra = re.getString("ra");

                       JOptionPane.showMessageDialog(null,"Aluno Encontrado: \n"+"Nome: "+nome+"\nIdade: "+idade+
                       "\nSexo: "+sexo+"\nCpf: "+cpf+"\nRa: "+ra);
                    }
                } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        
        public void buscarTodosprofessores () throws SQLException
        {    Connection con = null ;
              try
                {
                 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alunoprofessor", "root", "");
                 String sql = "select *from professores";
                 String listar = "Professores Cadastrados :";
                 PreparedStatement pr = con.prepareCall(sql);
                 ResultSet re = pr.executeQuery();
                 while (re.next()){
                            String nome = re.getString("nome");
                            String cpf = re.getString("cpf");
                            String idade = re.getString("idade");
                            String siape = re.getString("siape");
                            String sexo = re.getString("sexo");
                            String saida = "\nNome: " + nome + "\nCPF: " + cpf + "\nIdade: " + idade + "\nSexo: " 
                                    + sexo + "\nSiape: " + siape + "\n";
                            listar =listar+saida ;
                 }JOptionPane.showMessageDialog(null, listar);
                
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }finally{
                con.close();
            }
        }
        public void buscarTodosAlunos ()throws SQLException
        {
            Connection con = null;
            try 
            {   
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alunoprofessor", "root", "");
                String sql = "select *from alunos";
                 String listar = "Alunos Cadastrados :";
                 PreparedStatement pr = con.prepareCall(sql);
                 ResultSet re = pr.executeQuery();
                 while (re.next()){
                            String nome = re.getString("nome");
                            String cpf = re.getString("cpf");
                            String idade = re.getString("idade");
                            String ra = re.getString("ra");
                            String sexo = re.getString("sexo");
                            String saida = "\nNome: " + nome + "\nCPF: " + cpf + "\nIdade: " + idade + "\nRA: " 
                                    + ra + "\nSexo: " + sexo + "\n";
                            listar =listar+saida ;
                 }JOptionPane.showMessageDialog(null, listar);
                
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }finally{
                con.close();
            }
        }

        
        public void alterarAluno() throws SQLException
        {
                String out = entrada.ra();
                Connection con = null ;
                   try 
                   {
                          con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/alunoprofessor", "root", "");
                   
                       entrada.leituraAluno(a);
                       String sql = "UPDATE alunos set nome=?,idade=?,sexo=?,cpf=?,ra=? where ra=? ";
                       PreparedStatement pr = con.prepareCall(sql);
                       pr.setString(1, a.getNome());
                       pr.setString(2,a.getIdade());
                       pr.setString(3, a.getSexo());
                       pr.setString(4, a.getCpf());
                       pr.setString(5, a.getRa());
                       pr.setString(6, out);
                       pr.executeUpdate();
                       JOptionPane.showMessageDialog(null, "Alterado com Sucesso!!!!!!");
                       con.close();
                   } catch (SQLException ex) {
                       JOptionPane.showMessageDialog(null, ex.getMessage());
                   }

            }

                public void alterarProfessor() throws SQLException{

                           String out = entrada.siape();   
                   try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alunoprofessor", "root", ""))
                   {
                       entrada.leituraProfessor(p);
                       String sql = "UPDATE professores set nome=?,idade=?,sexo=?,cpf=?,siape=? where siape =?";
                       PreparedStatement pr = con.prepareCall(sql);
                       pr.setString(1, p.getNome());
                       pr.setString(2,p.getIdade());
                       pr.setString(3, p.getSexo());
                       pr.setString(4, p.getCpf());
                       pr.setString(5, p.getSiape());
                       pr.setString(6, out);
                       pr.executeUpdate();
                       JOptionPane.showMessageDialog(null, "Alterado com Sucesso!!!!!!");
                       con.close();
                   } catch (SQLException ex) {
                       JOptionPane.showMessageDialog(null, ex.getMessage());
                   }
                       }


           public void deletarProfessorCpf() throws SQLException{
                Connection con = null;
                try{
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alunoprofessor", "root", "");
                    String sql = "delete from professores where cpf=?";
                    PreparedStatement pr = con.prepareCall(sql);
                    pr.setString(1, entrada.cpf());
                    pr.executeUpdate();
                }catch (SQLException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }finally{
                    con.close();
                }
            }
            public void deletarAlunoCpf() throws SQLException{
                Connection con = null;
                try{
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alunoprofessor", "root", "");
                    String sql = "delete from alunos where cpf=?";
                    PreparedStatement pr = con.prepareCall(sql);
                    pr.setString(1, entrada.cpf());
                    pr.executeUpdate();
                   
                }catch (SQLException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }finally{
                    con.close();
                }
            }


}
