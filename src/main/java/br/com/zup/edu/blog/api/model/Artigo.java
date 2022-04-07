package br.com.zup.edu.blog.api.model;

import javax.persistence.*;

@Entity
public class Artigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Lob
    @Column(nullable = false, length = 10000)
    private String corpo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoArtigo tipo;

    @ManyToOne
    private Blog blog;

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public Artigo() {
    }

    public Artigo(String titulo, String corpo, TipoArtigo tipo) {
        this.titulo = titulo;
        this.corpo = corpo;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
