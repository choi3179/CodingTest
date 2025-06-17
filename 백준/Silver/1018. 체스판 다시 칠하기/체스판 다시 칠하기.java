import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] chess;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        chess = new String[N][M];

        for(int i=0;i<N;i++) {
            chess[i] = br.readLine().split("");
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0;i<N-7;i++) {
            for(int j=0;j<M-7;j++) {
                for(int k=0;k<2;k++) {
                    String tmp = k==0 ? "B" : "W";
                    int cnt = 0;
                    for(int a=i;a<i+8;a++) {
                        for(int b=j;b<j+8;b++) {
                            if(chess[a][b].charAt(0) != tmp.charAt(0)) {
                                cnt++;
                            }
                            tmp = tmp=="W" ? "B" : "W";
                        }
                        tmp = tmp=="W" ? "B" : "W";
                    }
                    answer = Math.min(cnt, answer);
                }
            }
        }

        System.out.println(answer);
    }
}