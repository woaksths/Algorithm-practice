package lesson5;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;

public class GenomicRangeQuery {
    @Test
    public void test(){
        String S= "CAGCCTA";
         //       2,1,3,2,2,4,1
        //        2,3,6,8,10,14,15
        int P[] = {2,5,0};
        int Q[] = {4,5,6};
        // 2 4 -> 2,3,4     GCC :3 2 2
        // 5 5 -> 5         T : 4
        // 0 6  -> 0,1,2,3,4,5,6     CAGCCTA : --- > 1
        int result[] = {2,4,1};
        Assert.assertArrayEquals(solution2(S,P,Q),result);
    }
    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        int M = P.length;
        int result[] = new int[M];
        HashMap<Character,Integer> hashMap = new HashMap<>();
        hashMap.put('A',1);hashMap.put('C',2);
        hashMap.put('G',3);hashMap.put('T',4);

        for(int i=0; i<M; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = P[i]; j <= Q[i]; j++) {
                int compareVal = hashMap.get(S.charAt(j)).intValue();
                if (min > compareVal) {
                    min = compareVal;
                }
            }
            result[i] = min;
        }
        return result;  // 62%, O(N*M)
        //expected worst-case time complexity is O(N+M);
    }

    public int[] solution2(String S,int [] P, int[] Q){
        int M = P.length;
        int result[] = new int[M];
        HashMap<Character,Integer> hashMap = new HashMap<>();
        hashMap.put('A',1);hashMap.put('C',2);
        hashMap.put('G',3);hashMap.put('T',4);
        String array[] = new String[M];

        for(int i=0; i<M; i++){
            array[i] = S.substring(P[i],Q[i]+1);
        }

        for(int i=0; i<array.length; i++){
            if(array[i].contains("A")){
                result[i] = 1;
            }else if(!array[i].contains("A")&&array[i].contains("C")){
                result[i] = 2;
            }else if(!array[i].contains("A")&&!array[i].contains("C") && array[i].contains("G")){
                result[i] = 3;
            }else if(!array[i].contains("A")&&!array[i].contains("C") && !array[i].contains("G")&& array[i].contains("T")){
                result[i] =4;
            }
        }
        return result; // 62%
    }
}