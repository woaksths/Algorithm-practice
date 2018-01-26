import org.junit.Assert;
import org.junit.Test;

public class FrogJmp {
    /**
     *
     *  1/18/2018
     * 문제해결: 반복문을 쓰면 타임 컴플렉시티가 O(n) 으로 예상되기 때문에
     *  수식을 이용하여 문제를 해결하면 반복문을 안써도 될 것 같다!!
     *  X + n*D >= Y  // 여거시 n을 구하는 구하면 끝
     *   몫을 구하고 나머지가 존재하면 +1 시켜준다.
     *
     */
    @Test
    public void testSolution(){
        Assert.assertEquals(3,solution(10,85,30));
    }
    public int solution(int X,int Y, int D){
        int result = (Y-X)/D;
        int rem = (Y-X) % D;
        if(rem >0){
            return result+1;
        }else{
            return result;
        }
    }

    public static void main(String args[]){
        FrogJmp frogJmp = new FrogJmp();
        System.out.println(frogJmp.solution(10, 85, 30));
    }
}
