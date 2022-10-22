package view;


import controller.GlobalController;

public class Main {
    
    public static void main(String[] args) {
        GlobalController global = new GlobalController();
        Menu menu = new Menu();
        
    
        int opcao = 0;
        
        do {
          opcao = menu.exibirMenu();
    
          switch(opcao) {
            case 1:
              global.CadastrarNovoAluno();
              break;
            case 2:
              global.CadastrarNovoProfessor();
              break;
            case 3:
              global.CadastrarNovaMateria();
              break;
            case 4:
              global.AdicionarCurso();
              break;
            case 5:
              global.ListarAlunos();
              break;
            case 6:
              global.ListarProfessores();
              break;
            case 7:
              global.ListarMaterias();
              break;
            case 8:
              global.ListarCursos();
              break;
            case 9:
              global.AdicionarAlunoNoCurso();
              break;
            case 10:
              global.AdicionarMateriaNoCurso();
              break;
            case 11:
              global.AlterarProfDaMateria();
              break;
            case 12:
              global.ConcederBolsaAluno();
              break;
            case 14:
              System.out.println("Saindo...");
              break;
          }
    
        } while (opcao != 14);
      }
}
