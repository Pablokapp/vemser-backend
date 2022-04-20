//package br.com.dbc.vemser.pessoaapi.service;
//
//import br.com.dbc.vemser.pessoaapi.client.DadosPessoaisClient;
//import br.com.dbc.vemser.pessoaapi.dto.dadospessoais.DadosPessoaisDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class DadosPessoaisService {
//    @Autowired
//    private DadosPessoaisClient dadosPessoaisClient;
//
//    public List<DadosPessoaisDTO> getAll() {
//        return dadosPessoaisClient.getAll();
//    }
//
//    public DadosPessoaisDTO post(DadosPessoaisDTO dadosPessoaisDTO) {
//        return dadosPessoaisClient.post(dadosPessoaisDTO);
//    }
//
//    public DadosPessoaisDTO put(String cpf, DadosPessoaisDTO dto) {
//        return dadosPessoaisClient.put(cpf, dto);
//    }
//
//    public DadosPessoaisDTO get(String cpf) {
//        return dadosPessoaisClient.get(cpf);
//    }
//
//    public void delete(String cpf) {
//        dadosPessoaisClient.delete(cpf);
//    }
//}
