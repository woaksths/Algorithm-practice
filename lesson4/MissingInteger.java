package lesson4;
import org.junit.Assert;
import org.junit.Test;
import java.util.*;


public class MissingInteger {
    @Test
    public void testSolution() {
        int A[] = {1,3,6,4,1,2};
        int B[] = {1,2,3};
        //  Assert.assertEquals(4, solution(A));
        Assert.assertEquals(solution2(B), 4);
    }

    /**
     *
     * 회고 : Array.sort()를 쓰면 시간복잡도가 커지니 사용자제 -> HashSet 성능 좋아 적극 반영
     *
     * 풀이 순서:
     * 1. 주어진 Input A 배열을 정렬한다
     * 2. A의 최댓값을 구한다
     * 2.1 최댓값이 0보다 작으면 1 반환.
     * 2.2 그렇지 않으면, 1부터 최댓값까지 set에 add한다
     * 2.3 set에 존재하는 배열 A의 값을 삭제하는 방법 이용.
     * 3 set의 사이즈가 0이면, set과 A과 동일 ==> 위에서 구한 최대값 +1 반환
     * 4. 그렇지 않으면 set에서 가장 작은 수 반환
     *
     * 결과 77% TimeComplexiy O(N) 혹은 O(n*log(n))
     */
    public int solution(int[] A) { // 77% 개선
        Arrays.sort(A); // 1. 정렬
        int max = A[A.length - 1]; // 2. 최댓값 구하기.
        if (max <= 0) { // 최댓값이 0보다 작으면 최소 양수는 1.
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= max; i++) {
            set.add(i);
        }
        int positiveIdx = -1;
        for (int i = 0; i < A.length; i++) { // 음수 버리기 위해 양수가 되는 idx 찾기
            if (A[i] > 0) {
                positiveIdx = i;
                break;
            }
        }
        for (int i = positiveIdx; i < A.length; i++) {
            set.remove(A[i]);
        }
        if (set.isEmpty()) {
            return max + 1;
        } else {
            Iterator iterator = set.iterator();
            int min = (int) iterator.next();
            //set 에서 제일 작은 수
            return min;
        }
    }

    public int solution2(int[] A) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0 && !list.contains(A[i])) { // 0이상 중복 x
                list.add(A[i]);
            }
        }
        if (list.isEmpty()) { // 0이하 원소만 있으면
            return 1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) { // 최댓값 찾고
            if (max < list.get(i)) {
                max = list.get(i);
            }
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            list1.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            list1.remove(list.get(i));
        }
        if (list1.isEmpty()) {
            return max + 1;
        } else {
            return list1.get(0);
        }
    }

    /**
     *   jaeyoung
     * 1. set을 활용하여 0이상인 숫자만 set에 add
     * 2. 1부터 가장 큰 정수까지 반복을 돌리면서 set에 포함되는지 안되는지 확인
     * 3. 포함되지 않는다면 해당 index 반환.
     */
    static int solution3(int[] A) {

        Set<Integer> arrSet = new HashSet<>();
        int result = 1;

        for(int i=0; i<A.length; i++) {
            if(A[i]>0)
                arrSet.add(A[i]);
        }

        for(int i=1; i<Integer.MAX_VALUE; i++)
            if(arrSet.contains(i))
                continue;
            else {
                result = i;
                break;
            }

        return result;
    }
}

