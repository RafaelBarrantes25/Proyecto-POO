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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 *
 * @author Rafael
 */
public class MecanicosCargadorXML {

    private static String getValue(String etiqueta, Element elemento) {
        NodeList nodos = elemento.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node nodo = (Node) nodos.item(0);
        return nodo.getNodeValue();
    }

    public static ArrayList<Mecanicos> Cargar(String nombreXML) {
        ArrayList<Mecanicos> mecanicos = new ArrayList<>();

        try {
            File archivo = new File(nombreXML);
            DocumentBuilderFactory industria = DocumentBuilderFactory.newInstance();
            DocumentBuilder creador = industria.newDocumentBuilder();
            Document docXML = creador.parse(archivo);
            docXML.getDocumentElement().normalize();

            NodeList nodos = docXML.getElementsByTagName("cliente");
            
            for (int k=0; k<nodos.getLength(); k++){
                Node nodo = nodos.item(k);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element)nodo;
                    String identificacion = getValue("id",elemento);
                    String nombre = getValue("nombre",elemento);
                    String puesto = getValue("puesto",elemento);
                    Mecanicos mecanico = new Mecanicos(identificacion,nombre,puesto);
                    mecanicos.add(mecanico);
                }
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        
    
    return mecanicos;
    }
}

