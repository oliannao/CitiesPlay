import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.DataProvider;

public class CitiesMapTestDate {
	@DataProvider(name = "getCitiesData")

	public static List<String> getCitiesData() {
		List<String> cities = new ArrayList<String>();
		cities = Arrays.asList("New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia",
				"San Antonio", "San Diego", "Dallas");
		return cities;
	}
}
