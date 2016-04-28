package br.com.projetoHaras.model;
public class competidor {

    public int getId_competidor() {
        return id_competidor;
    }

    public void setId_competidor(int id_competidor) {
        this.id_competidor = id_competidor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
    private int id_competidor;
    private String nome;
    private int posicao;
    
}
