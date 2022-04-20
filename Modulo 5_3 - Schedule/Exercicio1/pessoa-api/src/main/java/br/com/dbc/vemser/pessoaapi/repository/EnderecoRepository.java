package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EnderecoRepository {

    private static List<Endereco> enderecoList = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository () {
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(), 1, "comercial", "rua sla", 50, "fim de mundo", "96700000", "Estado de lugar nenhum", "pais de ninguem"));
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(), 1, "residencial", "av. 50", 7564, "fim de mundo", "96700000", "Estado de lugar nenhum", "pais de ninguem"));
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(), 2, "comercial", "av. 40", 26, "fim de mundo", "96700000", "Estado de lugar nenhum", "pais de ninguem"));
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(), 3, "residencial", "av. 80", 78, "fim de mundo", "96700000", "Estado de lugar nenhum", "pais de ninguem"));
    }

    public Endereco create (Endereco endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        enderecoList.add(endereco);
        return endereco;
    }

    public Endereco update (Integer id, Endereco endereco) throws Exception {
        Endereco resultEndereco = enderecoList.stream()
                .filter(endereco1 -> endereco1.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereco nao encontrado."));
        endereco.setIdEndereco(resultEndereco.getIdEndereco());
        endereco.setIdPessoa(resultEndereco.getIdPessoa());
        enderecoList.add(enderecoList.indexOf(resultEndereco), endereco);
        enderecoList.remove(resultEndereco);
        return endereco;
    }

    public List<Endereco> list() {
        return enderecoList;
    }

    public Endereco delete(Integer id) throws Exception {
        Endereco endereco = enderecoList.stream()
                .filter(endereco1 -> endereco1.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereco nao encontrado."));
        enderecoList.remove(endereco);
        return endereco;
    }
}
