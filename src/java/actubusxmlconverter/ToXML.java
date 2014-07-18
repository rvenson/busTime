/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actubusxmlconverter;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author venson
 */
public class ToXML {

    private DocumentBuilderFactory docFactory;
    private DocumentBuilder docBuilder;
    private Document doc;
    private Element rootElement;
    private Element atualElement;
    private Attr attr;

    public ToXML(String linha, Integer num) {
        try {
            docFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docFactory.newDocumentBuilder();

            //root elements
            doc = docBuilder.newDocument();

            rootElement = doc.createElement("linha");
            doc.appendChild(rootElement);
            
            attr = doc.createAttribute("nome");
            attr.setValue(linha);
            rootElement.setAttributeNode(attr);
            
            attr = doc.createAttribute("numero");
            attr.setValue(num.toString());
            rootElement.setAttributeNode(attr);

        } catch (Exception ex) {
            Logger.getLogger(ToXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void newElement(String name) {
        atualElement = doc.createElement(name);
        rootElement.appendChild(atualElement);
    }

    public void newAttr(String name, String value) {
        attr = doc.createAttribute(name);
        attr.setValue(value);
        atualElement.setAttributeNode(attr);
    }

    public void write() throws TransformerConfigurationException, TransformerException {
        //write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);

        StreamResult result = new StreamResult(new File("/home/venson/teste.xml"));
        transformer.transform(source, result);

        System.out.println("Done");
    }

}
