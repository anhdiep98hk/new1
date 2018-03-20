/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlparser;

/**
 *
 * @author C1607G3888
 */
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EX04 {

    public static void main(String[] args) {
        try {
            String filepath = "test4.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);

            NodeList nList = doc.getElementsByTagName("food");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node staff = doc.getElementsByTagName("food").item(temp);
                Element eElement = (Element) staff;
                int getValue = Integer.parseInt(eElement.getElementsByTagName("calories").item(0).getTextContent());
                Element energy = doc.createElement("Energy");
                energy.appendChild(doc.createTextNode(getValue*1.5+""));
                staff.appendChild(energy);
            }


            

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);

            System.out.println("Done");

            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);

        } catch (Exception pce) {
            pce.printStackTrace();
        }
    }
}
