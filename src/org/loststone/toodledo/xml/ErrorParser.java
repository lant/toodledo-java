package org.loststone.toodledo.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ErrorParser extends DefaultHandler {

	String xml; 
	StringBuilder tempVal;
	String error = null;
	int depth = 0;
	
	public ErrorParser(String xml) {
		this.xml = xml;
	}
	
	/**
	 * Parse the XML and return the Toodledo error text, if any.
	 * Return null if there was no error.
	 * @return the error or null if no error
	 */
	public String getError() {
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
		
		return error;
	}
	
	//Event Handlers
	public void startElement(String uri, String localName, String qName,
		Attributes attributes) throws SAXException {
		tempVal = new StringBuilder();
		depth++;
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal.append(ch, start, length);
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		depth--;
		if(qName.equalsIgnoreCase("error") && depth == 0) {
			error = tempVal.toString().trim();
		}
	}


}
