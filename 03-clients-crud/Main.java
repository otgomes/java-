import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *  Classe para armazenar clientes
 * 
 * @author Otavio
 * @version 1.00
 */

class Cliente {

    private int id;
    private String nome;
    private String email;
    private String telefone;

    // Construtor
    public Cliente(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    // Getter e Setter para id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter e Setter para nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter e Setter para telefone
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void imprimirCliente() {
        System.out.printf("Id: %d - Nome: %s - Email: %s - Telefone: %s \n",
        this.id, this.nome, this.email, this.telefone);
    }

}

/**
 * Classe Main para rodar o programa
 * 
 * 
 * @author Otavio
 * @version 1.0
 */
public class Main {

    /**
     * Função para limpar o console
     * 
     * 
     * @author Otavio
     * @version 1.0
     */
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                // Comando para limpar o console no Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Comando para limpar o console no Unix/Linux/MacOS
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Erro ao limpar o console.");
            e.printStackTrace();
        }
    }

    /**
     * Função main para rodar programa CRUD dos clientes
     * 
     * 
     * @author Otavio
     * @version 1.0
     */
    public static void main(String[] args) {

        List<Cliente> listaClientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);  // Inicia o Scanner para leitura do teclado
        int option = 0;

        do {

            do{
                clearConsole();
                // Menu inicial
                System.out.println("#---- Bem vindo ao sistema de armazenamento de clientes ----#");
                System.out.println("Digite uma das opções abaixo para acessar os menus:");
                System.out.println("1 - Cadastrar um novo cliente");
                System.out.println("2 - Listar clientes cadastrados");
                System.out.println("3 - Atualizar um cliente cadastrado");
                System.out.println("4 - Excluir um cliente cadastrado");
                System.out.println("5 - Busca de cliente por ID");
                System.out.println("9 - Sair");
                
                // Capturando entradas e tratando erros
                try {
                    System.out.println("Pressione a opção desejada");
                    option = scanner.nextInt();
                    scanner.nextLine();

                    if((option > 5 || option < 1) && option != 9) {
                        System.out.println("Você inseriu uma opção invalida, por favor verifique a opção.");
                        scanner.nextLine();
                        clearConsole();
                    }

                }catch (InputMismatchException e) {
                    System.out.println("Você inseriu um caracter invalido, insira um numero");
                    scanner.nextLine();
                    clearConsole();
                }

                switch (option) {
                    case 1:
                        cadastrarCliente(scanner, listaClientes);
                        break;
                    case 2:
                        listarClientes(scanner, listaClientes);
                        break;
                    case 3:
                        atualizarCliente(scanner, listaClientes);
                        break;
                    case 4:
                        excluirCliente(scanner, listaClientes);
                        break;
                    case 5:
                        buscaCliente(scanner, listaClientes);
                        
                        break;
                    // Nao vai cair em default
                    default:
                        break;
                }

            }while(option >= 5 && option >= 1 && option != 9);
            
        }while(option != 9);
        
        scanner.close(); // Fecha o Scanner

    }

    /**
     * Função para localizar qual o ultimo Id cadastrado
     * 
     * 
     * @author Otavio
     * @version 1.0
     */
    public static int localizarUltimoId(List<Cliente> listaClientes) {

        // Puxa o Id mais alto cadastrado
        int lastId = 0;
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() > lastId) {
                lastId = cliente.getId(); 
            }
        }
        return lastId;
    }

    /**
     * Função para cadastrar clientes
     * 
     * 
     * @author Otavio
     * @version 1.0
     */
    public static void cadastrarCliente(Scanner scanner, List<Cliente> listaClientes){

        clearConsole();
        // Solicita os dados
        System.out.println("#---- Cadastro de clientes ----#");
        System.out.println("Insira o nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.println("Insira o email do Cliente: ");
        String email = scanner.nextLine();
        System.out.println("Insira o telefone do Cliente: ");
        String telefone = scanner.nextLine();

        int lastId = localizarUltimoId(listaClientes);
        // Atribui um novo ID
        int id = lastId + 1;

        // Gera o novo cliente e coloca na lista
        Cliente newCliente = new Cliente(id, nome, email, telefone);
        listaClientes.add(newCliente);

        System.out.printf("Cliente com o id %d inserido com sucesso!\n", id);
        scanner.nextLine();

    }

    /**
     * Função para listar clientes
     * 
     * 
     * @author Otavio
     * @version 1.0
     */
    public static void listarClientes(Scanner scanner, List<Cliente> listaClientes) {

        clearConsole();                  
        // Verifica se a lista esta vazia
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : listaClientes) {
                cliente.imprimirCliente();
            }
        }

        System.out.println("#---- Pressione ENTER para voltar ao Menu ----#");
        scanner.nextLine();

    }

    /**
     * Função atualizar um cliente
     * 
     * 
     * @author Otavio
     * @version 1.0
     */
    public static void atualizarCliente(Scanner scanner, List<Cliente> listaClientes) {
        clearConsole();
        boolean idEncontrado = false;
        Cliente clienteEncontrado = null;
        int idEditar = 0;
        System.out.println("#---- Atualização de clientes ----#");
        
        // Verifica se a lista esta vazia
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            System.out.println("#---- Pressione ENTER para voltar ao Menu ----#");
            scanner.nextLine();
        } else {
            do{
                try {
                    // Solicita os dados
                    System.out.println("Informe o ID do cliente que você deseja editar: ");
                    idEditar =  scanner.nextInt();
                    scanner.nextLine();

                    // Verifica se o Id esta cadastrado
                    for(Cliente cliente : listaClientes) {
                        if(cliente.getId() == idEditar) {
                            idEncontrado = true;
                            clienteEncontrado = cliente;
                        }
                    }

                    if(idEncontrado == false) {
                        System.out.printf("Cliente com o Id %d nao encontrado. Insira um novo Id \n", idEditar);
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Caracter invalido, por favor clique ENTER e insira um numero");
                    scanner.nextLine();
                }

            }while(idEncontrado == false);

            clearConsole();
            System.out.println("#---- Atualização de clientes ----#");
            System.out.println("Cliente encontrado: ");
            clienteEncontrado.imprimirCliente();
            System.out.printf("Insira os novos dados para o cliente com Id %d ", idEditar);
            
            System.out.print("Digite o novo nome (ou deixe em branco para manter o atual): ");
            String novoNome = scanner.nextLine();
            if (!novoNome.isEmpty()) {
                clienteEncontrado.setNome(novoNome);
            }

            System.out.print("Digite o novo email (ou deixe em branco para manter o atual): ");
            String novoEmail = scanner.nextLine();
            if (!novoEmail.isEmpty()) {
                clienteEncontrado.setEmail(novoEmail);
            }

            System.out.print("Digite o novo telefone (ou deixe em branco para manter o atual): ");
            String novoTelefone = scanner.nextLine();
            if (!novoTelefone.isEmpty()) {
                clienteEncontrado.setTelefone(novoTelefone);
            }

            System.out.println("Dados do cliente atualizados com sucesso!");
            clienteEncontrado.imprimirCliente();
            System.out.println("Pressione ENTER para continuar...");
            scanner.nextLine();

        }
    }

    /**
     * Função para excluir um cliente
     * 
     * 
     * @author Otavio
     * @version 1.0
     */
    public static void excluirCliente(Scanner scanner, List<Cliente> listaClientes) {
        clearConsole();
        boolean idEncontradoExclusao = false;
        Cliente clienteParaExclusao = null;
        int idExcluir = 0;
        System.out.println("#---- Exclusão de clientes ----#");
        
        // Verifica se a lista esta vazia
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            System.out.println("#---- Pressione ENTER para voltar ao Menu ----#");
            scanner.nextLine();
        } else {
            do{
                try {
                    // Solicita os dados
                    System.out.println("Informe o ID do cliente que você deseja excluir: ");
                    idExcluir =  scanner.nextInt();
                    scanner.nextLine();

                    // Verifica se o Id esta cadastrado
                    for(Cliente cliente : listaClientes) {
                        if(cliente.getId() == idExcluir) {
                            idEncontradoExclusao = true;
                            clienteParaExclusao = cliente;
                        }
                    }

                    if(idEncontradoExclusao == false) {
                        System.out.printf("Cliente com o Id %d nao encontrado. Insira um novo Id \n", idExcluir);
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Caracter invalido, por favor clique ENTER e insira um numero");
                    scanner.nextLine();
                }

            }while(idEncontradoExclusao == false);

            clienteParaExclusao.imprimirCliente();
            listaClientes.remove(clienteParaExclusao);
            System.out.println("Cliente com id " + idExcluir + " excluído com sucesso.");
            System.out.println("#---- Pressione ENTER para voltar ao Menu ----#");
            scanner.nextLine();

        }
    }

    /**
     * Função para buscar um cliente por id especifico
     * 
     * 
     * @author Otavio
     * @version 1.0
     */
    public static void buscaCliente(Scanner scanner, List<Cliente> listaClientes) {
        clearConsole();
        boolean idBuscaEncontrado = false;
        Cliente clienteParaBusca = null;
        int idBusca = 0;
        System.out.println("#---- Busca de cliente ----#");
        
        // Verifica se a lista esta vazia
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            System.out.println("#---- Pressione ENTER para voltar ao Menu ----#");
            scanner.nextLine();
        } else {
            do{
                try {
                    // Solicita os dados
                    System.out.println("Informe o ID do cliente que você deseja encontrar: ");
                    idBusca =  scanner.nextInt();
                    scanner.nextLine();

                    // Verifica se o Id esta cadastrado
                    for(Cliente cliente : listaClientes) {
                        if(cliente.getId() == idBusca) {
                            idBuscaEncontrado = true;
                            clienteParaBusca = cliente;
                        }
                    }

                    if(idBuscaEncontrado == false) {
                        System.out.printf("Cliente com o Id %d nao encontrado. Insira um novo Id \n", idBusca);
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Caracter invalido, por favor clique ENTER e insira um numero");
                    scanner.nextLine();
                }

            }while(idBuscaEncontrado == false);

            clienteParaBusca.imprimirCliente();
            System.out.println("#---- Pressione ENTER para voltar ao Menu ----#");
            scanner.nextLine();
        }
    }
}
