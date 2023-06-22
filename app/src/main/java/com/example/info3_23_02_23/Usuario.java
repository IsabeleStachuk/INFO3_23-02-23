package com.example.info3_23_02_23;

public class Usuario {

    public Usuario(int idUsuario, String nomeUsuario, int senhaUsuario) {
        this.setIdUsuario(idUsuario);
        this.setNomeUsuario(nomeUsuario);
        this.setSenhaUsuario(senhaUsuario);
    }



    public Usuario(String nomeUsuario, int senhaUsuario) {
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
    private int senhaUsuario;



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

    protected int getSenhaUsuario() {
        return senhaUsuario;
    }

    protected void setSenhaUsuario(int senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }



}