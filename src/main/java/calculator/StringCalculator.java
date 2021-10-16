package calculator;

class StringCalculator {

    public int add(String numbers) {
        if(numbers.isEmpty())
	    	 return 0;
	     if(numbers.length()==1 && Character.isDigit(numbers.charAt(0)))
	    	 return Integer.parseInt(numbers);
        return 0;
    }

}
