import java.util.*;
import java.lang.*;
import java.io.*;
    
class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String input = br.readLine();

            if(input.equals(".")) 
                break;
            
            System.out.println(check(input));
        }
        
    }

    public static String check(String input) {
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<input.length();i++) {
            char c = input.charAt(i);
            if(c=='(' || c=='[') {
                stack.push(c);
            }
            else if(c==')') {
                if(stack.isEmpty() || stack.peek() != '(')
                    return "no";
                else
                    stack.pop();
            }
            else if(c==']') {
                if(stack.isEmpty() || stack.peek() != '[')
                    return "no";
                else
                    stack.pop();
            }
        }
        if(stack.isEmpty())
            return "yes";
        else
            return "no";
    }
}