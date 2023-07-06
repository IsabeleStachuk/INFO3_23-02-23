package com.example.info3_23_02_23;

public class Usuario {

    public Usuario(int idCarro, String nomeCarro, String placaCarro) {
        this.setIdCarro(idCarro);
        this.setNomeCarro(nomeCarro);
        this.setPlacaCarro(placaCarro);
    }

    public Usuario(String nomeCarro, String placaCarro) {
        this.nomeCarro = nomeCarro;
        this.placaCarro = placaCarro;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idCarro=" + idCarro + ", nomeCarro='" + nomeCarro + '\'' + ", placaCarro=" + placaCarro + '}';
        //"Usuario{idUsuario=1, nomeUsuario=Ronan, idadeUsuario=30}"
    }

    private int idCarro;
    private String nomeCarro;
    private String placaCarro;



    protected int getIdCarro() {
        return idCarro;
    }

    protected void setIdCarro(int idUsuario) {
        this.idCarro = idUsuario;
    }

    protected String getNomeCarro() {
        return nomeCarro;
    }

    protected void setNomeCarro(String nomeUsuario) {
        this.nomeCarro = nomeUsuario;
    }

    protected String getPlacaCarro() {
        return placaCarro;
    }

    protected void setPlacaCarro(String placaCarro) {
        this.placaCarro = placaCarro;
    }



}