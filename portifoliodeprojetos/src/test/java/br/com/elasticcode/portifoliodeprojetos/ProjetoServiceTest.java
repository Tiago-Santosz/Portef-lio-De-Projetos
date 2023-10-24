package br.com.elasticcode.portifoliodeprojetos;

import br.com.elasticcode.portifoliodeprojetos.model.ProjetoEntity;
import br.com.elasticcode.portifoliodeprojetos.repository.ProjetoRepository;
import br.com.elasticcode.portifoliodeprojetos.service.ProjetoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@ExtendWith(SpringExtension.class)
public class ProjetoServiceTest {

    @InjectMocks
    private ProjetoService projetoService;

    @InjectMocks
    private ProjetoEntity projeto;

    @Mock
    private ProjetoRepository projetoRepository;

    @Before
    public  void  setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAtualizarProjeto() {
        Long projetoId = 1L;
        ProjetoEntity projeto = new ProjetoEntity();
        projeto.setId(projetoId);
        projeto.setNome("Projeto Antigo");
        when(projetoRepository.existsById(projetoId)).thenReturn(true);
        when(projetoRepository.save(projeto)).thenReturn(projeto);

        ProjetoEntity projetoAtualizado = new ProjetoEntity();
        projetoAtualizado.setId(projetoId);
        projetoAtualizado.setNome("Projeto Atualizado");

        ProjetoEntity projetoResultado = projetoService.atualizarProjeto(projetoId, projetoAtualizado);

        assertEquals("Projeto Atualizado", projetoResultado.getNome());
    }

    @Test
    public void testExcluirProjeto() {
        Long projetoId = 1L;
        when(projetoRepository.existsById(projetoId)).thenReturn(true);

        projetoService.excluirProjeto(projetoId);
    }
}


