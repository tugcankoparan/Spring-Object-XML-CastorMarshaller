package com.tugcankoparan.core;
import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.tugcankoparan.core.model.Customer;

public class App {
	private static final String XML_FILE_NAME = "customer.xml";
	
	public static void main(String[] args) throws IOException {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("App.xml");
		XMLConverter converter = (XMLConverter) appContext.getBean("XMLConverter");
		
		Customer customer = new Customer();
		customer.setName("TugcanKoparan");
		customer.setAge(24);
		customer.setFlag(true);
		customer.setAddress("ABD");
		
		System.out.println("Convert Object to XML!");
		converter.convertFromObjectToXML(customer, XML_FILE_NAME);
		System.out.println("Done \n");
		
		System.out.println("Convert XML back to Object!");
		Customer customer2 = (Customer)converter.convertFromXMLToObject(XML_FILE_NAME);
		System.out.println(customer2);
		System.out.println("Done");
		
	}
}