import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Game {
	private boolean isCity = true;
	private CitiesMap citiesMap;

	public void dogame(Map<Character, Set<String>> hm) {
		while (isCity) {
			System.out.println("Enter your  city!");
			Scanner sc = new Scanner(System.in);
			String city = sc.next();
			Character lastChar = citiesMap.getLastChar(city);
			String findCity;

			for (Map.Entry<Character, Set<String>> entry : hm.entrySet()) {
				Character key = entry.getKey();
				Set value = entry.getValue();
				if (lastChar == key) {
					Iterator<String> it = value.iterator();
					if (it.hasNext()) {
						findCity = it.next();
						System.out.println("My city is " + findCity);
						it.remove();
						continue;

					} else {
						System.out.println("You won!");
						isCity = false;
						sc.close();
					}
				}

			}

		}
	}
}
