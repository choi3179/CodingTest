/**
* 1. O가 X보다 2개 이상 더 많은 경우
* 2. X가 O보다 1개 이상 많은 경우
* 3. O가 완성일 때 X와 개수가 같은 경우 -> O가 선공이므로
* 4. X가 완성일 때 O의 개수가 1개더 많은 경우 -> X가 후공이므로
*/
import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = -1;
        
        String[][] b = new String[board.length][];
        int ocnt = 0;
        int xcnt = 0;
        
        // input 데이터 정제
        for(int i=0;i<board.length;i++){
            String[] line = board[i].split("");
            //System.out.println(Arrays.toString(line));
            for(int j=0;j<line.length;j++){
                if(line[j].equals("O"))
                    ocnt++;
                else if(line[j].equals("X"))
                    xcnt++;
            }
            b[i] = line;
        }
    
        
        // O,X의 개수에 따른 오류 출력
        if(ocnt - xcnt > 1 || xcnt - ocnt > 0)
            answer = 0;
        else{
            if(winCheck(b,'O') && ocnt == xcnt)
                answer = 0;
            else if(winCheck(b,'X') && ocnt - xcnt > 0)
                answer = 0;
            else
                answer = 1;
        }
        
        return answer;
    }
    
    public boolean winCheck(String[][] board, char ch){
        // 가로체크
        for(int i=0;i<board.length;i++){
            if(board[i][0].charAt(0) == ch &&
               board[i][1].charAt(0) == ch &&
               board[i][2].charAt(0) == ch){
                return true;
            }
        }
        
        // 세로체크
        for(int i=0;i<board.length;i++){
            if(board[0][i].charAt(0) == ch &&
               board[1][i].charAt(0) == ch &&
               board[2][i].charAt(0) == ch){
                return true;
            }
        }
        
        // 대각선 체크
        if(board[0][0].charAt(0) == ch && 
           board[1][1].charAt(0) == ch && 
           board[2][2].charAt(0) == ch)
            return true;
        
        if(board[2][0].charAt(0) == ch && 
           board[1][1].charAt(0) == ch && 
           board[0][2].charAt(0) == ch)
            return true;
        
        
        return false;
    }
}