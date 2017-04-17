package util;
import xml.XML_Objet;

public class Way implements XML_Objet {
	// TODO : implementer une visualisation du trajet
	public final String name, api, origin, destination, date, time, distance, duration;
	private final Step[] steps;

	public Way(String o, String des, String d, String t, String a, String n, String dis, String dur, Step[] s) {
  		origin = o;
		destination = des;
		date = d;
		time = t;
		api = a;
		name = n;
		distance = dis;
		duration = dur;
		steps = s;
	}
	
	public String duration() {
		return duration;
	}

	public String distance() {
		return distance;
	}

	@Override
	public String toString() {
		String r = "------ Way " + name + " ------";
		for (int i = 0; i < steps.length; i++)
			r += "\n\tStep " + i + " : " + steps[i];
		return r;
	}

	public String toXML() {
		String r = "\n      <Row>" + "\n        <Cell><Data ss:Type=\"String\">" + api + "</Data></Cell>"
				+ "\n        <Cell><Data ss:Type=\"String\">" + name + "</Data></Cell>" + "\n      </Row>"
				+ "\n      <Row>" + new Step().toXML("Number") + "\n      </Row>";
		for (int i = 0; i < steps.length; i++)
			r += "\n      <Row>" + steps[i].toXML("Step" + i) + "\n      </Row>";
		return r;
	}
}