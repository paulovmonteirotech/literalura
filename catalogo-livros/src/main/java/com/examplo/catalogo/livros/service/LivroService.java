package com.examplo.catalogo.livros.service;

import com.examplo.catalogo.livros.model.Autor;
import com.examplo.catalogo.livros.model.Livro;
import com.examplo.catalogo.livros.repository.AutorRepository;
import com.examplo.catalogo.livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public void salvarLivro(Livro livro) {
        livroRepository.save(livro);
    }

    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    public List<Autor> listarAutoresVivosEmAno(int ano) {
        return autorRepository.findAll().stream()
                .filter(autor -> (autor.getAnoNascimento() <= ano) &&
                        (autor.getAnoFalecimento() == null || autor.getAnoFalecimento() >= ano))
                .collect(Collectors.toList());
    }
}
