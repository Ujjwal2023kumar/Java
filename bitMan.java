package BitManipulation;

public class bitMan {
    public static void oddOrEven(int n){
        int bitMask = 1;
        if((n & bitMask) == 0){
            System.out.println("Even Number");
        }else{
            System.out.println("Odd Number");
        }
    }
    public static int getIthBit(int n, int i){
        int bitMask = 1<<i;
        if((n & bitMask) == 0){
            return 0;
        }else{
            return 1;
        }
    }
    public static int setIthBit(int n, int i){
        int bitMask = 1<<i;
        return n | bitMask;
    }
    public static int clearIthBit(int n, int i){
        int bitMask = ~(1<<i);
        return n & bitMask;
    }
    public static boolean isPowerOfTwo(int n){
        return (n&(n-1)) == 0;
    }
    public static int countSetBits(int n){
        int count = 0;
        while(n>0){
            if((n&1) != 0){
                count++;
            }
            n = n>>1;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(5 & 6);  // AND operation 
        System.out.println(5 | 6);  // OR operation
        System.out.println(5 ^ 6);  // XOR operation
        System.out.println(~ 5); // Complement operation
        System.out.println(5<<2); // Binary Left shift operation
        System.out.println(5>>2); // Binary Right shift operation

        oddOrEven(9);
        System.out.println(getIthBit(10, 2)); //0
        System.out.println(setIthBit(10, 2)); //14
        System.out.println(clearIthBit(10, 1)); //8
        System.out.println(isPowerOfTwo(16)); //true
        System.out.println(countSetBits(7));
    }
}
