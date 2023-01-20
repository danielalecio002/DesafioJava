
import model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Set <Funcionario> funcionarios = new LinkedHashSet<>();

        //3.1 Inserindo funcionarios

        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000,10,8), BigDecimal.valueOf(2009.44),"Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990,5,12), BigDecimal.valueOf(2284.38),"Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961,5,2), BigDecimal.valueOf(9836.14),"Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988,10,14), BigDecimal.valueOf(19119.88),"Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995,1,5), BigDecimal.valueOf(2234.68),"Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999,11,19), BigDecimal.valueOf(1582.72),"Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993,3,31), BigDecimal.valueOf(4071.84),"Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994,7,8), BigDecimal.valueOf(3017.45),"Gerente"));
        funcionarios.add(new Funcionario("Heloisa", LocalDate.of(2003,5,24), BigDecimal.valueOf(1606.85),"Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996,9,2), BigDecimal.valueOf(2799.93),"Gerente"));

       //3.2 remover o joao
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

       // 3.3 Imprimindo todos os funcionarios
        System.out.println("------------------Exibindo Funcionarios da Lista -----------------------");
        for(Funcionario f : funcionarios  ){
           System.out.println(f);
       }

       //3.4 Aumento de 10% do salario
        for(Funcionario f : funcionarios  ){
            BigDecimal acrec = new BigDecimal("0.1");
            f.setSalario(f.getSalario().add(f.getSalario().multiply(acrec)));
        }
        System.out.println("------------------funcionarios com aumento de 10% ----------------------");
        for(Funcionario f : funcionarios  ){
            System.out.println(f);
        }
        //3.5 Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        Map<String, Funcionario> mapa = new HashMap<>();
        for (Funcionario f : funcionarios){
            mapa.put(f.getFuncao(),f);
        }

        //3.6  Imprimir os funcionários, agrupados por função
        System.out.println("------------Funcionários Agrupados por cargos -----------------");
        System.out.println(funcionarios.stream().filter(funcionario -> funcionario.getFuncao().equals("Operador")).collect(Collectors.toSet()));
        System.out.println(funcionarios.stream().filter(funcionario -> funcionario.getFuncao().equals("Gerente")).collect(Collectors.toSet()));
        System.out.println(funcionarios.stream().filter(funcionario -> funcionario.getFuncao().equals("Coordenador")).collect(Collectors.toSet()));
        System.out.println(funcionarios.stream().filter(funcionario -> funcionario.getFuncao().equals("Diretor")).collect(Collectors.toSet()));
        System.out.println(funcionarios.stream().filter(funcionario -> funcionario.getFuncao().equals("Recepcionista")).collect(Collectors.toSet()));
        System.out.println(funcionarios.stream().filter(funcionario -> funcionario.getFuncao().equals("Contador")).collect(Collectors.toSet()));
        System.out.println(funcionarios.stream().filter(funcionario -> funcionario.getFuncao().equals("Eletricista")).collect(Collectors.toSet()));

        //3.8 Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        System.out.println("----------------- Funcionários que  fazem aniversario nos mes 10 ou 12 ------------");
        System.out.println(funcionarios.stream().filter(f -> f.getDataNasc().getMonthValue() == 10 || f.getDataNasc().getMonthValue()== 12).collect(Collectors.toSet()));

        //3.9  Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade
        Map<String, Integer> idades = new HashMap<>();
        for(Funcionario f : funcionarios  ){ //Calculando a idade de cada funcionario
            Period periodo = Period.between(f.getDataNasc(),LocalDate.now());
            int idade = periodo.getYears();
            idades.put(f.getNome(),idade);
        }
        int maiorIdade = Collections.max(idades.values());
        String nomeMaiorIdade = "";

        Set<Map.Entry<String, Integer>> entries = idades.entrySet();
        for (Map.Entry<String, Integer> entry : entries){
            if (entry.getValue().equals(maiorIdade)){
                nomeMaiorIdade = entry.getKey();
            }
        }
        System.out.println("-------------- O funcionario com maior idade é o: -------------------");
        System.out.println(nomeMaiorIdade + " com " + maiorIdade + " anos de idade");

        //3.10 imprimir a lista de fun por ordem alfabética
        Set<Funcionario> funcionariosOrdenados = new TreeSet<>(funcionarios);
        System.out.println("------------- Funcionarios em ordem alfabetica -----------------------" );
        for (Funcionario f : funcionariosOrdenados){
            System.out.println(f);
        }
        //3.11 Imprimir o total dos salarios dos funcionarios
        BigDecimal sum = new BigDecimal("0.0");
        for(Funcionario f : funcionarios  ){
            sum = sum.add(f.getSalario());
        }

        System.out.println("-------------- Soma total dos salarios --------------------------------");
        System.out.println(sum);

        //3.12 Imprimir qtd de salarios min de cada func
        System.out.println("-------------- Qtd de salário minimos de cada funcionário --------------");
        for (Funcionario f : funcionarios){
            BigDecimal min = new BigDecimal("1212.00");
            BigDecimal qtd =  f.getSalario().divide(min,2, RoundingMode.HALF_UP);
            System.out.println("O funcionario " + f.getNome() + " ganha " + qtd + " salários mínimos" );
        }

    }
}