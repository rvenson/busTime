package venson.busTime.test;

import java.util.ArrayList;
import java.util.List;
import venson.busTime.modelo.Horario;
import venson.busTime.modelo.Linha;
import venson.busTime.modelo.SimpleTime;

public class test {
    
    public static void main(String[] args) {
        
        Linha linha1 = new Linha();
        linha1.setItinerario("Rua A; Rua B; Rua C");
        linha1.setNome("Centro");
        linha1.setNumero(100);
        linha1.setTipo("Normal");
        
        List<Horario> listaHorario = new ArrayList();
        
        listaHorario.add(new Horario("Terminal Central", new SimpleTime(10,20), 1));
        listaHorario.add(new Horario("Terminal Central", new SimpleTime(11,30), 1));
        listaHorario.add(new Horario("Terminal Central", new SimpleTime(12,20), 1));
        listaHorario.add(new Horario("Terminal Central", new SimpleTime(12,50), 1));
        
        linha1.setListaHorarios(listaHorario);
        
        for(Horario h : linha1.getListaHorarios()){
            System.out.println("Horario: " + h.getHora().toString());
        }
        
        SimpleTime h1 = linha1.getListaHorarios().get(1).getHora();
        SimpleTime h2 = linha1.getListaHorarios().get(0).getHora();
        
        System.out.println("H1 ("+h1.toString()+") é maior que H2 ("+h2.toString()+")?");
        System.out.println(h1.isAfter(h2));
        
    }
    
}
