package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class StringCalculatorShould {

	@Test
	void empty_string_should_return_0() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(0, stringCalculator.add(""));
	}

	@Test
	void string_with_single_number_should_return_number_as_int() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(1, stringCalculator.add("1"));
	}

	@Test
	void string_with_two_numbers_should_return_numbers_sum_as_int() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(3, stringCalculator.add("1,2"));
	}

	@Test
	void string_with_three_numbers_should_return_numbers_sum_as_int() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(7, stringCalculator.add("1,2\n4"));
	}

	@Test
	void string_with_unknown_numbers_should_return_numbers_sum_as_int() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(55, stringCalculator.add("1,2\n3,4,5\n6,7,8,9,10"));
	}

	@Test
	void string_with_number_greater_than_1000() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(11, stringCalculator.add("2,3,1005,6,1000"));
	}

	@Test
	void string_with_single_different_delimiter() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(11, stringCalculator.add("//;\n2;3;6,1000"));
	}

	@Test()
	void string_with_negative_number_should_throw_exception() {
		StringCalculator stringCalculator = new StringCalculator();
		Exception exception = assertThrows(Exception.class, () -> stringCalculator.add("1,2,-3"));
		System.out.println(exception.getMessage());
	}

	@Test
	void string_with_multiple_negative_number_should_throw_exception() {
		StringCalculator stringCalculator = new StringCalculator();
		Exception exception = assertThrows(Exception.class, () -> stringCalculator.add("1,2,-4,-5,-6,8,7,-9"));
		System.out.println(exception.getMessage());
	}

	@Test
	void string_with_single_delimiter_of_one_length() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(26, stringCalculator.add("//[&]\n2&5&6&13"));
	}

	@Test
	void string_with_single_delimiter_of_any_lenght() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(26, stringCalculator.add("//[**]\n2**5**6**13"));
	}

	@Test
	void string_with_multiple_delimiter_of_any_lenght() throws Exception {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(26, stringCalculator.add("//[**][%%]\n2**5,6%%13"));
	}

	@Test
	@AfterAll
	static void number_of_times_add_method_invoked() {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(12, stringCalculator.GetCalledCount());
	}
}
