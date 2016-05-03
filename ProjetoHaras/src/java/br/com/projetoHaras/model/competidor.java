package br.com.projetoHaras.model;
public class competidor extends animais{

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

    public int getId_animais() {
        return id_animais;
    }

    public void setId_animais(int id_animais) {
        this.id_animais = id_animais;
    }
    private int id_animais;

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }
    private String modalidade;
    
}
