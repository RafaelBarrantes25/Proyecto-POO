/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Conceptos.Estado;
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
public class EstadoParserHandler extends DefaultHandler{
    ArrayList<Estado> estados = new ArrayList<>();
    Stack pilaElementos = new Stack();
    Stack pilaObjetos = new Stack();
    
    @Override
    public void startDocument() throws SAXException{
    }

    @Override
    public void endDocument() throws SAXException{
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException{
        this.pilaElementos.push(qName);

        if ("estado".equals(qName)){
            Estado estado = new Estado();
           this.pilaObjetos.push(estado);
    
          String id = attributes.getValue("id");
          estado.setIdentificacion(id);
            this.pilaObjetos.push(estado);
        }
}

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException{
        this.pilaElementos.pop();

        if ("estado".equals(qName)) {
            Estado estado = (Estado)this.pilaObjetos.pop();
            this.estados.add(estado);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException{
        String valor = new String(ch, start, length).trim();

        /* Si es espacios en blanco, terminar */
        if (valor.length() == 0){
            return;
        }

        if("nombre".equals(elementoActual())){
            Estado estado = (Estado)this.pilaObjetos.peek();
            estado.setNombre(valor);
            
        }
    }

    private String elementoActual()
    {
        return (String)this.pilaElementos.peek();
    }

    public ArrayList getSolicitudes()
    {
        return estados;
    }
}
