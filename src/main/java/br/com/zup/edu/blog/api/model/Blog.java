package br.com.zup.edu.blog.api.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "blog")
    private List<Artigo> artigos = new ArrayList<>();

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public Blog() {
    }

    public Blog(String nome) {
        this.nome = nome;
    }

    public void adicionaArtigo(Artigo novoArtigo) {
        novoArtigo.setBlog(this);
        this.artigos.add(novoArtigo);
    }

    public Artigo retornaUltimoArtigoAdicionado() {
        return this.artigos.get(this.artigos.size()-1);
    }

    public Long getId() {
        return id;
    }

}
