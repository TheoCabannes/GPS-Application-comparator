package util;

public 
class Step {
	public final String latStart, lngStart;
	// Distance in meters and duration in seconds
	@SuppressWarnings("unused")
	private String latEnd, lngEnd, duration, distance, name;

	public Step() {
		distance = "Distance (m)";
		duration = "Duration (s)";
		latEnd = "End Latitude";
		lngEnd = "End Longitude";
		latStart = "Start Latitude";
		lngStart = "Start Longitude";
	}

	public Step(String n, String lts, String lns, String dur, String dis) {
		name = n;
		latStart = lts;
		lngStart = lns;
		duration = dur;
		distance = dis;
	}

	public String toXML(String string) {
		return "\n        <Cell><Data ss:Type=\"String\">" + string + "</Data></Cell>"
				+ "\n        <Cell><Data ss:Type=\"String\">" + lngStart + "</Data></Cell>"
				+ "\n        <Cell><Data ss:Type=\"String\">" + latStart + "</Data></Cell>"
				+ "\n        <Cell><Data ss:Type=\"String\">" + lngEnd + "</Data></Cell>"
				+ "\n        <Cell><Data ss:Type=\"String\">" + latEnd + "</Data></Cell>"
				+ "\n        <Cell><Data ss:Type=\"String\">" + distance + "</Data></Cell>"
				+ "\n        <Cell><Data ss:Type=\"String\">" + duration + "</Data></Cell>";
	}

	public void setLatLngEnd(String lat, String lng) {
		latEnd = lat;
		lngEnd = lng;
	}

	@Override
	public String toString() {
		return "From (" + lngStart + ", " + latStart + ") to (" + lngEnd + ", " + latEnd + ") in " + duration
				+ " s for " + distance + " m";
	}
}

