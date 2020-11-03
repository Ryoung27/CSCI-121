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
        MyString mystring_one = new MyString(new char[]{'T','e','s','T'});

        // Print out the string object.
        System.out.println(mystring_one);

        // Print out the letter at index by calling charAt()
        System.out.println(mystring_one.charAt(0));
        System.out.println(mystring_one.charAt(1));
        System.out.println(mystring_one.charAt(2));
        System.out.println(mystring_one.charAt(3));

        // Print out the length of myString
        System.out.println(mystring_one.length());

        // Test substring
        System.out.println(mystring_one.substring(1, 2));

        // Test toLowerCase of characters in objects
        System.out.println(mystring_one.toLowerCase().charAt(0));
        System.out.println(mystring_one.toLowerCase().charAt(3));

        // Test equals on object
        System.out.println(mystring_one.equals("Test"));
        System.out.println(mystring_one.equals("TesT"));
        System.out.println(mystring_one.equals("tesT"));

        System.out.println(mystring_one.valueOf(12));
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
    public char charAt(int index){
        return string[index];
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
        boolean isEqual = true;

		if (s.length() != stringLength) {
            isEqual = false;
		}
		else{
            for (int i = 0; i < stringLength; i++) {
                if(s.string[i] != string[i]){
                    isEqual = false;
				}
			}
		}

		return isEqual;
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