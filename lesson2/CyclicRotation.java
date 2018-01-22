
/***
 *
 * 문제해결 전략 : circular shift right
 * 배열의 이전 값을 반복해서 오른쪽으로 덮어씌워서 문제해결하였다
 * 그렇게 하려면 마지막 인덱스 값은 사라지기 때문에 초기에 저장을 해줘야하며,
 * 반복이 끝났을 시, 0번째 값에다가 저장한 값을 대입해줘야한다.
 *
 * 시행착오 : 배열의 length가 0일때, arrayIndexOfBounds 문제로
 *  테스트케이스를 통과하지 못한 경우가 있었다 87%
 *
 *
 *  jaeyoung :
 *  시간복잡도를 줄이는 데에 초점을 맞추셨다
 * 1. K번 이동한다는 것은 '기본인덱스 + K'로 이동한다.
 * 2. 사이즈를 초과하면 0부터 초과한 장소로 이동하여 적재.
 * 3. 나머지 수를 활용하면 K번이 배열의 길이를 초과하는 횟수를 단축시켜줌
 *
 *  yomni :
 *  queue를 이용한 접근방법 & Junit을 활용한 테스트 코드를 썼다.(다음부터는 적극 활용할 것)
 * 1. Array를 queue로 변환
 * 2. queue에서 K번만큼 poll & add
 * 3. queue를 array로 변환.
 */

public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        while (K>0){
            if(A.length == 0)break;

            int temp = A[A.length-1];
            for(int i=A.length-1; i>0; i--){
                A[i] = A[i-1];
           }
            A[0] = temp;
            K--;
        }
        return A;
    }

    public static void main(String args[]){
        int array[] = {3,8,9,7,6};
        CyclicRotation c= new CyclicRotation();
        c.solution(array,3);
        for(int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
}
