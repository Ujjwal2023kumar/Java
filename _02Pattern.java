public class _2Pattern {
    
    // 1. Right-Angled Triangle of Stars
    public static void pattern1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    // 2. Right-Aligned Triangle of Stars
    public static void pattern2(int n) {
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    // 3. Descending Number Triangle
    public static void pattern3(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    // 4. Ascending Number Triangle
    public static void pattern4(int n) {
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    // 5. Downward Triangle of Stars
    public static void pattern5(int n) {
        for (int i = n - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    // 6. Hollow Square with Stars on Border
    public static void pattern6(int n) {
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 1; j <= n + 1; j++) {
                if (i == 1 || i == n - 1 || j == 1 || j == n + 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    // 7. Incremental Numbers in a Triangle
    public static void pattern7(int n) {
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num++);
            }
            System.out.println();
        }
    }
    // 8. Alternating 0s and 1s in a Triangle
    public static void pattern8(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("0");
                } else {
                    System.out.print("1");
                }
            }
            System.out.println();
        }
    }
    // 9. Alphabetic Triangle
    public static void pattern9(int n) {
        char ch = 'A';
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(ch++);
            }
            System.out.println();
        }
    }
    // 10. Butterfly Pattern
    public static void pattern10(int n) {
        // 1st half
        for (int i = 1; i <= n; i++) {
            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // spaces
            for (int k = 1; k <= 2 * (n - i); k++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        // 2nd half
        for (int i = n; i >= 1; i--) {
            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // spaces
            for (int k = 1; k <= 2 * (n - i); k++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    // 11. Solid Rhombus
    public static void pattern11(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    // 12. Hollow Rhombus
    public static void pattern12(int n) {
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            // hollow rectangle
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
    // 13. Diamond Pattern
    public static void pattern13(int n) {
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            // stars
            for (int k = 1; k <= (2 * i) - 1; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (int i = n; i >= 1; i--) {
            // spaces
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            // stars
            for (int k = 1; k <= (2 * i) - 1; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        int n = 5; // Set n to 5 for all patterns
        // Call the pattern methods
        System.out.println("Pattern 1: Right-Angled Triangle of Stars");
        pattern1(n);
        System.out.println("Pattern 2: Right-Aligned Triangle of Stars");
        pattern2(n);
        System.out.println("Pattern 3: Descending Number Triangle");
        pattern3(n);
        System.out.println("Pattern 4: Ascending Number Triangle");
        pattern4(n);
        System.out.println("Pattern 5: Downward Triangle of Stars");
        pattern5(n);
        System.out.println("Pattern 6: Hollow Square with Stars on Border");
        pattern6(n);
        System.out.println("Pattern 7: Incremental Numbers in a Triangle");
        pattern7(n);
        System.out.println("Pattern 8: Alternating 0s and 1s in a Triangle");
        pattern8(n);
        System.out.println("Pattern 9: Alphabetic Triangle");
        pattern9(n);
        System.out.println("Pattern 10: Butterfly Pattern");
        pattern10(n);
        System.out.println("Pattern 11: Solid Rhombus");
        pattern11(n);
        System.out.println("Pattern 12: Hollow Rhombus");
        pattern12(n);
        System.out.println("Pattern 13: Diamond Pattern");
        pattern13(n);
    }
}
