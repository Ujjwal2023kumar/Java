public class _01Basic {
    
    public static void binaryToDecimal(int n) {
        int pow = 0;
        int decimal = 0;
        int originalN = n; 
        while (n > 0) {
            int lastDigit = n % 10;
            decimal = decimal + (lastDigit * (int) Math.pow(2, pow));
            pow++;
            n = n / 10;
        }
        System.out.println(originalN + " is converted into " + decimal);
    }

    public static void decimalToBinary(int n) {
        int binary = 0;
        int place = 1;
        int originalN1 = n; 
        while (n > 0) {
            int rem = n % 2;
            binary += rem * place;
            n = n / 2;
            place *= 10;
        }
        System.out.println(originalN1 + " is converted into " + binary);
    }

    public static int fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public static boolean isprimeNo(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isprimeO(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void reverseNumber(int n) {
        int reverseNum = 0;
        int originalN4 = n; 
        while (n > 0) {
            int rem = n % 10;
            reverseNum = (reverseNum * 10) + rem;
            n = n / 10;
        }
        System.out.println(originalN4 + " is reversed into " + reverseNum);
    }

    public static void main(String[] args) {
        binaryToDecimal(100101);
        decimalToBinary(5);
        int factNum = fact(5);
        System.out.println(factNum);
        reverseNumber(100101);
        boolean result1 = isprimeNo(5);
        boolean result2 = isprimeO(5);
        System.out.println("Using non-optimized method: " + result1);
        System.out.println("Using optimized method: " + result2);
    }
}
