package com.example.info3_23_02_23;

public class Usuario {
    public Usuario() {
    }

    public Usuario(int idUsuario, String nomeUsuario, String emailUsuario) {
        this.setIdUsuario(idUsuario);
        this.setNomeUsuario(nomeUsuario);
        this.setEmailUsuario(emailUsuario);
    }

    public Usuario(String nomeUsuario, String emailUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nomeUsuario='" + nomeUsuario + '\'' + ", emailUsuario=" + emailUsuario + '}';

    }

    private int idUsuario;
    private String nomeUsuario;
    private String emailUsuario;



    protected int getIdUsuario() {
        return idUsuario;
    }

    protected void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    protected String getNomeUsuario() {
        return nomeUsuario;
    }

    protected void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    protected String getEmailUsuaario() {return emailUsuario; }

    protected void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }
}
