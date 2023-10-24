package br.com.elasticcode.portifoliodeprojetos.service;

import br.com.elasticcode.portifoliodeprojetos.exception.ExclusaoInvalidaException;
import br.com.elasticcode.portifoliodeprojetos.exception.ProjetoNaoExistenteException;
import br.com.elasticcode.portifoliodeprojetos.model.PessoaEntity;
import br.com.elasticcode.portifoliodeprojetos.model.ProjetoEntity;
import br.com.elasticcode.portifoliodeprojetos.repository.ProjetoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {
    @Autowired
    private ProjetoRepository projetoRepository;

    public ProjetoEntity cadastrarProjeto (ProjetoEntity projeto){
        return  projetoRepository.save(projeto);
    }

    public List<ProjetoEntity> listarProjetos(){
        return projetoRepository.findAll();
    }

    public ProjetoEntity buscarProjetoPorId(Long id){
        return  projetoRepository.findById(id)
                .orElseThrow(() -> new ProjetoNaoExistenteException(id));
    }

    public ProjetoEntity atualizarProjeto(Long id, ProjetoEntity projetoAtualizado){
        if (!projetoRepository.existsById(id)){
            throw new ProjetoNaoExistenteException(id);
        }
        projetoAtualizado.setId(id);
        ProjetoEntity projetoAtualizadoSalvo = projetoRepository.save(projetoAtualizado);
        return projetoAtualizadoSalvo;
    }

    @Transactional
    public void addMembros(ProjetoEntity projeto, List<PessoaEntity> pessoas){

        try{
            Optional<ProjetoEntity> projetoEntityOptional =  projetoRepository.findById(projeto.getId());
            projeto = projetoEntityOptional.get();
            List<PessoaEntity> listaMembros = projeto.getMembros();
            listaMembros.addAll(pessoas);
            projeto.setMembros(listaMembros);

            projetoRepository.save(projeto);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void excluirProjeto(Long id){
        ProjetoEntity projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new ProjetoNaoExistenteException(id));
        if ("iniciado".equals(projeto.getStatus()) || "em andamento".equals(projeto.getStatus()) || "encerrado".equals(projeto.getStatus())){
            throw  new ExclusaoInvalidaException("Apenas membros 'funcionario' podem ser associados ao projeto.");
        }
    }

    }

