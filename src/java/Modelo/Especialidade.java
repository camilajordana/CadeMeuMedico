package Modelo;

public class Especialidade {

    private int IDEspecialidade;
    private String nome;

    public int getIDEspecialidade() {
        return IDEspecialidade;
    }

    public void setIDEspecialidade(int IDEspecialidade) {
        this.IDEspecialidade = IDEspecialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especialidade(int IDEspecialidade, String nome) {
        this.IDEspecialidade = IDEspecialidade;
        this.nome = nome;
    }

    public Especialidade() {
    }
    
    
    
}
