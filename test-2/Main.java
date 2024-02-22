import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5};
        int[] firstAndLast = new int[] {array[0], array[array.length - 1]};
        
        System.out.println(Arrays.toString(firstAndLast));
    }
}