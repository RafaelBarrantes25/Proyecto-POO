/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import Conceptos.Mecanicos;
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
public class MecanicoParserHandler extends DefaultHandler {
    ArrayList<Mecanicos> mecanico = new ArrayList<>();
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

    if ("mecanico".equals(qName)){
        Mecanicos mecanico = new Mecanicos();
        this.pilaObjetos.push(mecanico);
    }
}

@Override
public void endElement(String uri, String localName, String qName) throws SAXException
{
    this.pilaElementos.pop();

    if ("mecanico".equals(qName)) {
        Mecanicos mecanico = (Mecanicos)this.pilaObjetos.pop();
        this.mecanico.add(mecanico);
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

    /* Saca los valores del XML y los asigna al objeto mecanico*/
    if ("identificacion".equals(elementoActual())) {
    Mecanicos mecanico = (Mecanicos)this.pilaObjetos.peek();
    mecanico.setIdentificacion(valor);
    } else if ("nombre".equals(elementoActual())) {
        Mecanicos mecanico = (Mecanicos)this.pilaObjetos.peek();
        mecanico.setNombre(valor);
    } else if ("puesto".equals(elementoActual())) {
        Mecanicos mecanico = (Mecanicos)this.pilaObjetos.peek();
        mecanico.setPuesto(valor);
    }
    
    }

    private String elementoActual()
    {
        return (String)this.pilaElementos.peek();
    }

    public ArrayList getMecanicos()
    {
        return mecanico;
    }


}
