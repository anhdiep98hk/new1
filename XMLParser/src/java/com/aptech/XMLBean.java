/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech;

import com.sun.org.apache.xerces.internal.parsers.SAXParser;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author diep.tv
 */
@ManagedBean(name="xml")
public class XMLBean implements Serializable{
    String data = "test";

    public String getData() {
        System.err.println("------------------------start test----------------------------------------");
        //test parser xml
        StudentHander handler = new StudentHander();
        SAXParser parser = new SAXParser();
        parser.setContentHandler(handler); // Might have to mke AServlet.AskScanner
        parser.setErrorHandler(handler);
        String url = "file:///C:/Users/diep.tv/Documents/NetBeansProjects/XMLParser/web/vidu.xml";
        try {
                System.out.println("start testing...");
              parser.parse(url);
                System.out.println("end testing...");
        } catch (Exception e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
        }
        //end parser xml
        
        System.err.println("------------------------end test----------------------------------------");
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
