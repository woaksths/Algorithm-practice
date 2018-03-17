package lesson6;
import org.junit.Assert;
import org.junit.Test;

public class NumberOfDisIntersections {
    /**
     * 문제 해석: 좌표계에서 원들의 교차 구간의 pair 갯수를 구하여라
     *
     * 문제 풀이:
     * 1. 제일 큰 원의 반지름이 겹치는 구간 n개 포함.
     * 2. 두번 째 큰 반지름과 제일 큰 원이 겹친다면 제일 큰 원은 제외하고 나머지 겹치는 구간을 포함
     *  -> 1에서 포함하였기 때문에 중복을 방지시키기 위함.
     * 3. 반지름이 제일 큰 인덱스를 순서대로 정렬, 인덱스도 같이 정렬시킨다
     * 4. idx - idx <= r+r 이면 겹치는 구간.
     *
     *  시간복잡도 : O(N*log(N))
     *
     */
    @Test
    public void test(){
        int A[] = {1,5,2,1,4,0};
        int B[] = {1, 2147483647,0};
        // idx: 1, 0 ,2
        // r: 2147483647, 1, 0
      //  Assert.assertEquals(solution(A),11);
        Assert.assertEquals(solution(B), 2);
    }
    public int solution(int[] A) {
// 반지름이 제일 큰 인덱스를 순서대로 뽑아본다
//   idx: 1 , 4 , 2 , (0,3) , 5
//     r: 5 , 4 , 2 , (1,1) , 0
    // idx:1   4-1 <9, 2-1 < 5+2, 1-0< 5+1, 3-1 < 5+1, 5-1 <5+0   num :5;
    // idx:4   4-2  <4+2 , 4-0< 4+1, 4-3 < 4+1, 5-4 <4+0  num:4,
    // idx:2   2-0 < 2+1, 3-2 <2+1, 5-2> 2+0  num : 2
    // idx:0   3-0> 1+1, 5-0 >1+0
    // idx:3   5-3> 1+0
    /// sum: 5 +  4 +  2   === 11

        // 1. 배열의 값의 큰 순서대로 idx를 정렬 시키는게 첫 단계
        int idxSort[] = new int[A.length];
        for(int i=0; i<A.length; i++){
            idxSort[i] = i;
        }
        // using  bubble sort
        // 소팅시 index까지 정렬하는 배열을 만듦
        for(int i=0; i<A.length; i++){
            for(int j=i+1; j<A.length; j++){
                if(A[i] < A[j]){
                    // 큰 순서대로 정렬
                    int temp = A[j];
                    A[j] = A[i];
                    A[i] = temp;

                    int idx= idxSort[j];
                    idxSort[j] = idxSort[i];
                    idxSort[i] = idx ;
                }
            }
        }
        int sum =0;
        for(int i=0; i<A.length; i++){
            int count = 0;

            for(int j=i+1; j<A.length; j++){
                long sumRadius = (long)A[i]+ (long)A[j];
                int gapIdx = Math.abs(idxSort[i]-idxSort[j]);

                if(gapIdx <= sumRadius ){
                    count++;
                }else{
                    continue;
                }
            }
            sum += count;
            if(sum> 10000000){
                return -1;
            }
        }
        return sum; //  correctness 100 % ;
                    // performance 12 % ;;; n^2  --> n*log(n)으로 바꾸기
    }
}