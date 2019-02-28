package airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Flatten2DVector {
    static class Vector2D implements Iterator<Integer> {
        private List<List<Integer>> vec;
        int row, col;
        int count;
        int index;

        public Vector2D(List<List<Integer>> vec2d) {
            this.vec = vec2d;
            row = col = 0;
            count = 0;
            index = 0;
            if (vec2d != null) {
                for (List<Integer> list : vec2d) {
                    if (list != null) {
                        count += list.size();
                    }
                }
            }
        }

        @Override
        public Integer next() {
            if (!hasNext()) throw new IllegalStateException();
            index++;
            while (vec.get(row) == null || col >= vec.get(row).size()) {
                row++;
                col = 0;
            }
            return vec.get(row).get(col++);
        }

        @Override
        public boolean hasNext() {
            return index < count;
        }

        @Override
        public void remove() {
            next();
        }
    }

    public static void main(String[] args) {
        Vector2D vec = new Vector2D(Arrays.asList(
                null,
                Arrays.asList(),
                Arrays.asList(),
                Arrays.asList(1, 2),
                Arrays.asList(3),
                Arrays.asList(),
                Arrays.asList(4, 5, 6),
                Arrays.asList(),
                null
                ));
        while (vec.hasNext()) {
            System.out.println(vec.next());
        }
    }
}
