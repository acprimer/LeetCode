/**
 * Created by yaodh on 2018/11/1.
 */
public class ReverseOnlyLetters {
//    public String reverseOnlyLetters(String S) {
//        if (S == null || S.length() <= 0) return S;
//
//        char[] arr = new char[S.length()];
//        Arrays.fill(arr, (char) 0);
//        for (int i = 0; i < S.length(); i++) {
//            if (!Character.isLetter(S.charAt(i))) {
//                arr[i] = S.charAt(i);
//            }
//        }
//        for (int i = 0, j = S.length() - 1; i < S.length(); i++) {
//            char ch = S.charAt(i);
//            if (Character.isLetter(ch))  {
//                while (arr[j] != 0) j--;
//                arr[j--] = ch;
//            }
//        }
//        return String.valueOf(arr);
//    }

    public String reverseOnlyLetters(String S) {
        if (S == null || S.length() <= 0) return S;

        char[] arr = S.toCharArray();
        int i = 0, j = arr.length-1;
        while (i < j) {
            if (!Character.isLetter(arr[i])) {
                i++;
            } else if (!Character.isLetter(arr[j])) {
                j--;
            } else {
                swap(arr, i++, j--);
            }
        }
        return String.valueOf(arr);
    }

    private void swap(char[] A, int i, int j) {
        char t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    public static void main(String[] args) {
        // a-bC-dEf-ghIj
        // j-Ih-gfE-dCba
        System.out.println(new ReverseOnlyLetters().reverseOnlyLetters("a-bC-dEf-ghIj"));
    }
}
