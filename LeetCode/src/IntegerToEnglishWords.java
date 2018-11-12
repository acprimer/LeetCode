/**
 * Created by yaodh on 2018/11/12.
 */
public class IntegerToEnglishWords {
    public String numberToWords(int num) {
        if (num < 100) return numberBelow100(num);

        int[] place = {1000000000, 1000000, 1000, 100};
        String[] value = {"Billion", "Million", "Thousand", "Hundred"};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < place.length; i++) {
            if (num / place[i] > 0) {
                builder.append(numberToWords(num / place[i]));
                builder.append(' ');
                builder.append(value[i]);
                num %= place[i];
                builder.append(' ');
            }
        }
        if (num > 0) builder.append(numberBelow100(num));

        return builder.toString().trim();
    }

    private String numberBelow100(int num) {
        String[] single = {"Zero", "One", "Two", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        if (num < 20) return single[num];
        else {
            String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty",
                    "Sixty", "Seventy", "Eighty", "Ninety"};
            StringBuilder builder = new StringBuilder();
            builder.append(tens[num / 10]);
            if (num % 10 > 0) {
                builder.append(" ");
                builder.append(numberBelow100(num % 10));
            }
            return builder.toString().trim();
        }
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToEnglishWords().numberToWords(10000000));
    }
}
