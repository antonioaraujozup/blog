package br.com.zup.edu.blog.api.repository;

import br.com.zup.edu.blog.api.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
