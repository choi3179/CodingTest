import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A1 = Integer.parseInt(st.nextToken());
        long B1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long A2 = Integer.parseInt(st.nextToken());
        long B2 = Integer.parseInt(st.nextToken());

        long lcm = lcm(B1,B2);  // 분모의 최소공배수
        long gcd = gcd(B1,B2);  // 분모의 최대공약수

        long top = A1*(lcm/B1) + A2*(lcm/B2);
        long bot = lcm;

        long answer1 = top / gcd(top,bot);
        long answer2 = bot / gcd(top,bot);

        System.out.println(answer1 + " " + answer2);
    }

    public static long gcd(long A, long B) {
        while(B != 0) {
            long tmp = A%B;
            A=B;
            B=tmp;
        }
        return A;
    }

    public static long lcm(long A, long B) {
        long lcm = 0;

        if(A>B) {
            lcm = (A*B) / gcd(A,B);
        } else if(A<B) {
            lcm = (A*B) / gcd(B,A);
        } else {
            lcm = A;
        }

        return lcm;
    }
}