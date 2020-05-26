package fb;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        //abcca
        // a a
        // b c -> skip 1
        // b c
        // "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"

        int i = 0;
        int j = s.length()-1;

        int skip = 0;

        return recurCheck(i, j, skip, s);
    }

    private boolean recurCheck(int start, int end, int skip, String s) {

        if (start >= end) {
            return true;
        }
        if (s.charAt(start) == s.charAt(end)) {
            return recurCheck(start+1, end-1, skip, s);
        }
        if (skip > 0) {
            return false;
        }
        boolean skipAtStart = false;
        boolean skipAtEnd = false;
        if (s.charAt(start+1) == s.charAt(end)) {
            skipAtStart = recurCheck(start+2, end-1, skip+1, s);
        }
        if (s.charAt(start) == s.charAt(end-1)) {
            skipAtEnd = recurCheck(start+1, end-2, skip+1, s);
        }
        return skipAtStart || skipAtEnd;
    }
}
