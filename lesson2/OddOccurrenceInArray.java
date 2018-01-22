
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * 문제해결 :: 배열에서 2개씩 숫자가 매핑되어서 쌍을 이룬다.
 *  그렇기 때문에 배열에서 존재하는 숫자의 카운트를 세어보아
 *
 *  그 카운트 값이 홀수이면 나머지 하나가 unPaired 인 채로 남게 된다. 
 *  값이 홀수인 unPaired 값을 출력하는 전략.
 *
 *  jaeyoung , yonmni : 두 분 다 set 자료구조중 hashSet을 활용하여 존재하면 제거를 하고,
 *  존재하지 않으면 set에 추가를 함으로써 최종적으로 홀수번 존재하는 숫자만 남게 하는 전략을 세웠다.
 *
 * 1. set 이용 ( 중복 X 자료구조 )
 * 2. set을 이용하여 중복이 되는 경우는 '짝수'개의 요소를 가지고 있음을 의미 --> 짝수개일때 set에서 제거
 * 3. 홀수개인 하나만의 원소만 set에 남아있다. --> output
 */

public class OddOccurrenceInArray {
    public int solution(int[] A) {
        int result=0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0; i<A.length;i++){
            if(!hashMap.containsKey(A[i])){ // 새로운 값일 경우 1을 넣어주고
                hashMap.put(A[i],1);
            }else{      // 기존의 값일 경우 카운트 값을 늘려준다.
                hashMap.put(A[i],hashMap.get(A[i])+1);
            }
        }
        // value%2 ==1 인 key 값 리턴.
        Iterator keys = hashMap.keySet().iterator();
        while (keys.hasNext()){
            int key = (int) keys.next();
            if(hashMap.get(key)%2==1){
                result = key;
                break;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        OddOccurrenceInArray oc = new OddOccurrenceInArray();
        int array[] = new int[7];
        array[0] = 9;  // 0,2 // 1,3// 4,6// 5
        array[1] = 3;
        array[2] = 9;
        array[3] = 3;
        array[4] = 9;
        array[5] = 7;
        array[6] = 9;
        System.out.println(oc.solution(array));
    }
}