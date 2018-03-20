/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlparser;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author C1607G3888
 */
public class EX02 {
    public static void main(String[] args) {
        try {
         File inputFile = new File("test1.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         NodeList nList = doc.getElementsByTagName("CD");
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               
               Cd c = new Cd(eElement.getElementsByTagName("TITLE").item(0).getTextContent(), eElement.getElementsByTagName("ARTIST").item(0).getTextContent(), eElement.getElementsByTagName("COUNTRY").item(0).getTextContent(), eElement.getElementsByTagName("COMPANY").item(0).getTextContent(), eElement.getElementsByTagName("PRICE").item(0).getTextContent(), Integer.parseInt(eElement.getElementsByTagName("YEAR").item(0).getTextContent()));
               if(c.getYear() <1990){
                   System.out.println("TITLE : " 
                  + eElement
                  .getElementsByTagName("TITLE")
                  .item(0)
                  .getTextContent());
               System.out.println("ARTIST : " 
                  + eElement
                  .getElementsByTagName("ARTIST")
                  .item(0)
                  .getTextContent());
               System.out.println("COUNTRY : " 
                  + eElement
                  .getElementsByTagName("COUNTRY")
                  .item(0)
                  .getTextContent());
               System.out.println("COMPANY : " 
                  + eElement
                  .getElementsByTagName("COMPANY")
                  .item(0)
                  .getTextContent());
               System.out.println("PRICE : " 
                  + eElement
                  .getElementsByTagName("PRICE")
                  .item(0)
                  .getTextContent());
               System.out.println("YEAR : " 
                  + eElement
                  .getElementsByTagName("YEAR")
                  .item(0)
                  .getTextContent());
               }
               
            }
         }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
