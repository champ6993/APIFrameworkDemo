package Resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Location;
import pojo.addPlace;

public class TestDataBuild {

	public addPlace addPlacePayload(String name, String language, String address) {
		addPlace place = new addPlace();
		place.setAccuracy(50);
		place.setAddress(address);
		place.setLanguage(language);
		place.setPhone_number("(+91) 983 893 3937");
		place.setWebsite("http://google.com");
		place.setName(name);

		List<String> l1 = new ArrayList<String>();
		l1.add("shoe park");
		l1.add("shop");

		place.setTypes(l1);

		Location loc = new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);

		place.setLocation(loc);
		
		return place;
	}
	public String deletePlacePayload(String placeId)
	{
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}

}
