package lesson4;

import org.junit.Assert;
import org.junit.Test;

/***
 *
 * 2018.01.26
 * 문제 해석: The goal is to check whetjer array A is a permutation
 * missing Value 존재하면 not permutation, 여기서 missing Value라고 하면
 * 배열의 수 중 가장 큰 값 범위 내에 모든 수가 존재해야한다는 것임. 없으면 missing Value.
 *
 *  시간복잡도 : expected worst-case time complexity is O(N);
 *  해결 전략: 가장 큰 수 찾고, 1부터 큰 수 합이 배열의 합과 같으면 permutation 보다 작으면 not permutation
 *
 *
 */
public class PermCheck {

    @Test
    public void test(){
        int A[]={4,1,3};
        Assert.assertEquals(0, solution(A));
    }
    public int solution(int[] A) {
        // write your code in Java SE 8
        int max = 0;
        int arraySum = 0;
        int sumUntilMax=0;
        for(int i=0; i<A.length; i++){
            arraySum += A[i];
            if(max < A[i]) {
                max = A[i];
            }
        }
        for(int i=0; i<=max;i++){
            sumUntilMax+=i;
        }
        if(sumUntilMax ==arraySum) {
            return 1;
        }
        else{
            return 0;
        }
    }
}
