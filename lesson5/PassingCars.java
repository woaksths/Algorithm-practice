package lesson5;
import org.junit.Assert;
import org.junit.Test;
/**
 *
 *  A 라는 배열에 0은 동쪽을 향하는 차, 1은 서쪽을 향하는 차라고 할때
 *  (P,Q) -> (동쪽,서쪽)을 향하는 차의 쌍의 갯수를 구하여라...
 *  expected worst-case time complexity is O(N);
 *
 *  0이 자기 뒤에 있는 1은 감지 못한다.
 *
 *  # 이중 for문을 쓰지 않고 어떻게 문제를 해결할지 고민해볼 것! => prefix sum
 */
public class PassingCars {
    @Test
    public void test(){
        //       [0 ,5]  [2,5]  인덱스에서
        int A[] = {0,1,0,1,1};
        // (0,1) (2,3) (0,4)
        //       (0,3) (2,4)

        // 1인 인덱스를 기점으로 앞에 0이 몇개 있을지를 예측한다
        Assert.assertEquals(solution2(A),5);
    }
    public int solution(int[] A) { //
        // write your code in Java SE 8
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            // #1 배열에서 0이 나왔을 때
            // #2 그 다음부터 나올 수 있는 1을 카운팅한다
            int count = 0;
            if (A[i] == 0) {
                for (int k = i + 1; k < A.length; k++) {
                    if (A[k] == 1) {
                        count++;
                    }
                }
                sum += count;
            }
        }
        return sum; //  50 %
    }

    public int solution2(int[] A) {
        int zeroSum[] = new int[A.length];
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                if (A[i] == 0) {
                    zeroSum[i] = 1;
                } else {
                    zeroSum[i] = 0;
                }
            } else {
                if (A[i] == 0) {
                    zeroSum[i] = zeroSum[i - 1] + 1;
                } else {
                    zeroSum[i] = zeroSum[i - 1];
                }
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                sum += zeroSum[i];
            } else {
                continue;
            }
        }
        if (sum > 1000000000 || sum < 0) {
            return -1;
        } else {
            //The function should return −1
            // if the number of pairs of passing cars exceeds 1,000,000,000.
            return sum; // 1000%
        }
    }
}