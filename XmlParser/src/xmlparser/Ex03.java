/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlparser;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import org.w3c.dom.NodeList;

/**
 *
 * @author C1607G3888
 */
public class Ex03 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("note");
            doc.appendChild(rootElement);

            
            
            
            Element to = doc.createElement("to");
            to.setTextContent("Tove");
            rootElement.appendChild(to);
            
            Element from = doc.createElement("from");
            from.setTextContent("Tove");
            rootElement.appendChild(from);
            
            Element heading = doc.createElement("heading");
            heading.setTextContent("Reminder");
            rootElement.appendChild(heading);
            
            Element body = doc.createElement("body");
            body.setTextContent("Don't forget me this weekend!");
            rootElement.appendChild(body);
            
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\c1607g3888\\Downloads\\xml\\ex03.xml"));
            transformer.transform(source, result);
            
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
