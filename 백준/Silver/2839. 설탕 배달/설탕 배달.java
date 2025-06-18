import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = Integer.MAX_VALUE;
        
        for(int i=0;N-3*i>=0;i++) {
            int m = N - 3*i;
            int cnt = i;
            for(int j=0;m-5*j>=0;j++) {
                if(m-5*j == 0) {
                    cnt += j;
                    answer = Math.min(answer, cnt);
                }
            }
        }

        if(answer == Integer.MAX_VALUE)
            answer = -1;
        
        System.out.println(answer);
    }
}