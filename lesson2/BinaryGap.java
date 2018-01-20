
public class BinaryGap {
    /***
     *
     * '1' 인 bit의 index만 찾아
     *  인접한 index 간의 값의 차이를 구해 최댓값을 구하였다.
     *
     * @param N
     * @return
     */
    private static int solution(int N) {
        int max = 0;
        int idx = 0;
        int startPoint= 0;

        String binary = Integer.toBinaryString(N);
        for(int i=0; i<binary.length(); i++){
            if(binary.charAt(i) == '1'){
                if(startPoint == 0){
                    startPoint=1;
                    idx = i;
                }else{
                    if(i-idx-1 >max){
                        max = i-idx-1;
                    }
                    idx = i;
                }
            }
        }
        return max;
    }

    public static void main(String args[]){
       int result = solution(8);
       if(result == 0 ){
           System.out.println("no binary gaps");
       }else{
           System.out.println(result);
       }
    }
}

