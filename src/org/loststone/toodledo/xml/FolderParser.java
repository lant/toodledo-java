package org.loststone.toodledo.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.loststone.toodledo.data.Folder;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FolderParser extends DefaultHandler {

	String xml; 
	String tempVal; 
	Folder tmp_;
	
	ArrayList<Folder> foldersList; 
	
	public FolderParser(String xml) {
		tempVal = new String();
		this.xml = xml;
		foldersList = new ArrayList<Folder>();
	}
	
	public ArrayList<Folder> getFolders() {
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
		
		return foldersList;
	}
	
	//Event Handlers
	public void startElement(String uri, String localName, String qName,
		Attributes attributes) throws SAXException {
	
		tempVal = "";
		
		if(qName.equalsIgnoreCase("folder")) {
			tmp_ = new Folder();
			//create a new instance of employee
			tmp_.setId(Integer.parseInt(attributes.getValue("id")));
			int tmpBool = Integer.parseInt(attributes.getValue("private"));
			if (tmpBool == 1) 
				tmp_.setBPrivate(true);
			else
				tmp_.setBPrivate(false);
			tmpBool = Integer.parseInt(attributes.getValue("archived"));
			if (tmpBool == 1)
				tmp_.setArchived(true);
			else
				tmp_.setArchived(false);
			tmp_.setOrder(Integer.parseInt(attributes.getValue("order")));
		}
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal = new String(ch,start,length);
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equalsIgnoreCase("folder")) {
			tmp_.setSName(tempVal);
			foldersList.add(tmp_);
		}
	}

	
}
