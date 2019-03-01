import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GuessTheWord {
    private static class Master {
        private String secret = "ccoyyo";

        public int guess(String word) {
            return compare(secret, word);
        }
    }

    private static int compare(String s, String t) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public void findSecretWord(String[] wordlist, Master master) {
        boolean[] vis = new boolean[wordlist.length];
        while (true) {
            int i = new Random().nextInt() % wordlist.length;
            if (i < 0) i = -i;
            if (vis[i]) continue;
            vis[i] = true;
            String word = wordlist[i];
            int correct = master.guess(word);
            if (correct == 6) break;
            for (int j = 0; j < wordlist.length; j++) {
                if (compare(word, wordlist[j]) != correct) {
                    vis[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        new GuessTheWord().findSecretWord(new String[]{
                "wichbx", "oahwep", "tpulot", "eqznzs", "vvmplb", "eywinm", "dqefpt", "kmjmxr", "ihkovg", "trbzyb", "xqulhc", "bcsbfw", "rwzslk", "abpjhw", "mpubps", "viyzbc", "kodlta", "ckfzjh", "phuepp", "rokoro", "nxcwmo", "awvqlr", "uooeon", "hhfuzz", "sajxgr", "oxgaix", "fnugyu", "lkxwru", "mhtrvb", "xxonmg", "tqxlbr", "euxtzg", "tjwvad", "uslult", "rtjosi", "hsygda", "vyuica", "mbnagm", "uinqur", "pikenp", "szgupv", "qpxmsw", "vunxdn", "jahhfn", "kmbeok", "biywow", "yvgwho", "hwzodo", "loffxk", "xavzqd", "vwzpfe", "uairjw", "itufkt", "kaklud", "jjinfa", "kqbttl", "zocgux", "ucwjig", "meesxb", "uysfyc", "kdfvtw", "vizxrv", "rpbdjh", "wynohw", "lhqxvx", "kaadty", "dxxwut", "vjtskm", "yrdswc", "byzjxm", "jeomdc", "saevda", "himevi", "ydltnu", "wrrpoc", "khuopg", "ooxarg", "vcvfry", "thaawc", "bssybb", "ccoyyo", "ajcwbj", "arwfnl", "nafmtm", "xoaumd", "vbejda", "kaefne", "swcrkh", "reeyhj", "vmcwaf", "chxitv", "qkwjna", "vklpkp", "xfnayl", "ktgmfn", "xrmzzm", "fgtuki", "zcffuv", "srxuus", "pydgmq"
        }, new Master());
    }
}
