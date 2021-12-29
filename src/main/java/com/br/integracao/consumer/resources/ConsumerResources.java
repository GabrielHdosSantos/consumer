package com.br.integracao.consumer.resources;

import com.br.integracao.consumer.dto.FuncionarioDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerResources {

    @PostMapping("/cadastro")
    public ResponseEntity<FuncionarioDTO> add(@RequestBody FuncionarioDTO funcionarioDTO) {

        FuncionarioDTO newFuncionario = new FuncionarioDTO(funcionarioDTO.nome, funcionarioDTO.cpf, funcionarioDTO.dataContratacao);
        ResponseEntity<FuncionarioDTO> objeto = new RestTemplate().exchange("http://localhost:9092/funcionario/adicionar"
                , HttpMethod.POST, new HttpEntity<>(newFuncionario), FuncionarioDTO.class);

        return objeto;
    }

    @GetMapping("/todos")
    public ResponseEntity<FuncionarioDTO[]> listar() {

        ResponseEntity<FuncionarioDTO[]> listarTodos = new RestTemplate().getForEntity("http://localhost:9092/funcionario/listar", FuncionarioDTO[].class);

        FuncionarioDTO[] funcionarioDTOS = listarTodos.getBody();

        return new ResponseEntity<>(funcionarioDTOS, HttpStatus.OK);
    }

    @PostMapping("/acharPeloNome")
    public ResponseEntity<FuncionarioDTO[]> acharPeloNome(@RequestBody FuncionarioDTO funcionarioDTO){

        FuncionarioDTO newFuncionario = new FuncionarioDTO(funcionarioDTO.nome);

        ResponseEntity<FuncionarioDTO[]> lista = new RestTemplate().exchange("http://localhost:9092/funcionario/listaPeloNome", HttpMethod.POST,
                new HttpEntity<>(newFuncionario), FuncionarioDTO[].class);

        FuncionarioDTO[] funcionarios = lista.getBody();

        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }


}
