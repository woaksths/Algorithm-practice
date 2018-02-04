package lesson4;

import org.junit.Assert;
import org.junit.Test;


/**
 *
 * 풀이순서
 *
 * 1. N size의 새로운 배열 result 을 만든다
 * 2. A 배열을 반복을 돌면서 값이 N+1 인지, 1~N인지 검사를 한다.
 * 3. 1~N 인 경우에 result 배열의 해당 값의 인덱스에 +1을 더해준다.
 * 4. N+1인 경우에 result 배열에서 최댓값을 찾아서 해당 값으로 모든 idx 값에 setting 한다.
 *
 * 시간복잡도 N(m*n)로 인해 테스트 결과 66%
 * 
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
            }else if(A[i]>=1 && A[i]<=N){ // Increment operation
                result[A[i]-1]++;
            }
        }
        return result;
    }

    /**
     *  jaeyoung
     *
     * 해결 전략
     *
     * 1.
     * 2.
     * 3.
     * 4.
     *
     */
    static int[] solution2(int N, int[] A) {
        int[] result = new int[N];
        int prevMaxCnt = 0;
        int newMaxCnt = 0;

        for(int i=0; i<A.length; i++) {
            if(A[i]==N+1 && prevMaxCnt!=newMaxCnt) {
                prevMaxCnt = newMaxCnt;
            } else if (A[i]==N+1)
                continue;
            else {
                if(result[(A[i]-1)]<prevMaxCnt)
                    result[(A[i]-1)] = prevMaxCnt + 1;
                else
                    result[(A[i]-1)]++;
                if(result[(A[i]-1)]>newMaxCnt) {
                    newMaxCnt++;
                }
            }
        }
        for(int i=0; i<N; i++)
            if(result[i]<prevMaxCnt)
                result[i] = prevMaxCnt;

        return result;		// 100%
    }
}