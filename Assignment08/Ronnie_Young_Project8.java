/*
 * Write a program that takes user intake for a number between 0 and 511 and displays the corresponding results for a 3X3 matrix.
 *
 * @author: Ronnie Young
 * @version 10.13.20
 */

import java.util.Scanner; // import scanner package

public class Ronnie_Young_Project8 {
    public static void main(String[] args){
        // Initalize the array.
        int intArray[][] = new int[3][3];

        // Get the users input.
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a number between 0 - 511: ");

        int user_input = input.nextInt();

        int[] nums = decimal_to_binary(user_input);

        for (int i = 0; i<9; i++){

            if (nums[i] == 0)
                System.out.print("H ");

            else
                System.out.print("T ");

            if ((i+1) % 3 == 0)
                System.out.println();
        }



    }

    public static int[] decimal_to_binary(int decimal){
        int[] nums = new int[9];

        for (int i = nums.length-1;i>=0 && decimal >0;i--){
            if (decimal % 2 == 0)
                nums[i] = 0;
            else
                nums[i] = 1;
            decimal /= 2;
        }
        return nums;
    }
}