package xml;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class XML_File {
	private List<XML_Worksheet> ws;

	public XML_File() {
		ws = new LinkedList<XML_Worksheet>();
	}

	public void addWorsheet(XML_Worksheet w) {
		ws.add(w);
	}

	public void toXML(String file_name) {
		String result = "<?xml version=\"1.0\"?>"
				+ "\n<Workbook xmlns=\"urn:schemas-microsoft-com:office:spreadsheet\" xmlns:o=\"urn:schemas-microsoft-com:office:office\"  xmlns:x=\"urn:schemas-microsoft-com:office:excel\" xmlns:ss=\"urn:schemas-microsoft-com:office:spreadsheet\" xmlns:html=\"http://www.w3.org/TR/REC-html40\">";
		for (XML_Worksheet w : ws)
			result += w.toXML();
		result += "\n</Workbook>";
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file_name + ".xml")));
			bw.write(result);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		String r = "XML File with\n";
		for (XML_Worksheet w : ws)
			r += w + "\n";
		return r;
	}
}

