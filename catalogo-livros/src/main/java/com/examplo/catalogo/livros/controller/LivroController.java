package com.examplo.catalogo.livros.controller;

import com.examplo.catalogo.livros.model.Livro;
import com.examplo.catalogo.livros.service.GutendexService;
import com.examplo.catalogo.livros.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @Autowired
    private GutendexService gutendexService;

    @GetMapping
    public List<Livro> listarLivros() {
        return livroService.listarLivros();
    }

    @PostMapping("/buscar")
    public void buscarLivros(@RequestParam String parametros) {
        List<Livro> livros = gutendexService.buscarLivros(parametros);
        livros.forEach(livroService::salvarLivro);
    }
}
