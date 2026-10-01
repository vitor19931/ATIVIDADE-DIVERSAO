import java.util.Scanner;

public class ContaApp {

    static Scanner scanner = new Scanner(System.in);
    static cadastroConta cadastro = new cadastroConta();

    public static void main(String[] args) {

        int opcao = 0;

        while (opcao != 4) {
            mostrarMenu();

            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Erro: digite um número de 1 a 4.");
                opcao = 0;
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrarConta();
                    break;
                case 2:
                    buscarConta();
                    break;
                case 3:
                    removerConta();
                    break;
                case 4:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Escolha de 1 a 4.");
            }
        }

        scanner.close();
    }

    static void mostrarMenu() {
        System.out.println();
        System.out.println("===== CONTAS BANCÁRIAS =====");
        System.out.println("1. Cadastrar Conta");
        System.out.println("2. Buscar Conta");
        System.out.println("3. Remover Conta");
        System.out.println("4. Sair");
        System.out.print("Escolha: ");
    }

    static void cadastrarConta() {
        try {
            System.out.print("Número da conta: ");
            String numero = scanner.nextLine();

            System.out.print("Nome do titular: ");
            String titular = scanner.nextLine();

            System.out.print("Saldo inicial: ");
            double saldo = lerSaldo(scanner.nextLine());

            Conta conta = new Conta(numero, titular, saldo);
            cadastro.inserir(conta);

            System.out.println("Conta cadastrada com sucesso!");

        } catch (ExcecaoDadoInvalido e) {
            System.out.println("Dado inválido: " + e.getMessage());
        } catch (ExcecaoElementoJaExistente e) {
            System.out.println("Conta repetida: " + e.getMessage());
        } catch (ExcecaoRepositorio e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
        }
    }

    static void buscarConta() {
        try {
            System.out.print("Número da conta: ");
            String numero = scanner.nextLine();

            Conta conta = cadastro.buscar(numero);

            System.out.println("Titular: " + conta.getTitular());
            System.out.println("Saldo: R$ " + conta.getSaldo());

        } catch (ExcecaoElementoInexistente e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    static void removerConta() {
        try {
            System.out.print("Número da conta: ");
            String numero = scanner.nextLine();

            cadastro.remover(numero);

            System.out.println("Conta removida com sucesso!");

        } catch (ExcecaoElementoInexistente e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    static double lerSaldo(String texto) throws ExcecaoDadoInvalido {
        try {
            return Double.parseDouble(texto.trim().replace(",", "."));
        } catch (NumberFormatException e) {
            throw new ExcecaoDadoInvalido("Saldo inválido. Digite apenas números.");
        }
    }
}
