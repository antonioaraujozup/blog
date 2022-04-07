package br.com.zup.edu.blog.api.controller;

import br.com.zup.edu.blog.api.model.Blog;
import br.com.zup.edu.blog.api.repository.BlogRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class CadastrarBlogController {

    private final BlogRepository repository;

    public CadastrarBlogController(BlogRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @PostMapping("/blogs")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid BlogRequest request, UriComponentsBuilder uriComponentsBuilder) {
        Blog novoBlog = request.paraBlog();

        repository.save(novoBlog);

        URI location = uriComponentsBuilder.path("/blogs/{id}")
                .buildAndExpand(novoBlog.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
