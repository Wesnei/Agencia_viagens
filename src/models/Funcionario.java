package models;

public class Funcionario extends Pessoa {

    private String registro;

    public Funcionario(int id, String nome, String email, String telefone, String registro) {
        super(id, nome, email, telefone);
        this.registro = registro;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }
}