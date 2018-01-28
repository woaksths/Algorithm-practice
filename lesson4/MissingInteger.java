package lesson4;

import org.junit.Assert;
import org.junit.Test;

import java.util.TreeSet;


/**
 *
 * 문제 해석: given an array A of N integers,
 * returns the smallest positive integer (greater than 0) that does not occur in A.
 * A의 배열의 원소에 해당하지 않는 것중에서 가장 최소 양의 정수 값을 구해라
 */
public class MissingInteger {
    @Test
    public void testSolution(){
        int A[] = {1,3,6,4,1,2};
        int B[] ={-1,-3};
        Assert.assertEquals(5, solution(A));
        Assert.assertEquals(1,solution(B));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        return 0;
    }
}
