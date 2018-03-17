package lesson6;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 * expected worst-case time complexity is O(N*log(N));
 */
public class MaxProductOfThree {
    @Test
    public void test(){
        int A[] = {-5, -6, -4, -7,-10};
        Assert.assertEquals(solution(A),-120);
    }
    public int solution(int[] A) {
        Arrays.sort(A);
        // 1. 정렬
       if(A[A.length-1]<0){ // 2. 모두 음수 일 경우
            return A[A.length-1]*A[A.length-2]*A[A.length-3];
        }

        int maxNum = A[A.length-1];
       // 3. 제일 큰 수
        // 음수가 포함될 수 있기 때문에 정렬된 맨앞의 두 수와 마지막 큰 두 세 번째 문제를 비교.
        int num1 = A[0]*A[1];
        int num2 = A[A.length-2]*A[A.length-3];
        // 음수일 경우 절댓값이 더 작은수가 크다
        // 둘중 더 큰 것을 제일 큰 수 maxNum과 곱해서 결과 출력.
        int num3 = Integer.max(num1,num2);
        return maxNum*num3;
    }
}

