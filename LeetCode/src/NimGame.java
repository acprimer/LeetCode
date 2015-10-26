/**
 * Created by yaodh on 15/10/21.
 */
public class NimGame {
    public boolean canWinNim(int n) {
        return n % 4 == 0 ? false : true;
    }

    public static void main(String[] args) {
        System.out.println(new NimGame().canWinNim(1348820612));
    }
}
