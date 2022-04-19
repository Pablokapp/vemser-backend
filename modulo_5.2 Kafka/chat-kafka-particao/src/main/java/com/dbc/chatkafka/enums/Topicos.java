package com.dbc.chatkafka.enums;


public enum Topicos {
    GERAL("chat-geral"),        // 0
    ANA("chat-ana"),            // 1
    EZEQUIAS("chat-ezequias"),  // 2
    FLAVIO("chat-flavio"),
    FELIPE("chat-felipe"),
    GABRIEL("chat-gabriel"),
    GUILHERME("chat-guilherme"),
    GUSTAVO("chat-gustavo"),
    JOAO("chat-joao"),
    LUCAS("chat-lucas"),
    LUIZ("chat-luiz"),
    MAICON("chat-maicon"),      // 11
    NICOLAS("chat-nicolas"),
    PABLO("chat-pablo");

    private String chatName;

    Topicos(String chatName) {
        this.chatName = chatName;
    }

    public String getChatName() {
        return this.chatName;
    }


 public static Integer returnOrdinal(String usuario){
        if (usuario.equals("ana")){
            ANA.ordinal();
        }
        if (usuario.equals("ezequias")){
            EZEQUIAS.ordinal();
        }
        if (usuario.equals("flavio")){
            FLAVIO.ordinal();
        }
        if (usuario.equals("felipe")){
            FELIPE.ordinal();
        }
        if (usuario.equals("gabriel")){
            GABRIEL.ordinal();
        }
        if (usuario.equals("guilherme")){
            GUILHERME.ordinal();
        }
        if (usuario.equals("gustavo")){
            GUSTAVO.ordinal();
        }
        if (usuario.equals("joao")){
            JOAO.ordinal();
        }
        if (usuario.equals("lucas")){
            LUCAS.ordinal();
        }
        if (usuario.equals("luiz")){
            LUIZ.ordinal();
        }
        if (usuario.equals("maicon")){
            MAICON.ordinal();
        }
        if (usuario.equals("nicolas")){
            NICOLAS.ordinal();
        }
     return null;
 }




}



