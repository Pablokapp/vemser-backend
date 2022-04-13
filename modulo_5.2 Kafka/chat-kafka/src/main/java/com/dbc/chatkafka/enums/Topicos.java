package com.dbc.chatkafka.enums;


public enum Topicos {
    CHAT_ANA("chat-ana"),
    CHAT_EZEQUIAS("chat-ezequias"),
    CHAT_FLAVIO("chat-flavio"),
    CHAT_GERAL("chat-geral"),
    CHAT_GABRIEL("chat-gabriel"),
    CHAT_GUSTAVO("chat-gustavo"),
    CHAT_GUILHERME("chat-guilherme"),
    CHAT_JOAO("chat-joao"),
    CHAT_LUIZ("chat-luiz"),
    CHAT_LUCAS("chat-lucas"),
    CHAT_NICOLAS("chat-nicolas"),
    CHAT_PABLO("chat-pablo"),
    CHAT_MAICON("chat-maicon");

    private String chatName;

    Topicos(String chatName) {
        this.chatName = chatName;
    }

    public String getChatName() {
        return this.chatName;
    }




}



