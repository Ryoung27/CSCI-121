import java.util.Scanner;
public class Exercise2_1{
    public static void main(String[] args){
        System.out.println("TEST");

        //Create a scanner object.
        Scanner input = new Scanner(System.in);

        //Prompt the user to enter a degree in Celcius.
        System.out.print("Please enter a temp in celcius, number only: ");
        double celcius = input.nextDouble();

        double fahrenheit = (9.0/5) * celcius + 32;

        System.out.print(fahrenheit);
    }
}