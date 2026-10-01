import java.util.ArrayList;

public class cadastroConta {

    private static final int LIMITE = 100;

    private ArrayList<Conta> contas = new ArrayList<Conta>();

    public void inserir(Conta novaConta) throws ExcecaoElementoJaExistente, ExcecaoRepositorio {

        if (contas.size() >= LIMITE) {
            throw new ExcecaoRepositorio("Limite de " + LIMITE + " contas atingido.");
        }

        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getNumero().equals(novaConta.getNumero())) {
                throw new ExcecaoElementoJaExistente("Já existe uma conta com o número " + novaConta.getNumero() + ".");
            }
        }

        contas.add(novaConta);
    }

    public Conta buscar(String numero) throws ExcecaoElementoInexistente {
        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getNumero().equals(numero.trim())) {
                return contas.get(i);
            }
        }
        throw new ExcecaoElementoInexistente("Conta " + numero.trim() + " não encontrada.");
    }

    public void remover(String numero) throws ExcecaoElementoInexistente {
        Conta conta = buscar(numero);
        contas.remove(conta);
    }
}
