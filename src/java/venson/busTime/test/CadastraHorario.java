package venson.busTime.test;

import venson.busTime.modelo.Horario;
import venson.busTime.modelo.Linha;
import venson.busTime.modelo.SimpleTime;

public class CadastraHorario {
    
    static Linha linha = new Linha();

    public static Linha init() {
        
        linha.setItinerario(" Itinerário: Terminal Central / Av Centenario / Rua Santa Catarina / Rua Desmbargador Pedro Silva / Rod Luiz Rosso / BR-101 / Portico / Portinari / Retorno BR-101 / Rod Luiz Rosso / Av Santos Dumont / Rua Joaquim Nabuco / Av Centenário / Terminal Central.");
        linha.setNome("Quarta Linha - Portinari");
        linha.setNumero(201);
        linha.setTipo("Normal");
        
        salvar("Terminal Central", 2, "00:05A 04:20 05:18 05:43 06:16A 06:30B 06:49 07:25 07:29B 07:58A 08:24B 08:34 09:06A 09:43 10:14A 10:48 11:22 11:57 12:05C 12:28 13:06 13:35A 14:15 14:44 15:20 15:50A 16:29 16:50B 17:02A 17:41 17:51B 18:10C 18:14 18:52 19:23A 19:58 20:30A 21:00 21:37A 22:02C 23:17A");
        salvar("Bairro", 2, "04:20A 05:06 05:48 06:00B 06:15 06:41A 07:00B 07:24 07:55B 07:57 08:24A 08:50B 09:06 09:31A 10:13 10:39A 11:20 11:52 12:29 12:40C 13:00 13:38 14:02A 14:45 15:19 15:52 16:15A 17:05 17:17B 17:32A 18:14 18:20B 18:44 18:50C 19:23 19:53A 20:32 20:55A 21:30 22:02A 22:37C 23:40A");
        salvar("Terminal Central", 7, "04:20 05:26 06:08 07:12 08:16 09:20 10:24 11:28 12:32 14:52 17:12 18:16 19:20 21:40 23:10");
        salvar("Bairro", 7, "04:20A 05:06 05:56 06:38 07:42 08:46 09:50 10:54 11:58 13:02 15:22 17:42 18:46 19:50 22:10 23:40");
        salvar("Terminal Central", 1, "04:20 05:18 05:40 08:04 09:08 10:12 11:16 13:40 14:44 17:08 18:12 19:16 21:40 23:00");
        salvar("Bairro", 1, "05:06 05:47 06:10 08:34 09:38 10:42 11:46 14:10 15:14 17:38 18:42 19:46 22:10 23:30");
        
        /*
        for(Horario h : linha.getListaHorarios()){
            SimpleTime horaAtual = new SimpleTime();
            SimpleTime horaOnibus = h.getHora();
            horaAtual.setToAtualTime();
            
            if(!horaOnibus.isAfter(horaAtual)){
                System.out.println(horaOnibus.toString() + " - Já foi!");
            } else {
                System.out.println(horaOnibus.toString());
            }
        }*/
        
        System.out.println(linha.nextBus("Bairro").getHora().toString());
        
        return linha;
    }
    
    public static void salvar(String partida, Integer diaSemana, String text){
        int hour, minute;
        String[] split = text.split(" ");
        for(String s : split){
            s = s.replaceAll("[a-zA-Z\\s]", "");
            hour = Integer.parseInt(s.substring(0, 2));
            minute = Integer.parseInt(s.substring(3, 5));
            linha.getListaHorarios().add(new Horario(partida, new SimpleTime(hour, minute), diaSemana));
        }
    }
}
