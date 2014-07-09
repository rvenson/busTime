package venson.busTime.modelo;

public class Horario {

    private String localPartida;
    private SimpleTime hora;
    private Integer diaSemana;

    public Horario() {
    }

    public Horario(String localPartida, SimpleTime hora, Integer diaSemana) {
        this.localPartida = localPartida;
        this.hora = hora;
        this.diaSemana = diaSemana;
    }

    public String getLocalPartida() {
        return localPartida;
    }

    public void setLocalPartida(String localPartida) {
        this.localPartida = localPartida;
    }

    public SimpleTime getHora() {
        return hora;
    }

    public void setHora(SimpleTime hora) {
        this.hora = hora;
    }

    public Integer getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(Integer diaSemana) {
        this.diaSemana = diaSemana;
    }

}
