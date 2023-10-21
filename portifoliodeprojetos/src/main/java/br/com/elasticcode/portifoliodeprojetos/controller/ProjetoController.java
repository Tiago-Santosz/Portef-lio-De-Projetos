package br.com.elasticcode.portifoliodeprojetos.controller;

import br.com.elasticcode.portifoliodeprojetos.model.Projeto;
import br.com.elasticcode.portifoliodeprojetos.service.ProjetoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projectos")
public class ProjetoController {

    private ProjetoService projetoService;

    @PostMapping
    public Projeto cadastrarProjeto(@RequestBody Projeto projeto){
        return projetoService.cadastrarProjeto(projeto);
    }

    @GetMapping
    public List<Projeto> listarProjetos(){
        return  projetoService.listarProjetos();
    }

    @GetMapping("/{id}")
    public Projeto buscarProjetoPorId(@PathVariable Long id){
        return projetoService.buscarProjetoPorId(id);
    }

    @PutMapping("/{id}")
    public Projeto atualizarProjeto(@PathVariable Long id, @RequestBody Projeto projetoAtualizado){
        return projetoService.atualizarProjeto(id, projetoAtualizado);
    }

@DeleteMapping("/{id}")
    public void excluirProjeto(@PathVariable Long id){
    projetoService.excluirProjeto(id);
}
}
