import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length - 1};
        
        int l = 0;
        int r = 1;
        
        int sum = sequence[0];
        while(l<r){
            if(sum == k){
                if(answer[1]-answer[0] > r - 1 - l){
                    answer[0] = l;
                    answer[1] = r-1;
                }
                sum-=sequence[l];
                l++;
            }
            else if(sum > k){
                sum-=sequence[l];
                l++;
            }
            else if(sum < k && r < sequence.length){    // 인덱스 접근 오류 체크
                sum+=sequence[r];
                r++;
            }
            else
                break;
            
        }
        
        return answer;
        
    }
}