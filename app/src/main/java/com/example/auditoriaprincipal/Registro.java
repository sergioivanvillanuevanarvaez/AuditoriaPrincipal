package com.example.auditoriaprincipal;

public class Registro {

    private int id;
    private String tipoSensor;
    private String valor;
    private String fecha;

    public Registro() {
    }

    public Registro(int id, String tipoSensor, String valor, String fecha) {
        this.id = id;
        this.tipoSensor = tipoSensor;
        this.valor = valor;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoSensor() {
        return tipoSensor;
    }

    public void setTipoSensor(String tipoSensor) {
        this.tipoSensor = tipoSensor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}