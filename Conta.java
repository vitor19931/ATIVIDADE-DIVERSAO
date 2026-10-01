public class Conta {

    private String numero;
    private String titular;
    private double saldo;

    public Conta(String numero, String titular, double saldo) throws ExcecaoDadoInvalido {
        setNumero(numero);
        setTitular(titular);
        setSaldo(saldo);
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNumero(String numero) throws ExcecaoDadoInvalido {
        if (numero == null || numero.trim().equals("")) {
            throw new ExcecaoDadoInvalido("O número da conta não pode ficar vazio.");
        }
        this.numero = numero.trim();
    }

    public void setTitular(String titular) throws ExcecaoDadoInvalido {
        if (titular == null || titular.trim().equals("")) {
            throw new ExcecaoDadoInvalido("O nome do titular não pode ficar vazio.");
        }
        this.titular = titular.trim();
    }

    public void setSaldo(double saldo) throws ExcecaoDadoInvalido {
        if (saldo < 0) {
            throw new ExcecaoDadoInvalido("O saldo inicial não pode ser negativo.");
        }
        this.saldo = saldo;
    }
}
