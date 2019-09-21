package atividadelp3;

import java.sql.SQLException;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import javax.swing.JOptionPane;

public class Main {

    static CamadaDao dao = new CamadaDao();
    static EntradaDeDados entrada = new EntradaDeDados();
    static Aluno a = new Aluno();
    static Professor p = new Professor();

    public static void main(String[] args) throws SQLException {
        boolean operador;

        while (operador = true) {
            String menu = JOptionPane.showInputDialog("1 - Salvar\n 2 - Buscar\n 3 - Deletar\n 4 -Alterar\n 0 - Sair");
            switch (menu) {
                case "1": {
                    String menuSalvar = JOptionPane.showInputDialog("1 - Salvar Aluno\n 2 - Salvar Professor\n 0 - Sair");
                    switch (menuSalvar) {
                        case "1": {
                            entrada.leituraAluno(a);
                            dao.salvarAluno(a);

                        }
                        break;
                        case "2": {
                            entrada.leituraProfessor(p);
                            dao.salvarProfessor(p);
                        }
                        break;
                        case "0": {
                            operador = false;
                             JOptionPane.showMessageDialog(null, "Retornando ao Menu Principal!");
                        }
                        break;

                        default:
                            JOptionPane.showMessageDialog(null, "Opção invalida!");
                    }
                    break;
                }//fimswitch salvar

                case "2": {

                    String menuBuscar = JOptionPane.showInputDialog("1 - Buscar Todos Alunos\n 2 - Buscar Todos  Professores\n 3-Buscar Aluno por nome\n "
                            + "4- Buscar Professor por nome\n0 - Sair");
                    switch (menuBuscar) {
                        case "1": {
                            dao.buscarTodosAlunos();

                        }
                        break;
                        case "2": {
                            dao.buscarTodosprofessores();
                        }
                        break;
                        case "3": {
                            dao.buscarAlunoNome();

                        }
                        break;
                        case "4": {

                            dao.buscarProfessorNome();
                        }
                        break;
                        case "0": {
                            operador = false;
                            JOptionPane.showMessageDialog(null, "Retornando ao Menu Principal!");
                        }
                        break;

                        default:
                            JOptionPane.showMessageDialog(null, "Opção invalida!");
                    }
                    break;
                }//fimswitch buscar

                case "3": {
                    String menuDeletar = JOptionPane.showInputDialog("1 - Deletar Aluno\n 2 - deletar Professor\n 0 - Sair");
                    switch (menuDeletar) {
                        case "1": {
                            dao.deletarAlunoCpf();

                        }
                        break;
                        case "2": {
                            dao.deletarProfessorCpf();
                        }
                        break;
                        case "0": {
                            operador = false;
                             JOptionPane.showMessageDialog(null, "Retornando ao Menu Principal!");
                        }
                        break;

                        default:
                            JOptionPane.showMessageDialog(null, "Opção invalida!");
                    }
                    break;
                }//fimswitch Deletar

                case "4": {
                        
                    
                    String menuDeletar = JOptionPane.showInputDialog("1 - Alterar Aluno por RA\n 2 - Alterar Professor por SIAPE\n 0 - Sair");
                    switch (menuDeletar) {
                        case "1": {
                            dao.alterarAluno();

                        }
                        break;
                        case "2": {
                            dao.alterarProfessor();
                        }
                        break;
                        case "0": {
                            operador = false;
                            JOptionPane.showMessageDialog(null, "Retornando ao Menu Principal!");
                        }
                        break;

                        default:
                            JOptionPane.showMessageDialog(null, "Opção invalida!");
                    }
                    break;
                     
                }//fim switch 
                case "0": {
                    System.exit(0);
                }
                break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção invalida!");
            }
        }

    }

}
