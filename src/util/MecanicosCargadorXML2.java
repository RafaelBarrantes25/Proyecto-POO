/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import Conceptos.Mecanicos;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
/**
 * @author Jose Rafael Barrantes Quesada
 * Carné: 2025122443
 * @author Ian Alexander Valerio Steller
 * Carné: 2025085826
*/ 
public class MecanicosCargadorXML2 {
    public static ArrayList Cargar(InputStream archivo) {
    ArrayList<Mecanicos> mecanicos = new ArrayList<>();

    try {
        InputSource source = new InputSource(archivo);

        MecanicoParserHandler handler = new MecanicoParserHandler();

        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        parserFactory.setNamespaceAware(true);

        SAXParser parser = parserFactory.newSAXParser();

        XMLReader reader = parser.getXMLReader();
        reader.setContentHandler(handler);
        reader.parse(source);
        
        mecanicos = handler.getMecanicos();

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

        return mecanicos;

}
}
