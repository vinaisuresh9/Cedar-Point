package com.cedar.app;

public class Ride {
	
	public String duration;
	public String heightreq;
	public String speed;
	public String description;
	
	public Ride()
	{
		duration ="";
		heightreq ="";
		speed = "";
		description = "";
	
	}
	
	public static Ride DeserializeFromXML(String filePath)
	{
		Ride toReturn = new Ride();
		//DO STUFF
		return toReturn;
	}
	
	public void SerializeToXML(String filePath)
	{
		// DO STUFF	
	}
}
