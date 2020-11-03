/*
Purpose:	The	purpose	for	this	project	is	to	reinforce	the	knowledge	from	Chapter	10	of	the	textbook.
The	students	will	learn	how	to	write	a	user	defined	class.
Project	Objectives:
1. Apply	UML	design	on	user	defined	class
2. Write	overloaded	constructors	of	a	class
3. Write	customer	methods	of	the	class	(Other	than	get	and	set	methods)
Problem	description:
The	String	class	is	provided	by	java	library.	Write	your	own	String	class	based	on	the	following	UML
diagram.	No	built-in	String,	StringBuffer	related	classes	are	allowed.
 *
 * @author: Ronnie Young
 * @version 11.02.20
 */

 public class Ronnie_Young_Project10{
    public static void main(String[] args){
	/** Main method */
		// Create to char arrays
		char[] test = {'T', 'e', 'S', 't'};
		char[] test2 = {'T', 'e', 'S', 't', '2'};

        // Create two MyString objects
        // MyString(chars: char[])
		MyString string = new MyString(test);
		MyString string2 = new MyString(test2);

        // Test charAt()
        // charAt(i:int):char
		System.out.print("\nCharacter at index 3 of string: "
			+ string.charAt(3));

        // Test the length of string
        // length():int
		System.out.print("\nLength of MyString: " + string.length());


        // Test substring
        // substring(begin:int, end:int):MyString
		System.out.print("\nSubstring from index 2 to 4 of MyString: ");
		MyString substr = string.substring(2,4);
		for (int i = 0; i < substr.length(); i++) {
			System.out.print(substr.charAt(i));
		}

        // Test string as lowercase:"
        // toLowerCase():MyString
		System.out.print("\nMyString object 1 to lowercase: ");
		MyString lower = string.toLowerCase();
		for (int i = 0; i < lower.length(); i++) {
			System.out.print(lower.charAt(i));
		}

        // Test if string is equal to string1
        // equals(other:MyString):Boolean
		System.out.print("\nString is equal to string2? "
			+ string.equals(string2));

        // Test the integer 20 as a string object
        // valueOf(i:int):MyString
		System.out.print("\nDisplay the integer 20 as a MyString object: ");
		MyString value = string.valueOf(20);
		for (int i = 0; i < value.length(); i++) {
			System.out.print(value.charAt(i));
		}
    }
}
class MyString{
    private char[] string;
    private int stringLength;

    //  +MyString(chars: char[])
    public MyString(char[] chars){
        stringLength = chars.length;
		string = new char[stringLength];
		for(int i = 0; i < stringLength; i++){
            string[i] = chars[i];
		}
    }

    // +charAt(i: int) : char
    public char charAt(int i){
        return string[i];
    }

    // +length():int
    public int length(){
        return stringLength;
    }

    // +substring(begin: int, end: int) : MyString
    public MyString substring(int begin, int end){
        int subLength = end - begin;
		int count = 0;
		char[] sub = new char[subLength];

        for(int j = begin; j < end; j++){
            sub[count] = string[j];
            count++;
        }

		return new MyString(sub);
    }

    // +toLowerCase() : MyString
    public MyString toLowerCase(){
        char[] lowerCaseString = new char[stringLength];
		for(int i = 0; i < stringLength; i++){
            lowerCaseString[i] = Character.toLowerCase(string[i]); //using 'char' class toLowerCase()
		}

		return new MyString(lowerCaseString);
    }

    // +equals(other: MyString) : Boolean
    public boolean equals(MyString s){

		if (s.length() != stringLength) {
            return false;
		}
		else{
            for (int i = 0; i < stringLength; i++) {
                if(s.string[i] != string[i]){
                    return false;
				}
			}
		}

		return true;
    }

    // +valueOf(i:	int) : MyString
    public static MyString valueOf(int i){
        int digits = 1;
		int tempVal = i;

		while(tempVal > 0){
            tempVal /= 10;
			digits++;
		}

		int[] integers = new int[digits];
        int count = 0;

		while(i > 0){
            integers[count] = i % 10;
			i /= 10;
			count++;
		}

		char[] chars = new char[count];
		int anotherCount = 0;
		for(int k = count-1; k >= 0; k--){
            chars[anotherCount] = Character.forDigit(integers[k], 10);
			anotherCount++;
		}

		return new MyString(chars);
    }
 }