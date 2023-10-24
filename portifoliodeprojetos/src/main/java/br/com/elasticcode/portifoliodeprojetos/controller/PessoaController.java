package br.com.elasticcode.portifoliodeprojetos.controller;

import br.com.elasticcode.portifoliodeprojetos.model.PessoaEntity;
import br.com.elasticcode.portifoliodeprojetos.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public PessoaEntity cadastrarPessoa(@RequestBody PessoaEntity pessoaEntity){

        return pessoaService.cadastrarPessoa(pessoaEntity);
    }

    @GetMapping
    public List<PessoaEntity> listarPessoas(){
        return  pessoaService.listarPessoas();
    }

    @GetMapping("/{id}")
    public PessoaEntity buscarPessoaPorId(@PathVariable Long id){
        return pessoaService.buscarPessoaPorId(id);
    }

    @PutMapping("/{id}")
    public PessoaEntity atualizarPessoa(@PathVariable Long id, @RequestBody PessoaEntity pessoaAtualizado){
        return pessoaService.atualizarProjeto(id, pessoaAtualizado);
    }

@DeleteMapping("/{id}")
    public void excluirPessoa(@PathVariable Long id){
    pessoaService.excluirPessoa(id);
}
}
