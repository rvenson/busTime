package venson.busTime.mb;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import venson.busTime.modelo.Horario;
import venson.busTime.modelo.Linha;
import venson.busTime.test.CadastraHorario;

@ManagedBean
@RequestScoped
public class mainMB {
    
    Linha linha;
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
        linha = CadastraHorario.init();
    }

    public Linha getLinha() {
        return linha;
    }

    public void setLinha(Linha linha) {
        this.linha = linha;
    }
    
}
