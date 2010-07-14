package org.loststone.toodledo.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.loststone.toodledo.data.Priority;
import org.loststone.toodledo.data.Status;
import org.loststone.toodledo.data.Todo;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetTodosParser extends DefaultHandler {

	String xml;
	StringBuilder tempVal;
	Todo tmp_;

	ArrayList<Todo> todoList;

	public GetTodosParser(String xml) {
		this.xml = xml;
		todoList = new ArrayList<Todo>();
	}

	public ArrayList<Todo> getTodos() {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			// get a new instance of parser
			SAXParser sp = spf.newSAXParser();
			// parse the string and also register this class for call backs
			sp.parse(new ByteArrayInputStream(xml.getBytes("UTF-8")), this);

		} catch (SAXException se) {
			se.printStackTrace();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}

		return todoList;
	}

	// Event Handlers
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		tempVal = new StringBuilder();

		if (qName.equalsIgnoreCase("task")) {
			tmp_ = new Todo();
		} else if (qName.equalsIgnoreCase("context")) {
			tmp_.setContext(Integer.parseInt(attributes.getValue("id")));
		} else if (qName.equalsIgnoreCase("goal")) {
			tmp_.setGoal(Integer.parseInt(attributes.getValue("id")));
		}
	}

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		tempVal.append(ch, start, length);
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equalsIgnoreCase("task")) {
			todoList.add(tmp_);
		} else if (qName.equalsIgnoreCase("id")) {
			tmp_.setId(Integer.parseInt(tempVal.toString()));
		} else if (qName.equalsIgnoreCase("parent")) {
			tmp_.setParent(Integer.parseInt(tempVal.toString()));
		} else if (qName.equalsIgnoreCase("children")) {
			// TODO
		} else if (qName.equalsIgnoreCase("title")) {
			tmp_.setTitle(tempVal.toString());
		} else if (qName.equalsIgnoreCase("tag")) {
			tmp_.setTag(tempVal.toString());
		} else if (qName.equalsIgnoreCase("folder")) {
			tmp_.setFolder(Integer.parseInt(tempVal.toString()));
		} else if (qName.equalsIgnoreCase("context")) {
		} else if (qName.equalsIgnoreCase("goal")) {
		} else if (qName.equalsIgnoreCase("added")) {
			// TODO
		} else if (qName.equalsIgnoreCase("modified")) {
			// TODO
		} else if (qName.equalsIgnoreCase("startdate")) {
			// TODO
		} else if (qName.equalsIgnoreCase("duedate")) {
			// TODO
		} else if (qName.equalsIgnoreCase("duetime")) {
			// TODO
		} else if (qName.equalsIgnoreCase("completed")) {
			// TODO
		} else if (qName.equalsIgnoreCase("repeat")) {
			// TODO
		} else if (qName.equalsIgnoreCase("rep_advanced")) {

		} else if (qName.equalsIgnoreCase("status")) {
			switch (Integer.parseInt(tempVal.toString())) {
			case 0:
				tmp_.setStatus(Status.NONE);
				break;
			case 1:
				tmp_.setStatus(Status.NEXT_ACTION);
				break;
			case 2:
				tmp_.setStatus(Status.ACTIVE);
				break;
			case 3:
				tmp_.setStatus(Status.PLANNING);
				break;
			case 4:
				tmp_.setStatus(Status.DELEGATED);
				break;
			case 5:
				tmp_.setStatus(Status.WAITING);
				break;
			case 6:
				tmp_.setStatus(Status.HOLD);
				break;
			case 7:
				tmp_.setStatus(Status.POSTPONED);
				break;
			case 8:
				tmp_.setStatus(Status.SOMEDAY);
				break;
			case 9:
				tmp_.setStatus(Status.CANCELED);
				break;
			case 10:
				tmp_.setStatus(Status.REFERENCE);
				break;
			default:
				break;
			}
		} else if (qName.equalsIgnoreCase("star")) {
			int star = Integer.parseInt(tempVal.toString());
			if (star == 0)
				tmp_.setStar(false);
			else 
				tmp_.setStar(true);
		} else if (qName.equalsIgnoreCase("priority")) {		
			switch (Integer.parseInt(tempVal.toString())) {
				case -1: tmp_.setPriority(Priority.NEGATIVE); break;
				case 0: tmp_.setPriority(Priority.LOW); break;
				case 1: tmp_.setPriority(Priority.MEDIUM); break;
				case 2: tmp_.setPriority(Priority.HIGH); break;
				case 3: tmp_.setPriority(Priority.TOP); break;
				default: break; 
			}
		} else if (qName.equalsIgnoreCase("length")) {
			tmp_.setLength(Integer.parseInt(tempVal.toString()));
		} else if (qName.equalsIgnoreCase("timer")) {
			// TODO
		} else if (qName.equalsIgnoreCase("note")) {
			tmp_.setNote(tempVal.toString());
		}
	}

}
