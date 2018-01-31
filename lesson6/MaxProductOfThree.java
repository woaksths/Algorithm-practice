package lesson6;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 * expected worst-case time complexity is O(N*log(N));
 */
public class MaxProductOfThree {

//For example, for the input [-5, 5, -5, 4] the solution returned a wrong answer (got -100 expected 125).

//For example, for the input [-5, -6, -4, -7, -10] the solution returned a wrong answer (got -280 expected -120).


    @Test
    public void test(){
        int A[] = {-5, -6, -4, -7,-10};
        // -5 -5 4 5
        Assert.assertEquals(solution(A),-120);
    }
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        if(A[A.length-1]<0 && A[0]<0){
            return A[A.length-1]*A[A.length-2]*A[A.length-3];
        }
        int maxNum = A[A.length-1];
        int num1 = A[0]*A[1];
        int num2 = A[A.length-2]*A[A.length-3];
        int num3 = Integer.max(num1,num2);
        return maxNum*num3;
    }
}
