package dataProperty;

import java.util.ArrayList;
import java.util.List;

import pojo.Serialization;
import pojo.Location;

public class DataBuilder {
	public Serialization data(String name,String language, String address)
	{
		Serialization d = new Serialization();
		d.setAccuracy(60);
		d.setAddress(address);
		d.setLanguage(language);
		Location l = new Location();
		l.setLat(38.383494);
		l.setLng(33.427362);
		d.setLocation(l);
		d.setName(name);
		d.setPhone_number("917885559665");
		List<String> g = new ArrayList<String>();
		g.add("shoe park");
		g.add("shop");
		d.setTypes(g);
		d.setWebsite("www.google.com");
		return d;
	}
}
