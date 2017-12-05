import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		CitiesMap citiesMap = new CitiesMap();

		Set<String> cities = citiesMap.initCities(new File("D:\\1.txt"));
		
		Map<Character, Set<String>> hm = citiesMap.createMap(cities);

		for (Map.Entry<Character, Set<String>> entry : hm.entrySet()) {
			Character key = entry.getKey();
			Set value = entry.getValue();
			System.out.println(key);
			System.out.println(value);

		}

		Game game = new Game();
                game.setCitiesMap(citiesMap);

		game.doGame();
	}
}
