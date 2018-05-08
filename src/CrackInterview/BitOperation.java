package CrackInterview;

public class BitOperation {

    // (1<<x) - 1   => make a mask of 000111111
    // ~0 is 1111111111
    //n - 1 => make initial 0s to 1s, and the Least significant 1 to 0
    // (a>>i) & 1) check the last bit!!!!!
    //OR  (n & (1 << index))  check specific bit   (GET BIT)
    // n | ( 1 << x )       (SET BIT)
    public static void main(String[] args) {
        getMaskOf0Between( 5, 3);
    }

    static int getMaskOf0Between(int left, int right){
        int max = ~0;   //11111111
        int right1s = (1<<right) - 1;     //00001111
        int left1s = max - ((1<<left) - 1);   //11000000
        return left | right;    //11001111

    }
}



