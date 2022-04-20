package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class PessoaRepository {
    private static List<Pessoa> listaPessoas = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public PessoaRepository() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*1*/, "Joao", "pablokapp@gmail.com", LocalDate.parse("10/10/1990", formatter), "12345678910", null));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*2*/, "Maria", "pablokapp@gmail.com", LocalDate.parse("10/10/1990", formatter), "12345678910", null));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*2*/, "Jose", "jose@gmail.com", LocalDate.parse("08/05/1985", formatter), "12345678911", null));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*3*/, "Maria", "maria@gmail.com", LocalDate.parse("30/03/1970", formatter), "12345678912", null));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*5*/, "Ana", "ana@gmail.com", LocalDate.parse("01/07/1990", formatter), "12345678917", null));
    }

    public Pessoa create(Pessoa pessoa) {
        pessoa.setIdPessoa(COUNTER.incrementAndGet());
        listaPessoas.add(pessoa);
        return pessoa;
    }

    public List<Pessoa> list() {
        return listaPessoas;
    }

    public Pessoa update(Integer id,
                         Pessoa pessoaAtualizar) throws Exception {
        Pessoa pessoaRecuperada = listaPessoas.stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        return pessoaRecuperada;
    }

    public Pessoa delete(Integer id) throws Exception {
        Pessoa pessoaRecuperada = listaPessoas.stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        if (listaPessoas.remove(pessoaRecuperada)){
            return pessoaRecuperada;
        }
        return null;
    }

    public List<Pessoa> listByName(String nome) {
        return listaPessoas.stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }
}
