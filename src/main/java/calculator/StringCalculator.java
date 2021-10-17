package calculator;

class StringCalculator {
	private StringBuilder defaultDelimiter;
	private static int addMethodInvokedCount;

	public StringCalculator() {
		defaultDelimiter = new StringBuilder("\n|,");
	}

	public int add(String numbers) throws Exception {
		addMethodInvokedCount++;
		if (numbers.isEmpty())
			return 0;
		if (numbers.length() == 1 && Character.isDigit(numbers.charAt(0)))
			return stringToInt(numbers);
		else {
			if (numbers.startsWith("//[")) {
				int numOfDelimiter = 0;
				int len = 0;
				for (int j = 2; j < numbers.length(); j++) {

					if (numbers.charAt(j) == '\n')
						break;

					if (numbers.charAt(j) == '[') {
						numOfDelimiter++;
						StringBuilder sb = new StringBuilder();
						len = 0;
						for (int i = j + 1; i < numbers.length(); i++) {
							if (numbers.charAt(i) == ']') {
								break;
							} else {
								len++;
								sb.append("\\" + numbers.charAt(i));
							}
						}
						defaultDelimiter.append("|" + sb);
					}
				}
				numbers = numbers.substring(len * numOfDelimiter + 3 + numOfDelimiter * 2, numbers.length());
			} else if (numbers.startsWith("//"))

			{
				defaultDelimiter.append("|\\" + numbers.charAt(2));
				numbers = numbers.substring(1 + 3, numbers.length());
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
			throw new Exception("negatives not allowed =>  " + negativeNums);
		else if (count > 1)
			throw new Exception("negatives not allowed =>  " + negativeNums);
		return negativeNums;
	}

	private int stringToInt(String num) {
		return Integer.parseInt(num);
	}

	public int GetCalledCount() {
		return addMethodInvokedCount;
	}
}
