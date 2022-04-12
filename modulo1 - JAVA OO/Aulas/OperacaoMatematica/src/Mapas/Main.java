package Mapas;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> pessoasPorCpf = new HashMap<>();
        pessoasPorCpf.put("1234456710", "Pablo Kapp");
        pessoasPorCpf.put("1234456711", "Pablo Kapp2");
        pessoasPorCpf.put("1234456712", "Pablo Kapp3");
        pessoasPorCpf.put("1234456713", "Pablo Kapp4");

        System.out.println(pessoasPorCpf);
        System.out.println(pessoasPorCpf.get(1234456711));


        if(pessoasPorCpf.containsKey(cpf))

    }
}
