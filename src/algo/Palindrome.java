package algo;

public class Palindrome {

    //Palindrome: read (forwards or backwards) are the same
    //Ex: "A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a palindrome. (ignore non-letter)
    //    "race a car" is not a palindrome.
    // running time O(n) space O(1)
    static boolean isPalindrome(String input) {
        int i = 0, j = input.length() - 1;
        while( i < j ) {
            while(i < j && !Character.isLetterOrDigit(input.charAt(i))) i++;
            while(i < j && !Character.isLetterOrDigit(input.charAt(j))) j--;

            if (Character.toLowerCase(input.charAt(i)) != Character.toLowerCase(input.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama.";
        System.out.println(isPalindrome(input) ? "palindrome" : "not palindrome");

        input = "race a car";
        System.out.println(isPalindrome(input) ? "palindrome!" : "not palindrome");
    }
}
