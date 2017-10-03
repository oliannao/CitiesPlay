import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CitiesMap {

	private static Map<Character, Set<String>> mapCities = new HashMap<Character, Set<String>>();

	private static Set<String> cities = new HashSet<String>();

	public CitiesMap() {

	}

	public Map<Character, Set<String>> getCities() {
		return this.mapCities;
	}

	public Set<String> getMapCities() {
		return this.cities;
	}

	public Set<String> initCities(File file) {

		try (BufferedReader in = new BufferedReader(new FileReader(file))) {
			for (String city; (city = in.readLine()) != null;) {
				cities.add(city);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return cities;
	}

	public static Character getFirstChar(String city) {
		return city.charAt(0);
	}

	public static Character getLastChar(String city) {
		int pos = city.length() - 1;
		char lastChar = city.toUpperCase().charAt(pos);

		return lastChar;
	}

	public Map<Character, Set<String>> createMap(Set<String> cities) {
		Map<Character, Set<String>> map = new HashMap<Character, Set<String>>();
		for (String city : cities) {
			Set<String> cs = map.get(getFirstChar(city));
			if (cs == null)
				map.put(getFirstChar(city), cs = new HashSet<String>());
			cs.add(city);
		}
		return map;
	}


}
