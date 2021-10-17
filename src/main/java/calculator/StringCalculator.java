package calculator;

class StringCalculator {
	private StringBuilder defaultDelimiter;

	public StringCalculator() {
		defaultDelimiter = new StringBuilder("\n|,");
	}

	public int add(String numbers) throws Exception {

		if (numbers.isEmpty())
			return 0;
		if (numbers.length() == 1 && Character.isDigit(numbers.charAt(0)))
			return stringToInt(numbers);
		else {
			if (numbers.startsWith("//")) {
				StringBuilder sb = new StringBuilder();
				for (int i = 2; i < numbers.length() - 1; i++) {
					if (numbers.charAt(i) == '\n') {
						break;
					} else {
						sb.append(numbers.charAt(i));
					}
				}

				numbers = numbers.substring(sb.length() + 3, numbers.length());
				defaultDelimiter.append("|" + sb);
			} else if (numbers.startsWith("//[")) {

			}
			String[] nums = numbers.split(defaultDelimiter.toString());
			checkNegativeNumbers(nums);
			return sumOfNumbers(nums);

		}
	}

	private int sumOfNumbers(String[] nums) {
		int sum = 0;
		for (String n : nums) {
			sum += (stringToInt(n) < 1000) ? stringToInt(n) : 0;
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
