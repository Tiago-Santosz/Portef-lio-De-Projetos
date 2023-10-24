package br.com.elasticcode.portifoliodeprojetos.controller;

import br.com.elasticcode.portifoliodeprojetos.model.ProjetoEntity;
import br.com.elasticcode.portifoliodeprojetos.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public ProjetoEntity cadastrarProjeto(@RequestBody ProjetoEntity projeto){

        return projetoService.cadastrarProjeto(projeto);
    }

    @GetMapping
    public List<ProjetoEntity> listarProjetos(){
        return  projetoService.listarProjetos();
    }

    @GetMapping("/{id}")
    public ProjetoEntity buscarProjetoPorId(@PathVariable Long id){
        return projetoService.buscarProjetoPorId(id);
    }

    @PutMapping("/{id}")
    public ProjetoEntity atualizarProjeto(@PathVariable Long id, @RequestBody ProjetoEntity projetoAtualizado){
        return projetoService.atualizarProjeto(id, projetoAtualizado);
    }

@DeleteMapping("/{id}")
    public void excluirProjeto(@PathVariable Long id){
    projetoService.excluirProjeto(id);
}


    @PutMapping("/membros")
    public void cadastrarMembros(@RequestBody ProjetoEntity projeto){
        projetoService.addMembros(projeto,projeto.getMembros());
    }
}
