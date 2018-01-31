package lesson4;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/***
 *
 * 2018.01.26
 * 문제 해석: The goal is to check whetjer array A is a permutation
 * missing Value 존재하면 not permutation, 여기서 missing Value라고 하면
 * 배열의 수 중 가장 큰 값 범위 내에 모든 수가 존재해야한다는 것임. 없으면 missing Value.
 *
 *  시간복잡도 : expected worst-case time complexity is O(N);
 *
 *  단 각 숫자들은 한번씩만 출현해야한다
 *  해결 전략2: 배열을 정렬해주고, 정렬된 배열의 최댓값을 가지고 1부터 최댓값까지 새로운 배열을 만들고
 *  두 배열의 인덱스 값을 비교하여 문제를 해결하였다
 */
public class PermCheck {
    @Test
    public void test(){
        int A[]={9, 5, 7, 3, 2, 7, 3, 1, 10, 8}; //4,6
        Assert.assertEquals(0, solution(A));
    }
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int b[] = new int[A.length];
        for(int i=0; i<A.length; i++){
            b[i] = i+1;
        }
        int flag = 1;
        for(int i=0; i<b.length; i++){
            if(A[i] ==b[i])
                continue;
            else
                flag=0;
                break;
        }
            return flag;
        }
}
