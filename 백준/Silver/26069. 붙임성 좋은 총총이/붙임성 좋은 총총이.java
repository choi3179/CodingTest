import java.util.*;
import java.lang.*;
import java.io.*;
    
class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> hashSet = new HashSet<String>();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());

        hashSet.add("ChongChong");
        for(int i=0;i<N;i++) {
            st= new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            if(hashSet.contains(a) || hashSet.contains(b)){
                hashSet.add(a);
                hashSet.add(b);
            }
        }

        System.out.println(hashSet.size());
    }
}