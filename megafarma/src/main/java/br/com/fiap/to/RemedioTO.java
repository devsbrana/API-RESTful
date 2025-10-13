package br.com.fiap.to;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class RemedioTO {
    // Atributos
    private Long codigo;
    @NotBlank //Não ser vazio ou nulo, so funciona pra String
    private String nome;
    @NotNull //Não ser vazio ou nulo, so funciona pra Número
    @PositiveOrZero //Positivo ou Zero
    private Double preco;
    @PastOrPresent //Data no passado ou presente
    private LocalDate dataDeFabricacao;
    @FutureOrPresent //Data no futuro ou presente
    private LocalDate dataDeValidade;

    // Construtores vazio
    public RemedioTO() {
    }

    // Construtor com passagem de paramêtro
    public RemedioTO(Long codigo, String nome, Double preco, LocalDate dataDeFabricacao, LocalDate dataDeValidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.dataDeFabricacao = dataDeFabricacao;
        this.dataDeValidade = dataDeValidade;
    }

    // getters e setters
    public Long getCodigo() {
        return codigo;
    }
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public LocalDate getDataDeFabricacao() {
        return dataDeFabricacao;
    }
    public void setDataDeFabricacao(LocalDate dataDeFabricacao) {
        this.dataDeFabricacao = dataDeFabricacao;
    }
    public LocalDate getDataDeValidade() {
        return dataDeValidade;
    }
    public void setDataDeValidade(LocalDate dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }
}
