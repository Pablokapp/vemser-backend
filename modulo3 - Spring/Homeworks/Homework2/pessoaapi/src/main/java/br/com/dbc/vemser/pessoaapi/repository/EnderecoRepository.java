package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {
    private static final List<Endereco> listAddress = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();


    public EnderecoRepository(){
        listAddress.add(new Endereco(COUNTER.incrementAndGet(),1,"Residencial", "Rua Um",10, "94875-230", "Bairro 1", "Porto Alegre", "Rio Grande do Sul", "Brasil"));
        listAddress.add(new Endereco(COUNTER.incrementAndGet(),2,"Comercial", "Rua Dois",20, "94875-240", "Bairro 2", "Canoas", "Rio Grande do Sul", "Brasil"));
        listAddress.add(new Endereco(COUNTER.incrementAndGet(),3,"Residencial", "Rua Três",30, "94875-250", "Bairro 3", "Gravatai", "Rio Grande do Sul", "Brasil"));
        listAddress.add(new Endereco(COUNTER.incrementAndGet(),4,"Comercial", "Rua Quatro",40, "94875-260", "Bairro 4", "Cachoeirinha", "Rio Grande do Sul", "Brasil"));
        listAddress.add(new Endereco(COUNTER.incrementAndGet(),5,"Residencial", "Rua Cinco",50, "94875-270", "Bairro 5", "Alvorada", "Rio Grande do Sul", "Brasil"));

    }

    public Endereco create(Endereco endereco, Integer idPessoa){
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        endereco.setIdPessoa(idPessoa);
        listAddress.add(endereco);
        return endereco;
    }

    public List<Endereco> list(){
        return listAddress;
    }

    public Endereco update(Integer idEndereco, Endereco endereco)throws RegraDeNegocioException{
        Endereco enderecoAtualizar = findById(idEndereco);
        enderecoAtualizar.setCep(endereco.getCep());
        enderecoAtualizar.setCidade(endereco.getCidade());
        enderecoAtualizar.setPais(endereco.getPais());
        enderecoAtualizar.setTipoEndereco(endereco.getTipoEndereco());
        enderecoAtualizar.setEstado(endereco.getEstado());
        enderecoAtualizar.setNumero(endereco.getNumero());
        enderecoAtualizar.setBairro(endereco.getBairro());
        enderecoAtualizar.setLogradouro(endereco.getLogradouro());
        return enderecoAtualizar;
    }


    public void delete (Integer id) throws RegraDeNegocioException {
        Endereco addressDelete = findById(id);
        listAddress.remove(addressDelete);
    }



    public List<Endereco> findByPerson (Integer idPessoa){
        return listAddress.stream()
                .filter(e-> e.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }


    public Endereco findById (Integer id) throws RegraDeNegocioException {
        return listAddress.stream()
                .filter(e -> e.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(()-> new RegraDeNegocioException ("Endereço não encontrado."));
    }
}
