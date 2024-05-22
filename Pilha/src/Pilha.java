import java.util.Scanner;

public class Pilha {
    private static final int MAX_SIZE = 20;
    private static String[] pilha = new String[MAX_SIZE];
    private static int topo = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static boolean estaVazia() {
        return topo == 0;
    }

    public static boolean estaCheia() {
        return topo == MAX_SIZE;
    }

    public static void empilhar() {
        if (estaCheia()) {
            System.out.println("Pilha está cheia");
        } else {
            System.out.print("Informe o nome: ");
            String nome = scanner.nextLine();
            pilha[topo] = nome;
            topo++;
        }
    }

    public static void desempilhar() {
        if (estaVazia()) {
            System.out.println("Pilha está vazia");
        } else {
            topo--;
            pilha[topo] = "";
        }
    }

    public static void limparTodos() {
        for (int i = 0; i < topo; i++) {
            pilha[i] = "";
        }
        topo = 0;
    }

    public static void listar() {
        if (estaVazia()) {
            System.out.println("Pilha está vazia");
        } else {
            for (int i = 0; i < topo; i++) {
                System.out.println(pilha[i]);
            }
        }
    }

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\nEscolha a opção:");
            System.out.println("1 - Empilhar");
            System.out.println("2 - Desempilhar");
            System.out.println("3 - Limpar pilha");
            System.out.println("4 - Listar pilha");
            System.out.println("5 - Status da pilha");
            System.out.println("6 - Sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir o '\n' deixado por nextInt()

            switch (opcao) {
                case 1:
                    empilhar();
                    break;
                case 2:
                    desempilhar();
                    break;
                case 3:
                    System.out.println("Pilha Limpa");
                    limparTodos();
                    break;
                case 4:
                    listar();
                    break;
                case 5:
                    if (estaVazia()) {
                        System.out.println("Pilha está vazia");
                    } else if (estaCheia()) {
                        System.out.println("Pilha está cheia");
                    } else {
                        System.out.println("Pilha não está nem cheia nem vazia");
                    }
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 6);
    }
}