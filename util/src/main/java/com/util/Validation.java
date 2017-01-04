package com.util;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.*;

import java.io.Console;
import java.util.*;
import java.text.*;
import java.text.DateFormat;

import com.util.PersonGender;

public class Validation {

	private static Console console = System.console();

	//validate input to integer only
	public static int enterInteger(String label) {
		String value = "";
		boolean success = false;

		while(!success) {
			System.out.print(label);
			value = console.readLine();
			success = NumberUtils.isParsable(value);

			if(!success) {
				System.out.println("Please enter an integer.");
			}
		}

		return (int) (Double.parseDouble(value));

	}//end enterInteger

	//validate input to approx. num of characters
	public static String enterNumOfChars(String label, int lengthOfChars) {
		String value = "";
		boolean success = false;

		while(!success) {
			System.out.print(label);
			value = console.readLine();

			try {
				Validate.isTrue(value.length() == lengthOfChars);
				success = true;
			}
			catch(IllegalArgumentException ex) {
				System.out.println("Please enter " + lengthOfChars + " characters.");
			}
		}
		return value;
	}//end enterNumOfChars

	public static String acceptString(String label) {
		String value = "";
		boolean success = false;

		while(!success) {
			System.out.print(label);
			value = console.readLine();

			try{
				Validate.notEmpty(value);
				success = true;
			}
			catch(IllegalArgumentException ex) {
				System.out.println("Input cannot be empty.");
			}
			catch(NullPointerException ex) {
				System.out.println("Input cannot be null.");
			}
		}

		return value;
	}//end acceptString

	public static Date validateDate(String label) {
		Date value = new Date();
		DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
		boolean success = false;

		while(!success) {
			System.out.print(label);

			try{
				value = df.parse(console.readLine());
				success = true;
			}
			catch(IllegalArgumentException ex) {
				System.out.println("Input cannot be empty.");
			}
			catch(NullPointerException ex) {
				System.out.println("Input cannot be null.");
			}
			catch(ParseException ex) {
				System.out.println("Input is not a valid date.");
			}
		}

		return value;
	}//end validateDate

	public static float validateFloat(String label) {
		float value = 0;
		boolean success = false;

		while(!success) {
			System.out.print(label);

			try{
				value = new Float(console.readLine());
				
				success = true;
			}
			catch(IllegalArgumentException ex) {
				System.out.println("Input is not valid.");
			}
			catch(NullPointerException ex) {
				System.out.println("Input cannot be null.");
			}
		}

		return value;
	}//end validateFloat

	public static boolean acceptBoolean(String label) {
		boolean value = false;
		String input = "";
		boolean success = false;

		while(!success) {
			System.out.print(label);

			input = console.readLine();

			if(input.equalsIgnoreCase("true")) {
				value = true;

				success = true;
			}
			else if(input.equalsIgnoreCase("false")) {
				value = false;

				success = true;
			}
			else {
				System.out.println("Input is not valid.");
				success = false;
			}
		}

		return value;
	}//end acceptBoolean

	public static PersonGender validateGender(String label) {
		String input = "";
		PersonGender gender = null;
		boolean success = false;

		while(!success) {
			try {
				System.out.print(label);
				input = console.readLine();
				gender = PersonGender.valueOf(input);

				switch(gender) {
					case MALE :
					case FEMALE :
						success = true;
						break;
					default :
						System.out.println("\"" + input + "\" is not a valid gender.");
				}
/*
				if( input.equalsIgnoreCase(PersonGender.MALE.toString()) ||
					input.equalsIgnoreCase(PersonGender.FEMALE.toString()) ) {
					success = true;
				}
				else {
					System.out.println("\"" + input + "\" is not a valid gender.");
				}

				if( EnumUtils.isValidEnum(PersonGender.class, input) ) {
					gender = PersonGender.valueOf(input);
					success = true;
				}
				else {
					System.out.println("\"" + input + "\" is not a valid gender.");	
				}
*/
			}
			catch(IllegalArgumentException ex) {
				System.out.println("Input is not valid.");
			}
		}

		return gender;
	}//end validateGender

}