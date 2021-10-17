package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {

//    @Test
//    void empty_string_should_return_0() throws Exception {
//        StringCalculator stringCalculator = new StringCalculator();
//        assertEquals(0, stringCalculator.add(""));
//    }
//
//    @Test
//    void string_with_single_number_should_return_number_as_int() throws Exception {
//        StringCalculator stringCalculator = new StringCalculator();
//        assertEquals(1, stringCalculator.add("1"));
//    }
//    
//    @Test
//	void string_with_two_numbers_should_return_numbers_sum_as_int() throws Exception {
//		StringCalculator stringCalculator=new StringCalculator();
//		assertEquals(6,stringCalculator.add("2\n4"));
//	}
//	
//	@Test
//	void string_with_three_numbers_should_return_numbers_sum_as_int() throws Exception {
//		StringCalculator stringCalculator=new StringCalculator();
//		assertEquals(7,stringCalculator.add("1,2\n4"));
//		
//	}
//	
//	@Test
//	void string_with_negative_number_should_throw_exception(){
//		StringCalculator stringCalculator=new StringCalculator();
//		try {
//			assertEquals(3,stringCalculator.add("-3,-3"));
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
//	
//	@Test
//	void string_with_single_different_delimiter() throws Exception {
//		StringCalculator stringCalculator=new StringCalculator();
//		assertEquals(11,stringCalculator.add("//;\n2;3;6,1000"));
//	}
	
	@Test
	void string_with_single_different_group_of_delimiter() throws Exception {
		StringCalculator stringCalculator=new StringCalculator();
		assertEquals(26,stringCalculator.add("//::\n2::5,6::13"));
	}
}
