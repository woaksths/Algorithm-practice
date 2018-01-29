package lesson4;

import org.junit.Assert;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;

/***
 * 2018.01.26
 *
 *  문제 해석 : Find the earliest time when a frog can jump to the other side of a river.
 *  개구리는 X가 주어지면 1부터 X까지의 원소가 다 존재해야만 점프가 가능하다 최초로 완성되는 시점.
 *  나뭇잎 즉 leaf의 구성이 최초로 이루어진 시점의 시간을 구하라. 시간이라하면 배열의 index 라 봐도 무방
 *
 *  시간복잡도 : expected worst-case time complexity is O(N);
 *  조건 : each element of array A is an integer within the range [1..X].
 */

public class FrogRiverOne {
    @Test
    public void testSolution(){
        int A[] ={1,1,1,1};
        Assert.assertEquals(solution(2,A),-1);
    }
    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int setSum=0;
        int idx=0;
        for(int i=0; i<=X; i++){
            sum+=i;
        }
        for(int i=0; i<A.length;i++){
            if(A.length ==1 && A[0]>1) {
                return -1;
            }
            if(!set.contains(A[i])){
                set.add(A[i]);
                setSum+=A[i];
                if(setSum==sum){
                    idx = i;
                    break;
                }
            }
        }
        if(set.size()!=X){
            return -1;
        }
        return idx;
    }
}
