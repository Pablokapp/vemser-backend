package Homework3;
public class Main {
    public static void main(String[] args) {


        //Clientes
        Contato contato1 = new Contato("whatsapp","(51) 98744-7474",1);
        Contato contato12 = new Contato("celular","(51) 98744-7474",1);
        Endereco endereco1 = new Endereco(1,"Rua central",67,"Casa","97351-96","Porto Alegre","Rio Grande do Sul","Brasil");
        Cliente cliente1 = new Cliente("José", "754.162.237-62",contato1,endereco1);
        cliente1.setContatos(contato12);
        cliente1.imprimirContatos();
        System.out.println(cliente1.contatos);

        Contato contato2 = new Contato("whatsapp","(51) 98744-7474",1);
        Endereco endereco2 = new Endereco(1,"Rua central",67,"Casa","97351-96","Porto Alegre","Rio Grande do Sul","Brasil");
        Cliente cliente2 = new Cliente("José", "754.162.237-62",contato2,endereco2);

        //Contas
        ContaCorrente contaCorrenteCliente1 = new ContaCorrente(cliente1, "474-4","0002", 5000,200);
        ContaPoupanca contaPuopancaCLiente2 = new ContaPoupanca(cliente2,"235-7", "0001",2000);
        ContaPagamento contaPagamentoCliente3 = new ContaPagamento(cliente1,"769-8","0003",1000);


        //testes
//        contaPagamentoCliente3.imprimir();
//        contaPagamentoCliente3.sacar(5000);

//        contaPagamentoCliente3.imprimir();
//        contaPagamentoCliente3.transferir(contaPuopancaCLiente2,500);
//        contaPuopancaCLiente2.imprimir();
//        contaPagamentoCliente3.imprimir();





//

    }
}
