package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {

    @Test
    void empty_string_should_return_0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void string_with_single_number_should_return_number_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
    }
    
    @Test
	void string_with_two_numbers_should_return_numbers_sum_as_int() {
		StringCalculator stringCalculator=new StringCalculator();
		assertEquals(6,stringCalculator.add("2\n4"));
	}
	
	@Test
	void string_with_three_numbers_should_return_numbers_sum_as_int() {
		StringCalculator stringCalculator=new StringCalculator();
		assertEquals(7,stringCalculator.add("1,2\n4"));
	}
}
