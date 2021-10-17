package calculator;

class StringCalculator {
	private final String defaultDelimiter = ",|\n";

	public int add(String numbers) throws Exception {

		String[] nums = numbers.split(defaultDelimiter);

		if (numbers.isEmpty())
			return 0;
		if (numbers.length() == 1 && Character.isDigit(numbers.charAt(0)))
			return stringToInt(numbers);
		else {
			checkNegativeNumbers(nums);
			return sumOfNumbers(nums);

		}
	}

	private int sumOfNumbers(String[] nums) {
		int sum = 0;
		for (String n : nums) {
			sum += stringToInt(n);
		}
		return sum;
	}

	private String checkNegativeNumbers(String[] nums) throws Exception {
		String negativeNums = "";
		int count = 0;
		for (String n : nums) {
			if (stringToInt(n) < 0) {
				count++;
				negativeNums += n + ",";
			}
		}
		if (count == 1)
			throw new Exception("negatives not allowed");
		else if (count > 1)
			throw new Exception("negatives not allowed " + negativeNums);
		return negativeNums;
	}

	private int stringToInt(String num) {
		return Integer.parseInt(num);
	}
}
