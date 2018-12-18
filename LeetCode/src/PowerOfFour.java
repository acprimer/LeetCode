public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;
        while (num != 0) {
            if (num > 1 && (num & 0x03) != 0) return false;
            num >>= 2;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfFour().isPowerOfFour(1));
        System.out.println(new PowerOfFour().isPowerOfFour(8));
        System.out.println(new PowerOfFour().isPowerOfFour(16));
        System.out.println(new PowerOfFour().isPowerOfFour(4));
        System.out.println(new PowerOfFour().isPowerOfFour(2));
        System.out.println(new PowerOfFour().isPowerOfFour(3));
    }
}
