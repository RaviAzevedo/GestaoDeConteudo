package Comando;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


		public class GestaoConteudo {
	    private static List<Conteudo> contentList = new ArrayList<>();
	    private static final String FIXED_USUARIO = "Ravi";
	    private static final String FIXED_SENHA = "1234";
	    private static boolean LOGADO = false;

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        while (true) {
	            if (!LOGADO) {
	                MostrarMenu(scanner);
	            } else {
	                MostarMenuLogin(scanner);
	            }
	        }
	    }

	    private static void MostrarMenu(Scanner scanner) {
	    	
	        System.out.println("\nMenu Inicial:");
	        System.out.println("1. Login");
	        System.out.println("2. Listar Conteúdos");
	        System.out.println("3. Sair");
	        System.out.print("Escolha uma opção: ");
	        
	        int choice = Integer.parseInt(scanner.nextLine());

	        switch (choice) {
	            case 1:
	                login(scanner);
	                break;
	            case 2:
	            	ListarConteudo();
	                break;
	            case 3:
	                System.out.println("Saindo do sistema. Até logo!");
	                System.exit(0);
	            default:
	                System.out.println("Opção inválida. Tente novamente.");
	                
	        }
	    }

	    private static void MostarMenuLogin(Scanner scanner) {
	    	
	        System.out.println("\nMenu:");
	        System.out.println("1. Criar Conteúdo");
	        System.out.println("2. Listar Conteúdos");
	        System.out.println("3. Atualizar Conteúdo");
	        System.out.println("4. Excluir Conteúdo");
	        System.out.println("5. Logout");
	        System.out.print("Escolha uma opção: ");
	        
	        int choice = Integer.parseInt(scanner.nextLine());

	        switch (choice) {
	            case 1:
	                CriarConteudo(scanner);
	                break;
	            case 2:
	                ListarConteudo();
	                break;
	            case 3:
	                AtualizarConteudo(scanner);
	                break;
	            case 4:
	                DeletarConteudo(scanner);
	                break;
	            case 5:
	                Sair();
	                break;
	            default:
	                System.out.println("Opção inválida. Tente novamente.");
	        }
	    }

	    private static void login(Scanner scanner) {
	    	
	        System.out.print("Digite o nome de usuário: ");
	        String usuario = scanner.nextLine();
	        System.out.print("Digite a senha: ");
	        String senha = scanner.nextLine();

	        if (usuario.equals(FIXED_USUARIO) && senha.equals(FIXED_SENHA)) {
	            LOGADO = true;
	            System.out.println("Login realizado com sucesso!");
	        } else {
	            System.out.println("Usuário ou senha incorretos. Tente novamente.");
	        }
	        
	    }

	    private static void Sair() {
	        LOGADO = false;
	        System.out.println("Logout realizado com sucesso!");
	    }

	    private static void CriarConteudo(Scanner scanner) {
	        System.out.print("Digite o título do conteúdo: ");
	        String titulo = scanner.nextLine();
	        System.out.print("Digite o corpo do conteúdo: ");
	        String corpo = scanner.nextLine();

	        contentList.add(new Conteudo(titulo, corpo));
	        System.out.println("Conteúdo criado com sucesso!");
	    }

	    private static void ListarConteudo() {
	    	
	        if (contentList.isEmpty()) {
	            System.out.println("Nenhum conteúdo disponível.");
	            return;
	        }

	        System.out.println("\nLista de Conteúdos:");
	        for (int i = 0; i < contentList.size(); i++) {
	            System.out.println((i + 1) + ". " + contentList.get(i).getTitulo());
	        }
	    }

	    private static void AtualizarConteudo(Scanner scanner) {
	    	
	    	ListarConteudo();
	        if (contentList.isEmpty()) {
	            return;
	            
	        }

	        System.out.print("Selecione o número do conteúdo que deseja atualizar: ");
	        int choice = Integer.parseInt(scanner.nextLine());

	        if (choice > 0 && choice <= contentList.size()) {
	        	
	            Conteudo content = contentList.get(choice - 1);
	            System.out.print("Digite o novo título: ");
	            content.setTitulo(scanner.nextLine());
	            System.out.print("Digite o novo corpo: ");
	            content.setCorpo(scanner.nextLine());

	            System.out.println("Conteúdo atualizado com sucesso!");
	        } else {
	            System.out.println("Opção inválida.");
	        }
	    }

	    private static void DeletarConteudo(Scanner scanner) {
	    	
	        ListarConteudo();
	        if (contentList.isEmpty()) {
	            return;
	        }

	        
	        System.out.print("Selecione o número do conteúdo que deseja excluir: ");
	        int choice = Integer.parseInt(scanner.nextLine());

	        if (choice > 0 && choice <= contentList.size()) {
	            contentList.remove(choice - 1);
	            System.out.println("Conteúdo excluído com sucesso!");
	        } else {
	            System.out.println("Opção inválida.");
	        }
	    }
	}

