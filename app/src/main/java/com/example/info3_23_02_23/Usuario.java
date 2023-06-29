package com.example.info3_23_02_23;

public class Usuario {

    public Usuario(int idUsuario, String nomeUsuario, String senhaUsuario) {
        this.setIdUsuario(idUsuario);
        this.setNomeUsuario(nomeUsuario);
        this.setSenhaUsuario(senhaUsuario);
    }

    public Usuario(String nomeUsuario, String senhaUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nomeUsuario='" + nomeUsuario + '\'' + ", senhaUsuario=" + senhaUsuario + '}';
        //"Usuario{idUsuario=1, nomeUsuario=Ronan, idadeUsuario=30}"
    }

    private int idUsuario;
    private String nomeUsuario;
    private String senhaUsuario;



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

    protected String getSenhaUsuario() {
        return senhaUsuario;
    }

    protected void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }



}