package venson.busTime.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Linha {

    private String nome;
    private Integer numero;
    private String tipo;
    private String itinerario;
    private List<Horario> listaHorarios;

    public Linha() {
        listaHorarios = new ArrayList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getItinerario() {
        return itinerario;
    }

    public void setItinerario(String itinerario) {
        this.itinerario = itinerario;
    }

    public List<Horario> getListaHorarios() {
        return listaHorarios;
    }

    public void setListaHorarios(List<Horario> listaHorarios) {
        this.listaHorarios = listaHorarios;
    }

    public Horario nextBus(String partida) {

        int diaSemana = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        int diaSemanaHorario;

        /*
         * Adequa o dia da semana ao padrão
         * 1 - Domingo
         * 2 - Dia de Semana
         * 3 - Sábado
         */
        if (diaSemana > 1 && diaSemana < 7) {
            diaSemana = 2;
        }

        List<Horario> lista = getListByPartida(partida);

        for (Horario h : lista) {
            diaSemanaHorario = h.getDiaSemana();
            if (diaSemana == diaSemanaHorario) {
                if (h.getHora().isAfter(SimpleTime.atualTime())) {
                    return h;
                }
            }
        }

        return null;
    }

    public List<Horario> getListByPartida(String partida) {
        List lista = new ArrayList();
        for (Horario h : listaHorarios) {
            if (h.getLocalPartida().equals(partida)) {
                lista.add(h);
            }
        }
        return lista;
    }
    
    public String getListaHorariosString(String partida, Integer diaSemana) {
        String lista = new String();
        for (Horario h : listaHorarios) {
            if (h.getLocalPartida().equals(partida) && h.getDiaSemana().equals(diaSemana)) {
                lista += h.getHora().toString() + " ";
            }
        }
        return lista;
    }

}
