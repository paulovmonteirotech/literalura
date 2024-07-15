package com.examplo.catalogo.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examplo.catalogo.livros.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
