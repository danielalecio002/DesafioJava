package model;

import java.time.LocalDate;

public class Pessoa {

    private String nome;
    private LocalDate dataNasc;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate data) {
        this.dataNasc = data;
    }
}
