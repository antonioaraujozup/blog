package br.com.zup.edu.blog.api.controller;

import br.com.zup.edu.blog.api.model.Blog;

import javax.validation.constraints.NotBlank;

public class BlogRequest {

    @NotBlank
    private String nome;

    public BlogRequest() {
    }

    public Blog paraBlog() {
        return new Blog(nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
