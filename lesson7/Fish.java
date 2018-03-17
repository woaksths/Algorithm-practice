package lesson7;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class Fish {
    @Test
    public void test(){
        int A[] = {4,3,2,1,5};
        int B[] = {0,1,0,0,0}; // 0 : upstream, 1: downstream
        Assert.assertEquals(solution2(A,B),2);
    }
    /**
     *  If P and Q are two fish and P < Q, then fish P is initially upstream of fish Q.
     *  0 : upstream , 1: downstream
     */

    /**
     * 1. stack이 비어있는데 올라오는 물고기라면.. count++
     * 2.  물고기가 내려갈때 stack에 넣고,
     * 2-1. 다음 물고기가 내려가는 물고기라면 마찬가지로 stack에 넣고.
     * 2-2. 올라오는 물고기라면 크기를 비교한다..
     * 2-3. 올라오는 물고기가 stack에 있는 물고기보다 크면 잡아먹는다...(잡아먹을 수록 stack에 있는 애들 하나씩 도장깨기) 누구 하난 뒤졌을 거임.
     * 2-3-1. 다먹었으면(stack empty) count up
     * 2-3-2. break;
     * 3. 모든 물고기 탐색 (반복 2)
     * 4. stack의 사이즈와 올라간 물고기와의 합을 더하면 될 거임
     */
    public int solution(int[] A, int[] B) {
        Stack<Integer> stack = new Stack<>();
        int count =0;
        for(int i=0; i<B.length; i++){
            if(stack.isEmpty()&& B[i] ==0){
                count++;
            }
            if(B[i] ==1){
                stack.push(A[i]);
            }
            if(!stack.isEmpty()){
                if(B[i] ==0){
                    for(int j=0; j<stack.size(); j++){
                        if(stack.peek() < A[i]){
                            stack.pop();
                        }else{
                            break;
                        }
                        if(stack.isEmpty()){ // 다 잡아 먹으면
                            count++;
                        }
                    }
                }
            }
        }
        return stack.size() + count;
    }

    public int solution2(int[] A, int[] B) {
        Stack<Integer> stack = new Stack<>();
        int count =0;
        for(int i=0; i<B.length; i++){
            if(stack.isEmpty()&& B[i] ==0){
                count++;
            }
            if(B[i] ==1){
                stack.push(A[i]);
            }
            if(!stack.isEmpty()){
                if(B[i] ==0){
                    while (stack.peek() < A[i]) {
                        stack.pop();
                        if(stack.isEmpty()) {
                            count++;
                            break;
                        }
                    }
                }
            }
        }
        return stack.size() + count;
    }
}
