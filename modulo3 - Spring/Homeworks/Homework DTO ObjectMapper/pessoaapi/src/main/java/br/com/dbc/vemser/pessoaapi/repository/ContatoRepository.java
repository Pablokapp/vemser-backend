package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {
    private static final List<Contato> listaContatos = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

    private final PessoaRepository pessoaRepository;



    public ContatoRepository(){
        pessoaRepository = new PessoaRepository();
        listaContatos.add(new Contato(COUNTER.incrementAndGet(),1, "COMERCIAL","05147894744","whatsapp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(),2, "RESIDENCIAL","05147894745","whatsapp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(),3, "RECADO","05147894746","whatsapp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(),4, "COMERCIAL","05147894747","whatsapp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(),5, "RESIDENCIAL","0574874748","whatsapp"));

    }





    public Contato create(Contato contato){
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);

        return contato;
    }

    public List<Contato> list(){
        return listaContatos;
    }

    public Contato update(Integer id, Contato contatoAtualizar) throws RegraDeNegocioException {
        Contato contatoRecuperado = findById(id);
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        return contatoRecuperado;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Contato contatoRecuperado =findById(id);
        listaContatos.remove(contatoRecuperado);
    }

    public List<Contato> listarContatosPessoa(Integer id){
       return listaContatos.stream()
               .filter(contato -> contato.getIdPessoa().equals(id))
               .collect(Collectors.toList());
    }


    public Contato findById(Integer id) throws RegraDeNegocioException{
        Contato c =(Contato) listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        return c;
    }

    public List<Contato> findByType (String tipo){
        return listaContatos.stream()
                .filter(c -> c.getTipoContato().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }
}
