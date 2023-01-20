package model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Funcionario extends Pessoa implements Comparable<Funcionario> {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate datanasc, BigDecimal salario, String funcao) {
        this.setNome(nome);
        this.setDataNasc(datanasc);
        this.salario = salario;
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }
    public BigDecimal getSalario() {
        return salario;

    }
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }


    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-uuuu");
        String convertida = fmt.format(getDataNasc());
        DecimalFormat df = new DecimalFormat("###,###.00");

        return "Funcionario{" +
                "nome=" + getNome() +
                " datanasc=" + convertida +
                " salario=" + df.format(salario) +
                ", funcao='" + funcao + '\'' +
                '}';
    }


    @Override
    public int compareTo(Funcionario f) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.getNome(),f.getNome());
    }
}
