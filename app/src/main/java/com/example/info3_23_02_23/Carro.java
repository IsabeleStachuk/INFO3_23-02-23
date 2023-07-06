package com.example.info3_23_02_23;

public class Carro {

    public Carro(int idCarro, String nomeCarro, String placaCarro) {
        this.setIdCarro(idCarro);
        this.setNomeCarro(nomeCarro);
        this.setPlacaCarro(placaCarro);
    }

    public Carro(String nomeCarro, String placaCarro) {
        this.nomeCarro = nomeCarro;
        this.placaCarro = placaCarro;
    }

    @Override
    public String toString() {
        return "Carro{" + "idCarro=" + idCarro + ", nomeCarro='" + nomeCarro + '\'' + ", placaCarro=" + placaCarro + '}';
        //"Usuario{idUsuario=1, nomeUsuario=b, senhaUsuario=1234}"
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