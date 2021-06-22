package br.com.zupacademy.ratkovski.transacao.request;

import br.com.zupacademy.ratkovski.transacao.modelo.Estabelecimento;

import javax.validation.constraints.NotBlank;

public class EstabelecimentoResquest {
    @NotBlank
    private String nome;
    @NotBlank
    private String cidade;
    @NotBlank
    private String endereco;

    @Deprecated
    public EstabelecimentoResquest(){
    }

    public EstabelecimentoResquest(String nome,
                                   String cidade,
                                   String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public Estabelecimento toModel(){
        return new Estabelecimento(nome,cidade,endereco);
    }

    @Override
    public String toString() {
        return "EstabelecimentoResponse{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
