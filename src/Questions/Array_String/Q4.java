/*Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palin
drome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation
is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat", "atco eta", etc.)

if a given string can be rearranged (permuted) to form a palindrome.
*/
package Questions.Array_String;

public class Q4 {
    public static void main(String[] args){
        String str = "noon";
        System.out.println(str + " Can be a palindrome? "+checkIfPalindromeIsPossible(str));
    }

    public static boolean checkIfPalindromeIsPossible(String str) {
        int length = str.length();
        int[] carray = new int[26];
        str = str.toLowerCase().replace(" ", "");
        boolean isPalindrome = true;
        int oddCount = 0;

        //frequency of char
        for (char c : str.toCharArray()) {
            carray[c - 'a']++;
        }

        //checking is string can form a palindrome
//        if(length%2==0){
//            //even
//            for(int x :carray) {
//                if (x % 2 == 0) {
//                    isPalindrome = true;
//                } else {
//                    isPalindrome = false;
//                    break;
//                }
//            }
//        }
//        else{
//            for(int x :carray) {
//                if (x % 2 != 0) {
//                    oddCount++ ;
//                    if(oddCount == 1){
//                        isPalindrome = true;
//                    }
//                    if (oddCount > 1 ){
//                        isPalindrome = false;
//                        break;
//                    }
//
//                }
//            }
//        }

        //2nd solution
        //x is the freqeuncy
        for (int x : carray) {
            if (x % 2 != 0) {
                oddCount++;
                if (oddCount > 1) {
                    isPalindrome = false;
                    break;
                }
            }
        }

        for(char c : str.toCharArray()){
            if(c!=0) {System.out.println(carray[c -'a']+" -->"+c);}
        }
        return isPalindrome;
    }
}
