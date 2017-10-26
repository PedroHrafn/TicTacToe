package is.ru.stringcalculator;

public class Calculator {

	public static int Add(String text) {
		if(text == "") {
			return 0;
		}
		else {
			if(text.contains("-")) {
				String negNumbers = getNegNumbers(text);
				throw new IllegalArgumentException("Negatives not allowed: " + negNumbers); 
			}
			if(text.contains(",") || text.contains("\n")) {
				String[] numbers = numbers(text);
				int sum = 0;
				for(int i = 0; i < numbers.length; i++) {
					int number = toInt(numbers[i]);
					if(number <= 1000)
						sum += number;
				}
				return sum;
			}
			return toInt(text);
		}
	}

	private static int toInt(String number) {
		return Integer.parseInt(number);
	}

	private static String getNegNumbers(String text) {
		String[] numbers = numbers(text);
		String negNumbers = "";
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i].startsWith("-")) {
				if(negNumbers != "") {
					negNumbers += ",";
				}
				negNumbers += numbers[i];
			}
		}
		return negNumbers;
	}
	private static String[] numbers(String text) {
		String delimiter;
		if(text.startsWith("//")) {
			delimiter = text.substring(2, text.indexOf("\n"));
			text = text.substring(text.indexOf("\n") + 1, text.length());
		}
		else {
			delimiter = ",|\n";
		}
		return text.split(delimiter);
	}
}	