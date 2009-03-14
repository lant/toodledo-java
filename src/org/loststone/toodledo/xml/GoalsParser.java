package org.loststone.toodledo.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.loststone.toodledo.Goal;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GoalsParser extends DefaultHandler {

	String xml; 
	String tempVal; 
	Goal tmp_;
	
	ArrayList<Goal> goalsList; 
	
	public GoalsParser(String xml) {
		tempVal = new String();
		this.xml = xml;
		goalsList = new ArrayList<Goal>();
	}
	
	public ArrayList<Goal> getGoals() {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			//get a new instance of parser
			SAXParser sp = spf.newSAXParser();
			//parse the string and also register this class for call backs
			sp.parse(new ByteArrayInputStream(xml.getBytes()), this);

		}catch(SAXException se) {
			se.printStackTrace();
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();
		}
		
		return goalsList;
	}
	
	//Event Handlers
	public void startElement(String uri, String localName, String qName,
		Attributes attributes) throws SAXException {
	
		tempVal = "";
		
		if(qName.equalsIgnoreCase("goal")) {
			tmp_ = new Goal();
			//create a new instance of employee
			tmp_.setId(Integer.getInteger(attributes.getValue("id")));
			tmp_.setLevel(Integer.getInteger(attributes.getValue("level")));
			tmp_.setContributes(Integer.getInteger(attributes.getValue("contributes")));
			int tmpBool = Integer.getInteger(attributes.getValue("archived"));
			if (tmpBool == 1)
				tmp_.setArchive(true);
			else
				tmp_.setArchive(false);
		}
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal = new String(ch,start,length);
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equalsIgnoreCase("goal")) {
			tmp_.setName(tempVal);
			goalsList.add(tmp_);
		}
	}

	
}
