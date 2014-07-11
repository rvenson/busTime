package venson.busTime.modelo;

import java.util.Date;

public class SimpleTime {

    private int hour;
    private int minute;

    public SimpleTime() {
        this.hour = 0;
        this.minute = 0;
    }

    public SimpleTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    /* 
    
    */

    /**
     * Compara esta hora com outra recebida por parametro.
     * @param time
     * @return Se esta for maior que a recebida por parametro
    retorna true, caso contrário, falso.
    Se ambas forem identicas, retorna falso;
     */
    
    public boolean isAfter(SimpleTime time) {

        if (this.hour > time.getHour()) {
            return true;
        } else if (this.hour < time.getHour()) {
            return false;
        } else {
            if (this.minute > time.getMinute()) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Compara se as horas são idênticas.
     * @param time
     * @return Retorna verdadeiro se forem idênticas
     */
    
    public boolean compare(SimpleTime time) {
        if(this.hour == time.getHour() && this.minute == time.getMinute()){
            return true;
        }
        return false;
    }
    
    /**
     * Hora Atual
     * @return Retorna a hora atual
     */
    
    public static SimpleTime atualTime(){
        SimpleTime atual = new SimpleTime();
        atual.setToAtualTime();
        return atual;
    }
    
    /**
     * Atualiza para a hora atual da máquina
     */
    
    public void setToAtualTime(){
        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        this.hour = date.getHours();
        this.minute = date.getMinutes();
    }

    /**
     * Representação textual da hora
     * @return Retorna uma String com hora e minutos
    separados por ':'
     */
    
    @Override
    public String toString(){
        
        String sMinute = String.valueOf(minute);
        String sHour = String.valueOf(hour);
        
        if(minute < 10){
            sMinute = "0" + minute;
        }
        
        if(hour < 10){
            sHour = "0" + hour;
        }
        
        return sHour + ":" + sMinute;
    }

}
