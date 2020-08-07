public class Test {

    public static void main(String[] args) {


    }

    public int search(int[] intArr, int target){

        int low = 0;
        int hight = intArr.length -1 ;
        int middle = 0;

        while (low<=hight){
            middle = (low + hight)/2;
            if(middle == target){
                return intArr[middle];
            }else if(middle < target){

                low = middle +1 ;
            }else {
                hight = middle -1;
            }

        }


        return -1;
    }
}
