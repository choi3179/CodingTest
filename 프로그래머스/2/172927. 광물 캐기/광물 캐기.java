import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int len = minerals.length;
        int total = picks[0] + picks[1] + picks[2];
        int n = len / 5 + 1; // 광물 리스트를 5개씩 쪼개서 확인
        
        // 2차원 배열에 5개씩 쪼갠 광물 리스트에서 각각 다이아,철,돌에 필요한 필요도 계산
        int[][] costs = new int[n][3];
        
        for(int i=0;i<n;i++){
            if(total == 0)
                break;
            int[] cost = new int[3];
            for(int j = i*5;j<i*5+5;j++){
                if(j == len) 
                    break;
                
                switch(minerals[j].charAt(0)) {
                    case 'd' :
                        cost[0]+=1;
                        break;
                    case 'i' :
                        cost[1]+=1;
                        break;
                    case 's' :
                        cost[2]+=1;
                        break;
                    default:  break;
                }
                costs[i] = cost;
            }
            total--;
        }
        
        Arrays.sort(costs, (a,b) -> {
            if(b[0]-a[0] == 0)
                return b[1] - a[1];
            return b[0] - a[0];
        });
        
        int idx = 0;
        for(int i=0;i<picks.length;i++){
            while(picks[i] != 0 && idx < costs.length){
                switch(i) {
                    case 0:
                        answer = answer + costs[idx][0] + costs[idx][1] + costs[idx][2]; 
                        break;
                    case 1:
                        answer = answer + (costs[idx][0] * 5) + costs[idx][1] + costs[idx][2]; 
                        break;
                    case 2:
                    
                        answer = answer + (costs[idx][0] * 25) + (costs[idx][1] * 5) + costs[idx][2]; 
                        break;
                    default: break;    
                }
                picks[i]-=1;
                total--;
                idx++;
            }
            if(idx == costs.length)
                break;
        }
        
        return answer;
    }
}