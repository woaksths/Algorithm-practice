package lesson5;
import org.junit.Assert;
import org.junit.Test;



public class MinAvgTwoSlice {
    /**
     *  The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice.
     *  To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
     *  ==> The goal is to find the starting position of a slice whose average is minimal
     */
    @Test
    public void test(){
        int A[] = {4,2,2,5,1,5,8};
        int B[] = {-3, -5, -8, -4, -10};
        Assert.assertEquals(solution(B), 2);
    }
    public int solution(int[] A) {
        // write your code in Java SE 8
        int startIdx = -1;
        double compareSum = 99999999;
        for(int i=0; i<A.length; i++){
            int sum = A[i];
            for(int j=i+1; j<A.length; j++){
                sum += A[j];
                double result = sum / (double) (j-i +1);
                if(result< compareSum){
                    compareSum =result;
                    startIdx= i;
                }else{
                    continue;
                }
            }
        }
        return startIdx; // correctness 100 , performance : 20
    }

    public int solution2(int[] A) {
        return 0;
    }
}