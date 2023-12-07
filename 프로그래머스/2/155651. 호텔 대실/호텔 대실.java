import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[][] book_min = new int[book_time.length][2];     // 시간으로 표현된 배열을 분으로 바꾼 배열
        
        ArrayList<int[]> rooms = new ArrayList<int[]>();
        
        for(int i=0;i<book_time.length;i++){ 
            for(int j=0;j<book_time[i].length;j++){
                book_min[i][j] = timeChange(book_time[i][j]);
            }
        }
        
        Arrays.sort(book_min, (a,b) -> {
            if(a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        
        for(int i=0;i<book_min.length;i++){
            boolean flag = false;  // 새로운 방이 필요한 경우(루프를 그냥 통과한 경우)
            if(rooms.isEmpty()){
                rooms.add(book_min[i]);
                continue;
            }
            for(int j=0;j<rooms.size();j++){
                int checkIn = book_min[i][0];
                if(checkIn >= rooms.get(j)[1] + 10){
                    rooms.set(j,book_min[i]);
                    flag = true;    // 새로운 방이 필요없다.
                    break;
                }
            }
            if(!flag)
                rooms.add(book_min[i]);
        }
        
        answer = rooms.size();
        
        return answer;
    }
    
    public int timeChange(String time){
        String[] s = time.split(":");
        int m = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
        
        return m;
    }
}