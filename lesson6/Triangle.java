package lesson6;

import org.junit.Assert;
import org.junit.Test;

public class Triangle {
    @Test
    public void test(){
        int A[] = {10,2,5,1,8,20};
        // 0,2,4 is triangular
        int B[] = {10,50,5,1};
        Assert.assertEquals(solution(A),1);
        Assert.assertEquals(solution(B),0);
    }
    /**
     * (P,Q,R) -> (small, middle, big)  0<= small < middle < big
     *
     *   A[small] + A[middle] > A[big]
     *   A[middle] + A[big] > A[small]
     *   A[big]  + A[small] > A[middle]
     */
    public int solution(int[] A) {
        // write your code in Java SE 8
        int flag = 0;
        for(int i=0; i<A.length; i++){
            for(int j= i+1; j<A.length; j++){
                for(int k = j+1; k<A.length ; k++){
                    if (A[i] + A[j] > A[k] && A[j] + A[k] > A[i] && A[k]+A[i]>A[j]) {
                        flag = 1;
                        break;
                    }else{
                        continue;
                    }
                }
            }
        }
        if(flag == 0){
            return 0;
        }else{
            return 1; // 56% O(n^3);
        }
    }
}
