/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author diep.tv
 */
public class StudentHander extends DefaultHandler {
    List<Student> studentList = new ArrayList<Student>();
    boolean isName = false;
    boolean isAge = false;
    boolean isEmail = false;
    boolean isAddress = false;
    boolean isPhoneNumber = false;
    Student student = null;
    
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
//        System.out.println("start node >>" + qName + ":" + uri + ":" + localName);
        if(qName.equals("student")) {
            student = new Student();
        } else if(qName.equals("name")) {
            isName = true;
        } else if(qName.equals("age")) {
            isAge = true;
        } else if(qName.equals("address")) {
            isAddress = true;
        } else if(qName.equals("email")) {
            isEmail = true;
        } else if(qName.equals("phone_number")) {
            isPhoneNumber = true;
        }
    }

    public void endElement(String uri, String localName, String qName) {  
//        System.out.println("end node >>" + qName + ":" + uri + ":" + localName);
        if(qName.equals("student")) {
            studentList.add(student);
            System.err.println(student.toString());
        } else if(qName.equals("name")) {
            isName = false;
        } else if(qName.equals("age")) {
            isAge = false;
        } else if(qName.equals("address")) {
            isAddress = false;
        } else if(qName.equals("email")) {
            isEmail = false;
        } else if(qName.equals("phone_number")) {
            isPhoneNumber = false;
        }
    }

    public void characters(char[] buf, int start, int len) {
        StringBuilder hh = new StringBuilder();
        hh.append(buf, start, len);
//        System.out.println("Content >> " + hh.toString());
        if(isName) {
            student.setName(hh.toString());
        } else if(isAge) {
            student.setAge(Integer.parseInt(hh.toString()));
        } else if(isAddress) {
            student.setAddress(hh.toString());
        } else if(isEmail) {
            student.setEmail(hh.toString());
        } else if(isPhoneNumber) {
            student.setPhoneNumber(hh.toString());
        }
    }

    public List<Student> getResults() {
        return studentList;
    }
}