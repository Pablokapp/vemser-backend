package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {
    private List<Contato> contatoList = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository(){
        contatoList.add(new Contato(COUNTER.incrementAndGet(), 1, "comercial", "9876543212"));
        contatoList.add(new Contato(COUNTER.incrementAndGet(), 2,"comercial", "3452245725"));
        contatoList.add(new Contato(COUNTER.incrementAndGet(), 2,"residencial", "4688579678"));
        contatoList.add(new Contato(COUNTER.incrementAndGet(), 3,"comercial", "9875356730"));
    }

    public Contato create (Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        contatoList.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return contatoList;
    }

    public Contato update (Integer id, Contato contatoUpdate) throws Exception {
        Contato contatoRecuperado = contatoList.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato nao encontrado"));
        contatoRecuperado.setTipo(contatoUpdate.getTipo());
        contatoRecuperado.setNumeroTelefone(contatoUpdate.getNumeroTelefone());
        return contatoRecuperado;
    }

    public Contato delete (Integer id) throws Exception {
        Contato contatoRecuperado = contatoList.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato nao encontrado"));
        if (contatoList.remove(contatoRecuperado)) {
            return contatoRecuperado;
        }
        return null;
    }

    public List<Contato> listByPessoaId(Integer id) {
        return contatoList.stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }
}
