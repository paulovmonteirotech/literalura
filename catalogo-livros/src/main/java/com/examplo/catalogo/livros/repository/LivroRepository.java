package com.examplo.catalogo.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examplo.catalogo.livros.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
