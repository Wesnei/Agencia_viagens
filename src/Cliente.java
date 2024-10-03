public class Cliente extends Pessoa {

    private int cpf;

    public Cliente(int id, String nome, String email, String telefone, int cpf) {
        super(id, nome, email, telefone);
        this.cpf = cpf;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

}