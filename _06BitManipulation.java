public class _06BitManipulation {
    public static void oddOrEven(int n){
        int bitMask = 1;
        if((n & bitMask) == 0){
            System.out.println(n + " is Even");
        }else{
            System.out.println(n + " is Odd");
        }
    }

    public static int getIthBit(int n, int i){
        int bitMask = 1 << i;
        return ((n & bitMask) == 0) ? 0 : 1;
    }

    public static int setIthBit(int n, int i){
        int bitMask = 1 << i;
        return n | bitMask;
    }

    public static int clearIthBit(int n, int i){
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    public static boolean isPowerOfTwo(int n){
        return (n & (n - 1)) == 0;
    }

    public static int countSetBits(int n){
        int count = 0;
        while(n > 0){
            if((n & 1) != 0){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 5, b = 6;

        System.out.println("=== Bitwise Operations ===");
        System.out.println(a + " & " + b + " = " + (a & b));  // AND
        System.out.println(a + " | " + b + " = " + (a | b));  // OR
        System.out.println(a + " ^ " + b + " = " + (a ^ b));  // XOR
        System.out.println("~" + a + " = " + (~a));           // Complement
        System.out.println(a + " << 2 = " + (a << 2));        // Left shift
        System.out.println(a + " >> 2 = " + (a >> 2));        // Right shift
        System.out.println();

        System.out.println("=== Odd or Even Check ===");
        oddOrEven(9);
        oddOrEven(10);
        System.out.println();

        System.out.println("=== Bit Manipulation ===");
        int n = 10;
        System.out.println("Binary of " + n + " = " + Integer.toBinaryString(n));
        System.out.println("Get 2nd bit of " + n + " = " + getIthBit(n, 2));
        System.out.println("Set 2nd bit of " + n + " = " + setIthBit(n, 2));
        System.out.println("Clear 1st bit of " + n + " = " + clearIthBit(n, 1));
        System.out.println();

        System.out.println("=== Power of Two Check ===");
        System.out.println("16 is power of 2? " + isPowerOfTwo(16));
        System.out.println("18 is power of 2? " + isPowerOfTwo(18));
        System.out.println();

        System.out.println("=== Count Set Bits ===");
        int x = 7;
        System.out.println("Binary of " + x + " = " + Integer.toBinaryString(x));
        System.out.println("Set bits in " + x + " = " + countSetBits(x));
    }
}
