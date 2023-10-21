package br.com.elasticcode.portifoliodeprojetos.service;

import br.com.elasticcode.portifoliodeprojetos.exception.ExclusaoInvalidaException;
import br.com.elasticcode.portifoliodeprojetos.exception.ProjetoNaoExistenteException;
import br.com.elasticcode.portifoliodeprojetos.model.Projeto;
import br.com.elasticcode.portifoliodeprojetos.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public Projeto cadastrarProjeto (Projeto projeto){
        return  projetoRepository.save(projeto);
    }

    public List<Projeto> listarProjetos(){
        return projetoRepository.findAll();
    }

    public  Projeto buscarProjetoPorId(Long id){
        return  projetoRepository.findById(id)
                .orElseThrow(() -> new ProjetoNaoExistenteException(id));
    }

    public Projeto atualizarProjeto(Long id, Projeto projetoAtualizado){
        if (!projetoRepository.existsById(id)){
            throw new ProjetoNaoExistenteException(id);
        }
        projetoAtualizado.setId(id);
        Projeto projetoAtualizadoSalvo = projetoRepository.save(projetoAtualizado);
        return projetoAtualizadoSalvo;
    }

    public void excluirProjeto(Long id){
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new ProjetoNaoExistenteException(id));
        if ("iniciado".equals(projeto.getStatus()) || "em andamento".equals(projeto.getStatus()) || "encerrado".equals(projeto.getStatus())){
            throw  new ExclusaoInvalidaException("Apenas membros 'funcionario' podem ser associados ao projeto.");
        }
    }

    }

