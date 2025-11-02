package org.example.msnutriamongodb.dto;

public class PostChatDTO {
    String pergunta;
    int nCdUser;
    int iChat;

    public PostChatDTO() {
    }

    public PostChatDTO(String pergunta, int nCdUser, int iChat) {
        this.pergunta = pergunta;
        this.nCdUser = nCdUser;
        this.iChat = iChat;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public int getnCdUser() {
        return nCdUser;
    }

    public void setnCdUser(int nCdUser) {
        this.nCdUser = nCdUser;
    }

    public int getiChat() {
        return iChat;
    }

    public void setiChat(int iChat) {
        this.iChat = iChat;
    }
}
