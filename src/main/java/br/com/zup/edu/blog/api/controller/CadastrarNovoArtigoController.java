package br.com.zup.edu.blog.api.controller;

import br.com.zup.edu.blog.api.model.Artigo;
import br.com.zup.edu.blog.api.model.Blog;
import br.com.zup.edu.blog.api.repository.BlogRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class CadastrarNovoArtigoController {

    private final BlogRepository repository;

    public CadastrarNovoArtigoController(BlogRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @PostMapping("/blogs/{idBlog}/artigos")
    public ResponseEntity<?> cadastrar(@PathVariable Long idBlog, @RequestBody @Valid ArtigoRequest request, UriComponentsBuilder uriComponentsBuilder) {
        Blog blog = repository.findById(idBlog)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Não existe Blog cadastrado para o Id informado!"));

        Artigo novoArtigo = request.paraArtigo();

        blog.adicionaArtigo(novoArtigo);

        blog = repository.save(blog);

        novoArtigo = blog.retornaUltimoArtigoAdicionado();

        URI location = uriComponentsBuilder.path("/blogs/{idBlog}/artigos/{idArtigo}")
                .buildAndExpand(blog.getId(), novoArtigo.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
