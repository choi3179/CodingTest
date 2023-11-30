
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        int l = input.length();

        int answer = 1;

        for(int i=0;i<l/2;i++){
           if(input.charAt(i) == input.charAt(l-i-1))
               answer = 1;
           else {
               answer = 0;
               break;
           }
        }
        System.out.println(answer);
    }
}
