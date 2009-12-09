package org.loststone.toodledo.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.loststone.toodledo.exception.IncorrectUserPasswordException;
import org.loststone.toodledo.exception.MissingPasswordException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetUserIdParser extends DefaultHandler {

	String xml; 
	String tempVal; 
	String userId = null; 
	
	public GetUserIdParser(String xml) {
		tempVal = new String();
		this.xml = xml;
	}
	
	public String getUserId() throws IncorrectUserPasswordException, MissingPasswordException{
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			//get a new instance of parser
			SAXParser sp = spf.newSAXParser();
			//parse the string and also register this class for call backs
			sp.parse(new ByteArrayInputStream(xml.getBytes("UTF-8")), this);

		}catch(SAXException se) {
			se.printStackTrace();
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();
		}
		
		if (userId.equals("0")) {
			throw new MissingPasswordException("Missing password");
		} else if (userId.equals("1")) {
			throw new IncorrectUserPasswordException("Username or password incorrect, or user nonexistant");
		}
		return userId;
	}
	
	//Event Handlers
	public void startElement(String uri, String localName, String qName,
		Attributes attributes) throws SAXException {
		tempVal = "";
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal = new String(ch,start,length);
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equalsIgnoreCase("userid")) {
			userId = tempVal.trim();
		}
	}

	
}
