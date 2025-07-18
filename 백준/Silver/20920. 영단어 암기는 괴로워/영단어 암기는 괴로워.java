import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String,Integer> vocab = new HashMap<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++) {
           String input = br.readLine();
           if(input.length() < M) 
               continue;
           else {
               if(vocab.containsKey(input)) {
                   vocab.put(input, vocab.get(input)+1);
               }    
               else {
                   vocab.put(input,1);
               }
           }
           
        }

        ArrayList<String> vocabKeys = new ArrayList(vocab.keySet());
        vocabKeys.sort((o1,o2) -> {
            int cnt1 = vocab.get(o1);
            int cnt2 = vocab.get(o2);

            if(cnt1 == cnt2) {
                if(o1.length() == o2.length())
                    return o1.compareTo(o2);
                else
                    return o2.length()-o1.length();
            }
            return cnt2-cnt1;        
        });
        
        for(String n : vocabKeys) {
            bw.write(n + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}