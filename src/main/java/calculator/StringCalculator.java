package calculator;

class StringCalculator {
	private final String defaultDelimiter = ",|\n";

	public int add(String numbers) {

		String[] nums = numbers.split(defaultDelimiter);
		int sum = 0;
		if (numbers.isEmpty())
			return 0;
		if (numbers.length() == 1 && Character.isDigit(numbers.charAt(0)))
			return stringToInt(numbers);
		else {

			for (String n : nums) {
				sum += stringToInt(n);
			}

		}
		return sum;
	}

	private int stringToInt(String num) {
		return Integer.parseInt(num);
	}
}
