﻿package com.qa.javaAssessment;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i< input.length(); i++) {
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
		}
		return word;
	}
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""

	public String getBert(String input) {
		input = input.toLowerCase();
		int b1 = input.toLowerCase().indexOf("bert");
		int b2 = input.toLowerCase().indexOf("bert", b1 + 1);
		String word = "";
		if(b2 == -1)
			return "";
		String middle = input.substring(b1 + 4, b2);
		for(int i = middle.length()-1; i>=0; i--) {
			word += middle.substring(i, i+1);
		}
		return word; 
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public boolean evenlySpaced(int a, int b, int c) {
		if(a==b && b==c) return true;
		if(a==b || a==c || b==c) return false;
		return ((Math.abs(a-b)== Math.abs(b-c)) || (Math.abs(a-c)==Math.abs(a-b)) ||( Math.abs(c-a)==Math.abs(b-c)));
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int a) {
		int len = input.length()/2;
		return input.substring(0,len-a/2) + input.substring(len+a/2 + 1);
	}


	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public int superBlock(String input) {
		int len = input.length();
		int count = 0;
		int count2 = 1;
		
		if(len == 0)
			return 0;
		for (int i = 0; i < len; i++) {
			if (i < len-1 && input.charAt(i) == input.charAt(i+1))
				count2++;
			else count2 = 1;
			if (count2 > count)
				count = count2;
		}
		return count;
	}	
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") ==> 1
	//amISearch("I am in Amsterdam am I?") ==> 2
	//amISearch("I have been in Amsterdam") ==> 0

	public int amISearch(String arg1) {
		int count = 0;
		if (arg1.substring(0, 3).toLowerCase().equals("am ")) {
			count += 1;
		}
		if (arg1.substring(arg1.length()-3, arg1.length()).toLowerCase().equals(" am")) {
			count += 1;
		}
		for (int i = 0; i<arg1.length()-4; i++) {
			if (arg1.substring(i, i+4).toLowerCase().equals(" am ")) {
				count += 1;
			}
		}
		return count;
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) ==> "fizz"
	//fizzBuzz(10) ==> "buzz"
	//fizzBuzz(15) ==> "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		int num = arg1;
		
		for (int i=1; i<=num; i++) {
			if ( num % 15 == 0){
				return "fizzbuzz";
			}
			else if ( num % 5 == 0){
				return "buzz";
			}
			else if (num % 3 == 0) {
				return "fizz";
			}
			else return num + " ";
		}
		return null;
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") ==> 14
	//largest("15 72 80 164") ==> 11
	//largest("555 72 86 45 10") ==> 15
	
	public int largest(String arg1) { 
		String[] numStrings = arg1.split(" ");
		int[] nums = new int[numStrings.length];
		int sum = 0;
		int result = 0;
		for(int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(numStrings[i]);
			while(nums[i] > 0) {
				sum += nums[i] % 10;
				nums[i] = nums[i] / 10;
			}
			if(sum > result)
				result = sum;
			sum = 0;
		}
		return result; 
	}
}
