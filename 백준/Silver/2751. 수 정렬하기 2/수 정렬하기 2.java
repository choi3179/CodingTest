
import java.util.*;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();     // 출력 성능 향상을 위한 StringBuilder 사용

        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<Integer>(n);

        for(int i=0;i<n;i++){
            int input = sc.nextInt();
           arr.add(input);
        }

        Collections.sort(arr);

        Iterator it = arr.iterator();

        while(it.hasNext())
            sb.append(it.next()).append("\n");

        System.out.println(sb.toString());
    }
}
