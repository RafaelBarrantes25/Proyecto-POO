/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package util;

import Conceptos.Mecanicos;
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
public class nuevoMecanicoAlXML {

    //Modifica el XML para añadir mecanicos nuevos
    public static void GuardarMecanicos(ArrayList<Mecanicos> mecanicos, String nombreXML) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();

        
        Element rootElement = doc.createElement("mecanicos");
        doc.appendChild(rootElement);

        for (Mecanicos mecanico : mecanicos) {

            Element mecanicoElement = doc.createElement("mecanico");
            mecanicoElement.setAttribute("id", mecanico.getIdentificacion());
            rootElement.appendChild(mecanicoElement);

            
            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode(mecanico.getNombre()));
            mecanicoElement.appendChild(nombre);

            Element telefono = doc.createElement("puesto");
            telefono.appendChild(doc.createTextNode(mecanico.getPuesto()));
            mecanicoElement.appendChild(telefono);
            
            Element servicios = doc.createElement("servicios");
            ArrayList<String> validados = mecanico.getServiciosValidados();
            for(String servicio : validados){
                Element id = doc.createElement("id");
                id.appendChild(doc.createTextNode(servicio));
                servicios.appendChild(id);
            }
            mecanicoElement.appendChild(servicios);
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

