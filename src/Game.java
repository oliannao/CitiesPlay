import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Game {
	private boolean isCity = true;
	private CitiesMap citiesMap;
	private boolean correctCity = false;
	public void setCitiesMap(CitiesMap citiesMap){
		this.citiesMap = citiesMap;
	}

	public void doGame() {

			printEnterOne();
			String firstAnswer = enterAnswer();
			switch (firstAnswer){
				case "Yes":
					printEnterTwoYes();
					String city = enterCity();
					correctCity = checkCity(city);
					if (correctCity){
						doGameWithMap(city);
					}
					else printIncorrectCity();
					break;
				case "No":
					printEnterTwoNo();
					break;
				default:
					printEnterTwoDif();
					doGame();
			}
		}


	public void printEnterOne() {
		System.out.println("Hi, let's play!Enter Yes or No");
	}

	public String enterAnswer() {
		Scanner sc = new Scanner(System.in);
		String answer = sc.next();
		return answer;
	}
	public void printEnterTwoYes() {
		System.out.println("Enter USA city name");
	}
	public void printEnterTwoNo() {
		System.out.println("Sorry, Bye!");
	}
	public void printEnterTwoDif() {
		System.out.println("Read more carefully!");
	}
	public String enterCity() {
		Scanner sc = new Scanner(System.in);
		String city = sc.next();
		return city;
	}
	public boolean checkCity(String city){

		Set<String> cities = citiesMap.getCities();
		for (String c : cities){
			if (c.equals(city)){
				correctCity = true;
			}
		}
		return correctCity;

	}
	public void printIncorrectCity() {
		System.out.println("This is not a city");
	}
	private void doGameWithMap(String city) {
		while (isCity) {
			Character lastChar = citiesMap.getLastChar(city);
			String findCity;
			for (Map.Entry<Character, Set<String>> entry : citiesMap.getMapCities().entrySet()) {
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
					}
				}
			}
		}
	}
}
