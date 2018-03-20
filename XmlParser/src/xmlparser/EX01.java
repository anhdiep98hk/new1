/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlparser;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 *
 * @author C1607G3888
 */
public class EX01 {
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
         
         
            Node nNode = nList.item(2);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
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
         
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
