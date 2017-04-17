package applications;

import java.util.LinkedList;
import java.util.List;

import org.joda.time.DateTime;

import util.Way;

public abstract class ApplicationOutput extends Thread {
	public String api;
	public List<Way> ways = new LinkedList<Way>();

	public abstract void computeResult(String origin, String destination, DateTime dt);

	public String toXML() {
		String r = "";
		for (Way w : ways) {
			r += "\n      <Row>" + "\n        <Cell><Data ss:Type=\"String\">" + w.origin + "</Data></Cell>"
					+ "\n        <Cell><Data ss:Type=\"String\">" + w.destination + "</Data></Cell>"
					+ "\n        <Cell><Data ss:Type=\"String\">" + w.date + "</Data></Cell>"
					+ "\n        <Cell><Data ss:Type=\"String\">" + w.time + "</Data></Cell>"
					+ "\n        <Cell><Data ss:Type=\"String\">" + w.api + "</Data></Cell>"
					+ "\n        <Cell><Data ss:Type=\"String\">" + w.name + "</Data></Cell>"
					+ "\n        <Cell><Data ss:Type=\"String\">" + w.duration() + "</Data></Cell>"
					+ "\n        <Cell><Data ss:Type=\"String\">" + w.distance() + "</Data></Cell>" + "\n      </Row>";
		}
		return r;
	}

	@Override
	public String toString() {
		String r = "********************** " + api + " **********************\n";
		String w = "";
		for (Way way : ways) {
			r += way.name + " : " + way.duration() + " mins for " + way.distance() + " km\n";
			w += "\n" + way;
		}
		return r + w;
	}
}