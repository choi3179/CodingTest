import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        hanoi(N,1,2,3);

        System.out.println(cnt);
        System.out.println(sb);
          
        br.close();
    }

    /*
    * n : 원반 수
    * start : 시작점
    * tmp : end까지 옮기기 전 중간 지점
    * end : 종착지
    */
    static void hanoi(int n, int start, int tmp, int end) {
        if(n==1) {  // 옮길 원반이 하나 남음 -> 종착지로 이동
            sb.append(start + " " + end + "\n");
            cnt++;
            return ;
        }

        hanoi(n-1, start, end, tmp);  // n-1개를 tmp로 옮김

        sb.append(start + " " + end + "\n");
        cnt++;

        hanoi(n-1, tmp, start, end);  // 중간에 옮겼던 n-1개를 종착지로 옮김
    }
}