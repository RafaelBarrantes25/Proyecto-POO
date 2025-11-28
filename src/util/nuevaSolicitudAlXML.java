/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Conceptos.Solicitud;
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
public class nuevaSolicitudAlXML {

    //Modifica el XML para añadir solicitudes nuevas
    public static void GuardarSolicitudes(ArrayList<Solicitud> solicitudes, String nombreXML) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();

        
        Element rootElement = doc.createElement("solicitudes");
        doc.appendChild(rootElement);

        for (Solicitud solicitud : solicitudes) {

            Element solicitudElement = doc.createElement("solicitud");
            solicitudElement.setAttribute("id", solicitud.getIdentificacion());
            rootElement.appendChild(solicitudElement);
            
            Element placa = doc.createElement("placa");
            placa.appendChild(doc.createTextNode(solicitud.getPlaca()));
            solicitudElement.appendChild(placa);

            Element servicio = doc.createElement("servicio");
            servicio.appendChild(doc.createTextNode(solicitud.getServicio()));
            solicitudElement.appendChild(servicio);
            
            Element cliente = doc.createElement("cliente");
            cliente.appendChild(doc.createTextNode(solicitud.getCliente()));
            solicitudElement.appendChild(cliente);

            Element mecanico = doc.createElement("mecanico");
            mecanico.appendChild(doc.createTextNode(solicitud.getMecanico()));
            solicitudElement.appendChild(mecanico);
            
            Element estado = doc.createElement("estado");
            estado.appendChild(doc.createTextNode(solicitud.getEstado()));
            solicitudElement.appendChild(estado);

            Element observaciones = doc.createElement("observaciones");
            observaciones.appendChild(doc.createTextNode(solicitud.getObservaciones()));
            solicitudElement.appendChild(observaciones);
            
            Element otrosServicios = doc.createElement("otros_servicios");
            ArrayList<String> servicios = solicitud.getOtrosServicios();
            for(String otroServicio : servicios){
                Element id = doc.createElement("id");
                id.appendChild(doc.createTextNode(otroServicio));
                otrosServicios.appendChild(id);
            }
            solicitudElement.appendChild(otrosServicios);
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
