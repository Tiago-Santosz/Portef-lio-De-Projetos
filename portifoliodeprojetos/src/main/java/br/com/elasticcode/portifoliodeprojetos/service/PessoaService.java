package br.com.elasticcode.portifoliodeprojetos.service;

import br.com.elasticcode.portifoliodeprojetos.exception.PessoaNaoExistenteException;
import br.com.elasticcode.portifoliodeprojetos.model.PessoaEntity;
import br.com.elasticcode.portifoliodeprojetos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaEntity cadastrarPessoa (PessoaEntity pessoaEntity){
        return  pessoaRepository.save(pessoaEntity);
    }

    public List<PessoaEntity> listarPessoas(){
        return pessoaRepository.findAll();
    }

    public PessoaEntity buscarPessoaPorId(Long id){
        return  pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNaoExistenteException(id));
    }

    public PessoaEntity atualizarProjeto(Long id, PessoaEntity pessoaAtualizado){
        if (!pessoaRepository.existsById(id)){
            throw new PessoaNaoExistenteException(id);
        }
        PessoaEntity pessoaAtualizadoSalvo = pessoaRepository.save(pessoaAtualizado);
        return pessoaAtualizado;
    }

    public void excluirPessoa(Long id){
        PessoaEntity pessoaEntity = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNaoExistenteException(id));
        }
    }



