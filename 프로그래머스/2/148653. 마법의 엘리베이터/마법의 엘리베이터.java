import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        String num = Integer.toString(storey);
        int[] s= new int[num.length()];
        
        for(int i=0;i<s.length;i++){
            s[i] = num.charAt(i) - '0';
        }
        
        for(int i=s.length-1;i>=0;i--){
            if(s[i] > 5){
                answer += (10-s[i]);
                if(i == 0)
                    answer += 1;
                else
                    s[i-1]++;
            }
            else if(s[i] == 5 && i>0 && s[i-1] >=5){
                answer+=5;
                s[i-1]++;
            }
            else{
                answer += s[i];
            }
        }
        
        System.out.println(Arrays.toString(s));
        
        return answer;
    }
}