package br.com.zup.edu.blog.api.controller;

import br.com.zup.edu.blog.api.model.Artigo;
import br.com.zup.edu.blog.api.model.TipoArtigo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ArtigoRequest {

    @NotBlank
    @Size(max = 200)
    private String titulo;

    @NotBlank
    @Size(max = 10000)
    private String corpo;

    @NotNull
    private TipoArtigo tipo;

    public ArtigoRequest() {
    }

    public Artigo paraArtigo() {
        return new Artigo(titulo,corpo,tipo);
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public void setTipo(TipoArtigo tipo) {
        this.tipo = tipo;
    }
}
