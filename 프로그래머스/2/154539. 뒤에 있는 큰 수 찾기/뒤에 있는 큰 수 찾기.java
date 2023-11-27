import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<Integer>();    // 비교 후 작은 값들이 쌓이는 스택
        
        for(int i=numbers.length-1;i>=0;i--){
            while(!stack.isEmpty()){
                if(numbers[i] < stack.peek()){
                    answer[i] = stack.peek();
                    stack.push(numbers[i]);
                    break;
                }
                else{
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                answer[i] = -1;
                stack.push(numbers[i]);
            }
        }
        
        return answer;
    }
}