/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import Conceptos.Cliente;
import java.util.ArrayList;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * * @author Rafael
 * */
public class ClienteParserHandler extends DefaultHandler {
    ArrayList<Cliente> clientes = new ArrayList<>();
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

    if ("cliente".equals(qName)){
        Cliente cliente = new Cliente();
        this.pilaObjetos.push(cliente);
    }
}

@Override
public void endElement(String uri, String localName, String qName) throws SAXException
{
    this.pilaElementos.pop();

    if ("cliente".equals(qName)) {
        Cliente cliente = (Cliente)this.pilaObjetos.pop();
        this.clientes.add(cliente);
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

    /* Saca los valores del XML y los asigna al objeto cliente*/
    if ("nombre".equals(elementoActual())) {
    Cliente cliente = (Cliente)this.pilaObjetos.peek();
    cliente.setNombre(valor);
    } else if ("placa".equals(elementoActual())) {
        Cliente cliente = (Cliente)this.pilaObjetos.peek();
        cliente.setPlaca(valor);
    } else if ("telefono".equals(elementoActual())) {
        Cliente cliente = (Cliente)this.pilaObjetos.peek();
        cliente.setTelefono(valor);
    }
    
    }

    private String elementoActual()
    {
        return (String)this.pilaElementos.peek();
    }

    public ArrayList getClientes()
    {
        return clientes;
    }


}
