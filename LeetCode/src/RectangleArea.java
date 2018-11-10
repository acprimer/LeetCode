public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return area(A, B, C, D) + area(E, F, G, H)
                - crossed(A, C, E, G) * crossed(B, D, F, H);
    }

    private int area(int a, int b, int c, int d) {
        return (c - a) * (d - b);
    }

    private int crossed(int a, int b, int c, int d) {
        if (c <= a) {
            if (d > a) return Math.min(b, d) - a;
        } else if (c <= b) {
            return Math.min(b, d) - c;
        }
        return 0;





    }

    public static void main(String[] args) {
        System.out.println(new RectangleArea().computeArea(-3, 0, 3, 4, 0, -1, 9, 5));
    }
}
