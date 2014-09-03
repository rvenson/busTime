package venson.busTime.mb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import venson.busTime.modelo.Horario;
import venson.busTime.modelo.Linha;
import venson.busTime.test.CadastraHorario;

@ManagedBean
public class mainMB {
    
    Linha linha = null;
    Horario terminal;
    Horario bairro;
    List<Horario> lista = new ArrayList();

    public mainMB() {
        init();
    }
    
    public String nextBus(String partida){
        return linha.nextBus(partida).getHora().toString();
    }
    
    private void init(){
        if(linha == null){
        linha = CadastraHorario.init();
        }
    }

    public Linha getLinha() {
        return linha;
    }

    public void setLinha(Linha linha) {
        this.linha = linha;
    }
    
}
