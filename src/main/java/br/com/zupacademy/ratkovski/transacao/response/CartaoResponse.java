package br.com.zupacademy.ratkovski.transacao.response;

import br.com.zupacademy.ratkovski.transacao.modelo.Cartao;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CartaoResponse {
    @NotBlank
    private String id;
    @NotBlank
    @Email
    private String email;

    @Deprecated
    public CartaoResponse(){
    }

    public CartaoResponse(String id, String email) {
        this.id = id;
        this.email = email;
    }
    public Cartao toModel() {
        return new Cartao(id,email);
    }

    @Override
    public String toString() {
        return "CartaoResponse{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}

