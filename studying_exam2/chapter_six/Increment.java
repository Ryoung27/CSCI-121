public class Increment{
    public static void main(String[] args){
        int x = 1;
        System.out.println("The current value of x " + x);
        increment(x);
        System.out.println("Back out of the method " + x);
        increment(x);
    }

    public static void increment(int x){
        x++;
        System.out.println("x inside the method is " + x);
    }
}