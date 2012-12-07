package com.cedar.app;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.*;

import android.os.Parcel;
import android.os.Parcelable;

public class Ride   {
	
	public String name;
	public String ridetype;
	public String duration;
	public String heightreq;
	public String speed;
	public String description;
	
	public float mapX;
	public float mapY;
	
	public RideSize size;
	
	public String video;
	
	public enum RideSize
	{
		Small,
		Medium,
		Large,
	}	
	
	public Ride()
	{
		name = "";
		ridetype = "";
		duration ="";
		heightreq ="";
		speed = "";
		description = "";
		
		mapX = 0;
		mapY = 0;
		size = RideSize.Small;
		
		video = "";
	
	}
	
	public static Ride DeserializeFromXML(InputStream path)
	{
		Ride toReturn = new Ride();
		Document dom;
        // Make an  instance of the DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use the factory to take an instance of the document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // parse using the builder to get the DOM mapping of the    
            // XML file
            dom = db.parse(path);

            
            Element doc = dom.getDocumentElement();
           
            toReturn.name = doc.getAttribute("name");
            toReturn.ridetype = doc.getAttribute("ridetype");
            toReturn.duration = doc.getAttribute("duration");
            toReturn.heightreq = doc.getAttribute("heightreq");
            toReturn.speed = doc.getAttribute("speed");
            toReturn.description = doc.getAttribute("description");
            toReturn.mapX = Float.parseFloat(doc.getAttribute("mapX"));
            toReturn.mapY = Float.parseFloat(doc.getAttribute("mapY"));
            toReturn.size = Enum.valueOf(RideSize.class, doc.getAttribute("size"));
            toReturn.video = doc.getAttribute("video");
            
        }
	 catch (ParserConfigurationException pce) {
        System.out.println(pce.getMessage());
    } catch (SAXException se) {
        System.out.println(se.getMessage());
    } catch (IOException ioe) {
        System.err.println(ioe.getMessage());
    }
		
		
		
		
		return toReturn;
	}
	
	
	//Generate the Ride Xml Files
	public static void SerializeToXML(Ride r, Float x, Float y, RideSize s, String filePath) throws FileNotFoundException
	{
		 try {
			 
				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		 
				// root elements
				Document doc = docBuilder.newDocument();
				Element rootElement = doc.createElement("Ride");
				
		 
				// set attribute to Ride element
				rootElement.setAttribute("name", r.name);
				rootElement.setAttribute("ridetype", r.ridetype);
				rootElement.setAttribute("duration", r.duration);
				rootElement.setAttribute("heightreq", r.heightreq);
				rootElement.setAttribute("speed", r.speed);
				rootElement.setAttribute("description", r.description);
				rootElement.setAttribute("mapX", String.valueOf(x));
				rootElement.setAttribute("mapY", String.valueOf(y));
				rootElement.setAttribute("size", String.valueOf(s));
				
				doc.appendChild(rootElement);
			
				// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				//StreamResult result = new StreamResult(new FileOutputStream(filePath));
				
				
		 
				//Output to console for testing
				StreamResult result = new StreamResult(System.out);
		 
				transformer.transform(source, result);
		 
				System.out.println("File saved!" + filePath + ".xml");
		 
			  } catch (ParserConfigurationException pce) {
				  System.out.println(pce.getMessage());
				pce.printStackTrace();
			  } catch (TransformerException tfe) {
				  System.out.println(tfe.getMessage());
				tfe.printStackTrace();
			  }
	}


				
}
