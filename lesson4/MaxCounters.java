package lesson4;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * 문제 해석: counter 배열에 A[i]의 값을 인덱스로 삼아
 * A[i] 가 나오면  counter 배열의 A[i] 인덱스에 +1을 추가하고,
 * A[i]가 n+1이라면 제일 큰 카운터 값을 모든 인덱스에 심어준다
 *
 *  expected worst-case time complexity is O(N+M);
 */

public class MaxCounters {
    @Test
    public void test() {
        int A[] = {3, 4, 4, 6, 1, 4, 4,};
        int result[] = {3, 2, 2, 4, 2};
        Assert.assertArrayEquals(solution(5,A),result);
    }
    // 낮은 Performance로 인해 66%
    // N(m*n) ==> 이중 포문 쓰지말고 어떻게 풀지 고민해 볼 것!
    public int[] solution(int N, int[] A) {
        int result[] = new int[N];
        for(int i=0; i<A.length; i++){
            if(A[i] == N+1){  // maxCounter
                int max =0;
                for(int k=0; k<result.length; k++){ // 최댓값 찾는다
                    if(result[k]>max){
                        max = result[k];
                    }
                }
                for(int k=0; k<result.length; k++){ //모든 idx 최댓값 setting
                   result[k] = max;
                }
            }else{ // Increment operation
                result[A[i]-1]++;
            }
        }
        return result;
    }

    public int[] solution2(int N, int[] A) {

        return A;
    }
}