package view;

public class Menu {
       public int exibirMenu(){
        System.out.println("###################################");
        System.out.println( " 0 - Listar menu \n 1 - Cadastrar Aluno \n 2 - Cadastrar Professor \n 3 - Cadastrar Matéria \n 4 - Cadastrar Curso \n 5 - Listar Alunos \n 6 - Listar Professor \n 7 - Listar Matérias \n 8 - Listar Cursos \n 9 - Adicionar aluno a um curso \n 10 - Adicionar matéria a um curso\n 11 - Alterar professor da matéria\n 12- Conceder bolsa para aluno\n 14 - Sair");
        System.out.println("###################################");
              return lerEntrada();
       }


       private int lerEntrada (){
              LerInfo ler = new LerInfo();
              return ler.lerInt("# Opcao: ");
            }
}
