package lesson9;

import org.junit.Assert;
import org.junit.Test;

public class MaxDoubleSliceSum {
    /**
     * A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N
     * The goal is to find the maximal sum of any double slice.
     *
     *  시간복잡도 : O(N)
     *  더블 슬라이스의 최대 합을 구하는 문제...
     *
     *  The sum of double slice (X, Y, Z) --> [x+1 ~ y-1, y+1 ~ z-1]
     *  is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1]
     *  A[Y + 1] + A[Y + 2] + ... + A[Z − 1]
     *
     */

    @Test
    public void test(){
        int A[] = {3,2,6,-1,4,5,-1,2};
        Assert.assertEquals(solution(A), 20);
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int ret = 0;
        int pSum = 0;



        return ret;
    }
}
