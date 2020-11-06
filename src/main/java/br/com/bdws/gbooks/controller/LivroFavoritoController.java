package br.com.bdws.gbooks.controller;


import br.com.bdws.gbooks.service.LivroFavoritoService;
import br.com.bdws.gbooks.viewObject.LivroFavoritoVO;
import br.com.bdws.gbooks.viewObject.ResultPageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class LivroFavoritoController {

    @Autowired
    private LivroFavoritoService livroFavoritoService;

    @PostMapping("/livro-favorito/criar")
    @ResponseBody
    public void criar(@RequestBody LivroFavoritoVO vo){
        livroFavoritoService.criarFavorito(vo);
    }

    @GetMapping("/livro-favorito/listar")
    @ResponseBody
    public ResultPageVO<LivroFavoritoVO> listar(@RequestParam String pesquisa, int pagina, int maxResultado){
        return livroFavoritoService.listarFavoritos(pesquisa, pagina, maxResultado);
    }

    @DeleteMapping("/livro-favorito/deletar/{favoritoId}")
    public void deletar(@PathVariable String favoritoId){
        livroFavoritoService.removerFavorito(favoritoId);
    }
}
