import java.util.*;
import java.lang.*;
import java.io.*;
    
class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=1;i<=N;i++) {
            deque.addLast(i);
        }

        int[] papers = new int[N+1];
        papers[0] = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            papers[i] = Integer.parseInt(st.nextToken());
        }

        int paper = 1;     // 종이에 적힌 번호  
        int balloon = 0;  // 풍선 번호
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++) {
            if(paper > 0) {
                balloon = deque.removeFirst();
                sb.append(balloon).append(" ");
            } else {
                balloon = deque.removeLast();
                sb.append(balloon).append(" ");
            }
            
            paper = papers[balloon];

            if(deque.isEmpty())
                break;
            
            if(paper > 0) {
                 for(int j=1;j<paper;j++) {
                    int tmp = deque.removeFirst();
                    deque.addLast(tmp);
                }
            } else {
                for(int j=1;j<-paper;j++) {
                    int tmp = deque.removeLast();
                    deque.addFirst(tmp);
                } 
            }
        }
        
        System.out.println(sb);
        
    }
}