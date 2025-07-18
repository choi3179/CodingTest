import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int cnt1 = 0;
    static int cnt2 = 0;
    static int[] f;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        f = new int[N+1];

        fib(N);
        fibonacci(N);

        bw.write(cnt1 + " " + cnt2 + "\n");
        
        bw.flush();
        bw.close();

    }

    public static void fibonacci(int n) {
        f[1] = 1;
        f[2] = 2;
        for(int i=3;i<=n;i++) {
            cnt2++;
            f[i] = f[i-2] + f[i-1];
        }
        
    }

    public static int fib(int n) {
        if(n==1 || n==2) {
            cnt1++;
            return 1;
        }
        else
            return fib(n-1) + fib(n-2);
    }
}