package calculator;

class StringCalculator {
	private StringBuilder defaultDelimiter;
	// checking how many times add method is called(not per object but globally
	// count of how many times add method is called)
	private static int addMethodInvokedCount;

	// Constructor for initialize object data members of StringCalculator class
	public StringCalculator() {
		defaultDelimiter = new StringBuilder("\n|,");
	}

	public int add(String numbers) throws Exception {
		addMethodInvokedCount++;
		// if numbers is empty returning 0
		if (numbers.isEmpty())
			return 0;
		// if numers lenght is 1 then return given number from string
		if (numbers.length() == 1 && Character.isDigit(numbers.charAt(0)))
			return stringToInt(numbers);
		else {
			// if string is starting with '//['
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
			} else if (numbers.startsWith("//")) // if string starts with only '//'

			{
				defaultDelimiter.append("|\\" + numbers.charAt(2));
				numbers = numbers.substring(1 + 3, numbers.length());
			}
			String[] nums = numbers.split(defaultDelimiter.toString());

			checkNegativeNumbers(nums);
			return sumOfNumbers(nums);

		}

	}

	// for adding numbers which are obtained by spliting String on the basis of
	// delimiter
	private int sumOfNumbers(String[] nums) {
		int sum = 0;
		for (String n : nums) {
			sum += (stringToInt(n) < 1000) ? stringToInt(n) : 0;
		}
		return sum;
	}

//geting negative numbers from string and throwing exception
	private void checkNegativeNumbers(String[] nums) throws Exception {
		String negativeNums = "";
		for (String n : nums) {
			if (stringToInt(n) < 0) {
				negativeNums += n + ",";
			}
		}
		// if negative numbers are there in string then exception will be thrown with
		// message as "negatives not allowed"
		if (negativeNums.length() > 0)
			throw new Exception("negatives not allowed =>  " + negativeNums);
	}

//converting string to integer
	private int stringToInt(String num) {
		return Integer.parseInt(num);
	}

//geting how many number of times add method is called
	public int GetCalledCount() {
		return addMethodInvokedCount;
	}
}
