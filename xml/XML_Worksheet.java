package xml;

import java.util.LinkedList;
import java.util.List;

public class XML_Worksheet {
	private final String name;
	private List<XML_Objet> l;

	public XML_Worksheet(String n) {
		name = n;
		l = new LinkedList<XML_Objet>();
	}

	public void addObjet(XML_Objet o) {
		l.add(o);
	}

	public String toXML() {
		String r = "\n  <Worksheet ss:Name=\"" + name + "\">" + "\n    <Table>";
		for (XML_Objet o : l) {
			r += o == null ? "" : o.toXML();
			r += "\n      <Row>" + "\n      </Row>";
		}
		r += "\n    </Table>\n  </Worksheet>";
		return r;
	}

	@Override
	public String toString() {
		String r = "\tXML Worksheet " + name + " with\n";
		for (XML_Objet o : l)
			r += o + "\n";
		return r;
	}
}
