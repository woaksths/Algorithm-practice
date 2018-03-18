package lesson9;

import org.junit.Assert;
import org.junit.Test;

public class MaxProfit {

    @Test
    public void test(){
        int A[] = {23171, 21011, 21123, 21366, 21013, 21367};
        Assert.assertEquals(solution(A), 356);
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int psum = Integer.MIN_VALUE;
        int ret = Integer.MIN_VALUE;

        if (A.length == 0) {
            return 0;
        } else {
            int B[] = new int[A.length - 1];
            for (int i = 0; i < A.length - 1; i++) {
                B[i] = A[i + 1] - A[i]; // B[i] => 날마다 변동량 배열.
            }

            for (int i = 0; i < B.length; i++) { // maximum slice algorithm.
                psum = Math.max(psum, 0) + B[i];
                ret = Math.max(ret, psum);
            }

            if (ret < 0) {  // 이윤이 없을 때..
                return 0;
            }
            return ret;
        }
    }
}
