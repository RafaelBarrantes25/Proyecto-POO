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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 * @author Jose Rafael Barrantes Quesada
 * Carné: 2025122443
 * @author Ian Alexander Valerio Steller
 * Carné: 2025085826
*/ 
public class ServiciosCargadorXML {

    private static String getValue(String etiqueta, Element elemento) {
        NodeList nodeList = elemento.getElementsByTagName(etiqueta);
        
        if (nodeList == null || nodeList.getLength() == 0) {
            return ""; 
        }
        
        Node etiquetaNode = nodeList.item(0);
        
        //manejo de errores
        if (etiquetaNode != null) {
            NodeList nodosHijos = etiquetaNode.getChildNodes();
            if (nodosHijos != null && nodosHijos.getLength() > 0) {
                Node nodo = nodosHijos.item(0);

                if (nodo != null && nodo.getNodeType() == Node.TEXT_NODE) {
                    return nodo.getNodeValue().trim(); 
                }
            }
        }
        return "";
    }

    public static ArrayList<Servicio> Cargar(String nombreXML) {
        ArrayList<Servicio> servicios = new ArrayList<>();

        try {
            File archivo = new File(nombreXML);
            DocumentBuilderFactory industria = DocumentBuilderFactory.newInstance();
            DocumentBuilder creador = industria.newDocumentBuilder();
            Document docXML = creador.parse(archivo);
            docXML.getDocumentElement().normalize();

            NodeList nodos = docXML.getElementsByTagName("servicio");
            
            for (int k=0; k<nodos.getLength(); k++){
                Node nodo = nodos.item(k);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element)nodo;
                    //la id es atributo, no elemento
                    String identificacion = elemento.getAttribute("id"); 

                    String nombre = getValue("nombre",elemento);
                    String precio = getValue("precio",elemento);
                    Servicio servicio = new Servicio(identificacion,nombre,precio);
                    servicios.add(servicio);
                }
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        
    
    return servicios;
    }
}

