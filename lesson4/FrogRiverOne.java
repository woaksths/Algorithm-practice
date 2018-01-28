package lesson4;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/***
 *
 * 2018.01.26
 * 문제 해석 : Find the earliest time when a frog can jump to the other side of a river.
 *  개구리는 X가 주어지면 1부터 X까지의 원소가 다 존재해야만 점프가 가능하다 최초로 완성되는 시점.
 *  나뭇잎 즉 leaf의 구성이 최초로 이루어진 시점의 시간을 구하라. 시간이라하면 배열의 index 라 봐도 무방
 *
 *  시간복잡도 : expected worst-case time complexity is O(N);
 */
public class FrogRiverOne {
    @Test
    public void testSolution(){
        int A[] ={1,3,1,4,2,3,5,4};
        Assert.assertEquals(solution(5,A),6);
    }

    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        // 1,3,1,4,2,3,5,4
        // 1 ok
        // 3 ok
        // 1 기존의 존재
        // 4 ok
        // 2 ok
        // 3 기존 존재
        // 5 ok 끝
        return 0;
    }
}