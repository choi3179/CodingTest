class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        long r1p = (long) Math.pow(r1,2);
        long r2p = (long) Math.pow(r2,2);

        for(int x=0;x<=r2;x++){
            long y1 = (long)Math.sqrt(r1p - Math.pow(x,2));     // y의 최솟값
            long y2 = (long)Math.sqrt(r2p - Math.pow(x,2));     // y의 최댓값
            if(Math.sqrt((r1p - Math.pow(x,2))) % 1 == 0)
                answer++;
            answer += (y2 - y1);
        }


        return (answer-1)*4;
    }
}