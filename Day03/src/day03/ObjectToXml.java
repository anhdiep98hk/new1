/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day03;

import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class ObjectToXml {

    public static void main(String[] args) throws Exception {
        JAXBContext contextObj = JAXBContext.newInstance(Employee.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Employee emp1 = new Employee(1, "Vimal Jaiswal", 50000);

        marshallerObj.marshal(emp1, new FileOutputStream("employees.xml"));

    }
}
