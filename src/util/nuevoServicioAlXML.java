/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package util;

import Conceptos.Servicio;
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
public class nuevoServicioAlXML {

    //Modifica el XML para añadir mecanicos nuevos
    public static void GuardarServicios(ArrayList<Servicio> servicios, String nombreXML) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();

        
        Element rootElement = doc.createElement("servicios");
        doc.appendChild(rootElement);

        for (Servicio servicio : servicios) {

            Element servicioElement = doc.createElement("servicio");
            servicioElement.setAttribute("id", servicio.getIdentificacion());
            rootElement.appendChild(servicioElement);

            
            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode(servicio.getNombre()));
            servicioElement.appendChild(nombre);

            Element telefono = doc.createElement("precio");
            telefono.appendChild(doc.createTextNode(servicio.getPrecio()));
            servicioElement.appendChild(telefono);
            
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

