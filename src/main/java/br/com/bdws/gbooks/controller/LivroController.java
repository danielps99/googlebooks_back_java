package br.com.bdws.gbooks.controller;


import br.com.bdws.gbooks.service.GoogleBookClientService;
import br.com.bdws.gbooks.viewObject.LivroVO;
import br.com.bdws.gbooks.viewObject.ResultPageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class LivroController {

    @Autowired
    private GoogleBookClientService googleBookClientService;

    @GetMapping("/livro/listar")
    @ResponseBody
    public ResultPageVO<LivroVO> listarLivros(@RequestParam String pesquisa, int pagina, int maxResultado){
        return googleBookClientService.buscarLivros(pesquisa, pagina, maxResultado);
    }
}
