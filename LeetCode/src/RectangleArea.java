public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return area(A, B, C, D) + area(E, F, G, H)
                - crossed(A, C, E, G) * crossed(B, D, F, H);
    }

    private int area(int a, int b, int c, int d) {
        return (c - a) * (d - b);
    }

    private int crossed(int a, int b, int c, int d) {
        if (d <= a || c >= b) return 0;
        else return Math.min(b, d) - Math.max(a, c);
        // 会溢出
//        return Math.max(Math.min(b, d) - Math.max(a, c), 0);
    }

    // 可以AC
//    private int crossed(int a, int b, int c, int d) {
//        if (c <= a) {
//            if (d > a) return Math.min(b, d) - a;
//        } else if (c <= b) {
//            return Math.min(b, d) - c;
//        }
//        return 0;
//    }

    public static void main(String[] args) {
//        System.out.println(new RectangleArea().computeArea(-3, 0, 3, 4, 0, -1, 9, 5));
        System.out.println(new RectangleArea().computeArea(-1500000001,
                0,
                -1500000000,
                1,
                1500000000,
                0,
                1500000001,
                1));
    }
}
