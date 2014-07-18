package actubusxmlconverter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ACTUBusXMLConverter {

    public static void main(String[] args) throws Exception {   
        
        String page = getPageFixed();
        
        //Tratamento 0 - Divide o html e separa os blocos
        String[] regex = page.split("(<font size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">)|(</font>)");
        
        //Tratamento 1 - Retira Tabs
        for(int i = 0; i < regex.length ; i++){
            regex[i] = regex[i].replaceAll("\t", "");
        }
        
        //Tratameto 2 - Retira Tags
        for(int i = 0; i < regex.length ; i++){
            regex[i] = regex[i].replaceAll("<br>", "");
        }
        
        //Tratamento 3 - Retira Letras
        for(int i = 0; i < regex.length ; i++){
            regex[i] = regex[i].replaceAll("[a-zA-Z]\\s", " ");
        }
        
        //Tratamento 4 - Seleciona os horários
        String hTerminalSegunda = regex[11];
        String hBairroSegunda = regex[13];
        String hTerminalSabado = regex[19];
        String hBairroSabado = regex[21];
        String hTerminalDomingo = regex[27];
        String hBairroDomingo = regex[29];
        
        //Tratamento 5 - Divide os horários e cadastra
        ToXML xml = new ToXML("Quarta Linha - Portinari", 201);
        String[] split;
        
        split = hTerminalSegunda.split("\\s");
        for(String s : split){
            xml.newElement("horario");
            xml.newAttr("hora", s);
            xml.newAttr("partida", "Terminal Central");
            xml.newAttr("DiaSemana", "2");
        }
        
        split = hBairroSegunda.split("\\s");
        for(String s : split){
            xml.newElement("horario");
            xml.newAttr("hora", s);
            xml.newAttr("partida", "Bairro");
            xml.newAttr("DiaSemana", "2");
        }
        
        split = hTerminalSabado.split("\\s");
        for(String s : split){
            xml.newElement("horario");
            xml.newAttr("hora", s);
            xml.newAttr("partida", "Terminal Central");
            xml.newAttr("DiaSemana", "7");
        }
        
        split = hBairroSabado.split("\\s");
        for(String s : split){
            xml.newElement("horario");
            xml.newAttr("hora", s);
            xml.newAttr("partida", "Bairro");
            xml.newAttr("DiaSemana", "7");
        }
        
        split = hTerminalDomingo.split("\\s");
        for(String s : split){
            xml.newElement("horario");
            xml.newAttr("hora", s);
            xml.newAttr("partida", "Terminal Central");
            xml.newAttr("DiaSemana", "1");
        }
        
        split = hBairroDomingo.split("\\s");
        for(String s : split){
            xml.newElement("horario");
            xml.newAttr("hora", s);
            xml.newAttr("partida", "Bairro");
            xml.newAttr("DiaSemana", "1");
        }
        
        xml.write();
        
        //System.out.println(regex[21]);
        
        /*
        System.out.println(regex[11]);
        System.out.println("----------------------------------------");
        System.out.println(regex[13]);
        System.out.println("----------------------------------------");
        System.out.println(regex[19]);
        System.out.println("----------------------------------------");
        System.out.println(regex[21]);
        System.out.println("----------------------------------------");
        System.out.println(regex[27]);
        System.out.println("----------------------------------------");
        System.out.println(regex[29]);
        */
        
        /*
        for(String s : regex){
            System.out.println("----------------------------------------");
            System.out.println(s);
        }*/
        
        /*
        String[] split = regex[14].split("\\s");
        String horario1 = new String();
        for(String s : split){
            if(!s.isEmpty()){
            horario1 += s.replaceAll("[ %#\"=<>/a-zA-Z\\s]", "") + "\n";
            }
        }
        System.out.println(horario1);
                */
        
        
    }
    
    private static String getPage(){
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;

        try {
            url = new URL("http://www.actu.com.br/linha.php?codigo_lin=90");
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));
            String page = new String();

            while ((line = br.readLine()) != null) {
                page += line + "\n";
            }
            return page;
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ioe) {
                // nothing to see here
            }
        }
        return null;
    }
    
    
    private static String getPageFixed() throws FileNotFoundException, IOException{
        File file = new File("/home/venson/Downloads/ACTU - Associação Criciumense de Transporte Urbano.htm");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String ret = new String();
        String line;
       
        while((line = buffer.readLine()) != null){
            ret += line + "\n";
        }
        
        return ret;
    }

}
