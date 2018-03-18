package lesson9;

import org.junit.Test;

public class MaxSliceSum {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int ret = Integer.MIN_VALUE;
        int pSum = Integer.MIN_VALUE ;

        for(int i=0; i<A.length; i++){
            if(A.length == 1){
                return A[i];
            }

            pSum = Math.max(pSum,0) + A[i];
            ret = Math.max(ret, pSum);
        }
        return ret;
    }
}
