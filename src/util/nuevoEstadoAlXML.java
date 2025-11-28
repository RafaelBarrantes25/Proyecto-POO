/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Conceptos.Estado;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
/**
 * @author Jose Rafael Barrantes Quesada
 * Carné: 2025122443
 * @author Ian Alexander Valerio Steller
 * Carné: 2025085826
 */ 
public class nuevoEstadoAlXML {

    //Modifica el XML para añadir clientes nuevos
    public static void GuardarEstados(ArrayList<Estado> estados, String nombreXML) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();

        
        Element rootElement = doc.createElement("estados");
        doc.appendChild(rootElement);

        for (Estado estado : estados) {

            Element estadoElement = doc.createElement("estado");
            estadoElement.setAttribute("id", estado.getIdentificacion());
            rootElement.appendChild(estadoElement);

            
            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode(estado.getNombre()));
            estadoElement.appendChild(nombre);
        }

        //Modifica el XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        
        //se le da formato
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(nombreXML));
        
        transformer.transform(source, result);
    }
}
