/**
 * Created by yaodh on 2018/6/12.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        swap(arr, 0, arr.length);
        for (int i = 0; i < arr.length; ) {
            while (i < arr.length && arr[i] == ' ') i++;
            int start = i;
            while (i < arr.length && arr[i] != ' ') i++;
            int end = i;
            swap(arr, start, end);
        }
        int len = reduce(arr);
        return new String(arr, 0, len);
    }

    private void swap(char[] arr, int start, int end) {
        for (int i = start, j = end - 1; i < j; i++, j--) {
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    private int reduce(char[] arr) {
        int len = 0;
        for (int i = 0; i < arr.length; ) {
            while (i < arr.length && arr[i] == ' ') i++;
            while (i < arr.length && arr[i] != ' ') arr[len++] = arr[i++];
            while (i < arr.length && arr[i] == ' ') i++;
            if (i < arr.length) arr[len++] = ' ';
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAString().reverseWords(" the  sky  is blue "));
    }
}
