public class ContaCantina {
    private TipoContaEnum tipoConta;
    private double saldo;
    private double limite;
    private double saldoMinimo;

    public ContaCantina(double saldo) {
        this.saldo = saldo;
        this.tipoConta = TipoContaEnum.ALUNO;
        this.saldoMinimo = 10;
    }

    public ContaCantina(double saldo, TipoContaEnum tipoConta) {
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.saldoMinimo = 10;

        if (tipoConta == TipoContaEnum.PROFESSOR) {
            this.limite = 100;
        }
    }

    public void debitar(double valor) {
        if (tipoConta == TipoContaEnum.DIRETOR) {

            saldo -= valor;
            emitiralertasaldobaixo();
        } else if (tipoConta == TipoContaEnum.PROFESSOR) {

            if (saldo > valor && valor < (saldo + limite)) {

                saldo -= valor;
                emitiralertasaldobaixo();
            } else {
                System.out.println("Conta sem saldo suficiente");
            }
        } else if (tipoConta == TipoContaEnum.ALUNO) {
            if (saldo > valor) {

                saldo -= valor;
                emitiralertasaldobaixo();
            } else {
                System.out.println("Conta sem saldo suficiente");
            }
        }
    }

    public void cridatar(double valor) {

        saldo += valor;
        if (tipoConta == TipoContaEnum.ALUNO) {
            saldo += 5;
        }
        emitiralertasaldobaixo();
    }

    public void emitiralertasaldobaixo() {
        if (saldo < saldoMinimo) {
            System.out.println("ALERTA DE SALDO BAIXO: R$ " + saldo);
        } else {
            System.out.println("SALDO: R$ " + saldo);
        }


    }

    public void setSaldoMinimo(double saldoMinimo) {

        this.saldoMinimo = saldoMinimo;
        emitiralertasaldobaixo();
    }
}
