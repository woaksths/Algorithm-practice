import org.junit.Assert;
import org.junit.Test;

/****
 *
 * 2018 .01.19
 *
 *  문제 : 특정 p index 기준으로 나뉘어진 두 배열의 합의 최소 차를 구하는 문제
 *  조건 :  expected worst-case time complexity is O(N)
 *
 *  해결 전략:
 *
 *  초기 시작점에 sum1, sum2 를 해놓고 idx 를 늘려가면서 반복을 돌리면서
 *   sum2과 sum1 의 차이를 검색하는 것
 *
 *
 *   For example, for the input [-10, -20, -30, -40, 100]
 *   the solution returned a wrong answer (got 0 expected 20).
 */
public class TapeEquilibrium {
    @Test
    public void testSolution(){
        int array[] = {1,1};
        Assert.assertEquals(0,solution(array));
    }
    public int solution(int[] A) {
        int min = Integer.MAX_VALUE;
        int rightSum = 0;
        int leftSum = 0;
        for(int i=0; i<A.length; i++){
           rightSum += A[i];
       }
       if(A.length ==2){
           return Math.abs(A[0]-A[1]);
       }
       for(int i=1; i<A.length; i++){
        rightSum -= A[i-1];
        leftSum += A[i-1];
        if(min > Math.abs(leftSum-rightSum)){
            min = Math.abs(leftSum-rightSum);
        }
       }
        return min;
    }

        public static void main(String args[]){
            TapeEquilibrium tapeEquilibrium= new TapeEquilibrium();
            int array[] = new int[2];
            array[0]= 1;
            array[1] = 1;
            System.out.println(tapeEquilibrium.solution(array));
    }
}
