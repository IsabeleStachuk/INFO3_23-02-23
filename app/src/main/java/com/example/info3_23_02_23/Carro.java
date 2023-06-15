package com.example.info3_23_02_23;

public class Carro {

    public Carro( int idCarro, String nomeCarro,int placaCarro){
            this.setIdCarro(idCarro);
            this.setNomeCarro(nomeCarro);
            this.setPlacaCarro(placaCarro);
        }
        protected int getIdCarro () {
            return idCarro;
        }
        protected int getPlacaCarro () {
            return placaCarro;
        }
        protected String getNomeCarro () {
            return nomeCarro;
        }
        private void setPlacaCarro ( int placaCarro){
        }

        private void setNomeCarro (String nomeCarro){

        }

        private void setIdCarro ( int idCarro){

        }

    public Carro(String nomeCarro, int placaCarro){
            this.nomeCarro = nomeCarro;
            this.placaCarro = placaCarro;
        }

        @Override
        public String toString () {
            return "Usuario{" + "idCarro=" + idCarro + ", nomeCarro='" + nomeCarro + '\'' + ", placaCarro=" + placaCarro + '}';
            //"Usuario{idUsuario=1, nomeUsuario=Ronan, idadeUsuario=30}"
        }

        private int idCarro;
        private String nomeCarro;
        private int placaCarro;


    }

