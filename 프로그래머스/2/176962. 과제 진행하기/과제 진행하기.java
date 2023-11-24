import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = {};
        
        Stack<String[]>     schedule = new Stack<>();   // 남은 스케줄
        ArrayList<String>   ans      = new ArrayList<String>();
        
        Arrays.sort(plans, (a,b) -> timeChange(a[1]) - timeChange(b[1]));   // 시간 순 정렬
        
        int i=0;
        int cur = 0;    // 현재 과제 시작 시간
        int next = 0;   // 다음 과제 시작 시간
        int p    = 0;   // 현재 과제 소요 시간
        int left = 0;   // 현재 과제를 하고 남은 시간
        while(i<plans.length){
            
            cur     = timeChange(plans[i][1]);
            p       = toInteger(plans[i][2]);
            
            if(i+1 != plans.length){
                next    = timeChange(plans[i+1][1]); 
                left    = next - cur;
                
                // 다음 과제 시작 시간 때문에 수행을 더 못할 경우
                if(p > left){
                    plans[i][2] = intToString(p - (next-cur));
                    schedule.push(plans[i]);
                    i++;
                    continue;
                }
                // 현재 과제를 수행
                else{
                     left -= p;
                }
                  
            }
            
            if(left >= 0){
                ans.add(plans[i][0]);
                i++; 
            }
            
            // 남은 과제 스택 체크
            while(!schedule.isEmpty()){
                String[] hw = schedule.pop();
                int next_p = toInteger(hw[2]);    // 다음 스케줄의 남은 시간
                //System.out.println(i + " / " + Arrays.toString(hw));
                // 과제를 다시 멈춤
                if(left < next_p){ 
                    hw[2] = intToString(next_p - left);
                    schedule.push(hw);
                    break;
                }
                else{
                    ans.add(hw[0]);
                    left -= next_p;
                }
            }
        }
        
        // 모든 과제를 진행한 후 아직 마무리하지 못 한 과제를 진행
        while(!schedule.isEmpty()){
            String[] hw = schedule.pop(); 
            ans.add(hw[0]);
        }

        answer = ans.toArray(new String[plans.length]);
        return answer;
    }
    
    int timeChange(String time){
        String[] s_time = time.split(":");
        int minute = 60*Integer.parseInt(s_time[0]) + Integer.parseInt(s_time[1]);
        return minute;
    }
    
    int toInteger(String n){
        return Integer.parseInt(n);
    }
    
    String intToString(int n){
        return Integer.toString(n);
    }
}