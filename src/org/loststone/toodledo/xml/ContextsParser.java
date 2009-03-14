package org.loststone.toodledo.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.loststone.toodledo.Context;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ContextsParser extends DefaultHandler {

	String xml; 
	String tempVal; 
	Context tmp_;
	
	ArrayList<Context> contextList; 
	
	public ContextsParser(String xml) {
		tempVal = new String();
		this.xml = xml;
		contextList = new ArrayList<Context>();
	}
	
	public ArrayList<Context> getContexts() {
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
		
		return contextList;
	}
	
	//Event Handlers
	public void startElement(String uri, String localName, String qName,
		Attributes attributes) throws SAXException {
	
		tempVal = "";
		
		if(qName.equalsIgnoreCase("context")) {
			tmp_ = new Context();
			tmp_.setId(Integer.getInteger(attributes.getValue("id")));
		}
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal = new String(ch,start,length);
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equalsIgnoreCase("context")) {
			tmp_.setName(tempVal);
			contextList.add(tmp_);
		}
	}

	
}
