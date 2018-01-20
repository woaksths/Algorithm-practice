
import java.util.ArrayList;
import java.util.Set;

/***
 *
 * 2018 01 18
 *
 * 문제 해석 = [ 1 ~ 배열의 길이 +1] 값 중 missing Element 값을 구하는 문제
 *
 * 해결 전략 1 : 새로운 배열를 1~n+1까지 만들고 기존의 A 배열을 반복문을 돌면서
 * 어레이리스트에 존재하는 값을 하나씩 다 지워가면
 * 하나 남게되는 index 0 번째 요소가 missing Element가 되게 된다.
 * --> 위 문제는 시간 복잡도를 고려하지 않은 풀이로 50%가 나옴.
 *
 *
 * 해결 전략 2 : 방금 생각난게...
 *  1~N+2 의 합에서
 *  배열의 원소들을 반복을 돌리면서 뺴서
 *  최종적으로 나온 결과값이 missing Element가 될 것 같다. 100%
 */

public class PermMissingElem {

    public int solution(int[] A){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=1; i<=A.length+1; i++){
            arrayList.add(i);
        }
        for(int i=0; i<A.length; i++){
            int idx= arrayList.indexOf(A[i]);
            arrayList.remove(idx);
        }
        return arrayList.get(0);
    }

    public int solution2(int[] A){
        int sum=0;
        for(int i=0; i<A.length+2; i++){
            sum+=i;
        }
        for(int i=0; i<A.length; i++){
            sum-= A[i];
        }
        return sum;
    }

    public static void main(String args[]){
        PermMissingElem permMissingElem = new PermMissingElem();
        int A[] = new int[4];
        A[0] = 2;
        A[1] = 3;
        A[2] = 1;
        A[3] = 5;
        System.out.println(permMissingElem.solution2(A));
    }
}
