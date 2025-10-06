/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import Conceptos.Servicios;
import java.util.ArrayList;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Jose Rafael Barrantes Quesada
 * Carné: 2025122443
 * @author Ian Alexander Valerio Steller
 * Carné: 2025085826
*/ 
public class ServiciosParserHandler extends DefaultHandler {
    ArrayList<Servicios> servicio = new ArrayList<>();
    Stack pilaElementos = new Stack();
    Stack pilaObjetos = new Stack();
    
@Override
public void startDocument() throws SAXException
{
}

@Override
public void endDocument() throws SAXException
{
}

@Override
public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
{
    this.pilaElementos.push(qName);

    if ("servicio".equals(qName)){
        Servicios servicio = new Servicios();
        
        //Se obtiene la id aca porque es un atributo
        String id = attributes.getValue("id");
        if (id != null){
            servicio.setIdentificacion(id);
        }
        this.pilaObjetos.push(servicio);
    }
}

@Override
public void endElement(String uri, String localName, String qName) throws SAXException
{
    this.pilaElementos.pop();

    if ("servicio".equals(qName)) {
        Servicios servicio = (Servicios)this.pilaObjetos.pop();
        this.servicio.add(servicio);
    }
}

@Override
public void characters(char[] ch, int start, int length) throws SAXException
{
    String valor = new String(ch, start, length).trim();

    /* Si es espacios en blanco, terminar */
    if (valor.length() == 0)
    {
        return;
    }

    /* Saca los valores del XML y los asigna al objeto servicio
       El id se hace antes, porque es un startElement
    */
    if ("nombre".equals(elementoActual())) {
        Servicios servicio = (Servicios)this.pilaObjetos.peek();
        servicio.setNombre(valor);
    } else if ("precio".equals(elementoActual())) {
        Servicios servicio = (Servicios)this.pilaObjetos.peek();
        servicio.setPrecio(valor);
    }
    
    }

    private String elementoActual()
    {
        return (String)this.pilaElementos.peek();
    }

    public ArrayList getServicios()
    {
        return servicio;
    }


}
