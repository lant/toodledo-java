package org.loststone.toodledo.xml;

public class GetTodosParserTest {
	private String firstXml = 
		"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
		"<tasks num=\"45\" total=\"45\" start=\"0\" end=\"1000\">	" + 
		"	<task>" + 
		"	<id>117941187</id>" + 
		"	<children>0</children>" + 
		"	<title>afegir fitxer a la api de toodledo</title>" + 
		"	<tag></tag>" + 
		"	<folder>1211557</folder>" + 
		"	<context id=\"0\"></context>" + 
		"	<goal id=\"0\"></goal>" + 
		"	<added>2010-07-12</added>" + 
		"	<modified>2010-07-12 18:20:57</modified>" + 
		"	<startdate></startdate>" + 
		"	<duedate modifier=\"\"></duedate>" + 
		"	<duetime></duetime>" + 
		"	<starttime></starttime>" + 
		"	<reminder>0</reminder>" + 
		"	<completed>2010-07-12</completed>" + 
		"	<repeat>0</repeat>" + 
		"	<rep_advanced></rep_advanced>" + 
		"	<status>0</status>" + 
		"	<star>0</star>" + 
		"	<priority>0</priority>" + 
		"	<length>0</length>" + 
		"	<timer onfor=\"0\">0</timer>" + 
		"	<note></note>" + 
		"	</task>" +
		"	</tasks>" ;
	
	private String secondXml = 
		"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
		"<tasks num=\"45\" total=\"45\" start=\"0\" end=\"1000\">	" + 
		"	<task>" + 
		"	<id>117941187</id>" + 
		"	<children>0</children>" + 
		"	<title>afegir fitxer a la api de toodledo</title>" + 
		"	<tag></tag>" + 
		"	<folder>1211557</folder>" + 
		"	<context id=\"0\"></context>" + 
		"	<goal id=\"0\"></goal>" + 
		"	<added>2010-07-12</added>" + 
		"	<modified>2010-07-12 18:20:57</modified>" + 
		"	<startdate></startdate>" + 
		"	<duedate modifier=\"\"></duedate>" + 
		"	<duetime></duetime>" + 
		"	<starttime></starttime>" + 
		"	<reminder>0</reminder>" + 
		"	<completed>2010-07-12</completed>" + 
		"	<repeat>0</repeat>" + 
		"	<rep_advanced></rep_advanced>" + 
		"	<status>0</status>" + 
		"	<star>0</star>" + 
		"	<priority>0</priority>" + 
		"	<length>0</length>" + 
		"	<timer onfor=\"0\">0</timer>" + 
		"	<note></note>" + 
		"	</task>" +
		"	</tasks>" ;
	
}


