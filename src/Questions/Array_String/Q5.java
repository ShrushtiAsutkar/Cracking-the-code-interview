/*One Away: There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
 EXAMPLE
pale, ple -> true
pales, pale -> true
pale, bale -> true
pale, bake -> false
If the two strings can be made identical with at most one edit, return true. Otherwise, return false.
*/

package Questions.Array_String;
//first solution
//public class Q5 {
//
//    public static void main(String[] args){
//        String base = "pale";
//        String child = "pa";
//        System.out.println("base: " + base + " child: " + child + "\ncan be made identical with at most one edit? "+checkEdit(base,child));
//    }
//    public static boolean checkEdit(String base ,String child){
//        boolean oneOrZeroEditAway = false;
//        int difference = base.length() - child.length();
//
//        //removed?
//        if(difference == 1 ){
//            System.out.println("Removed");
//            oneOrZeroEditAway = true;
//        }
//        else if (difference == -1 ) {
//            System.out.println("Inserted");
//            oneOrZeroEditAway = true ;
//        } else if (difference==0) {
//            oneOrZeroEditAway = checkReplaced(base,child);
//        }
//        else {
//            System.out.println("invalid");
//        }
//        return oneOrZeroEditAway;
//    }
//
//    public static boolean checkReplaced(String base,String child){
//        int[] array = new int[256];
//        int replaced = 0;
//        boolean oneOrZeroEditAway = false ;
//        for (char c : base.toCharArray()){
//            array[c]++;
//        }
//        for(char c : child.toCharArray()) {
//            array[c]--;
//            if (array[c] == -1) {
//                replaced++;
//                if (replaced > 1) {
//                    oneOrZeroEditAway = false;
//                    break;
//                } else {
//                    oneOrZeroEditAway = true;
//                }
//            }
//        }
//        return oneOrZeroEditAway;
//    }
//}


//2nd solution
/*make separate methods
check how many character were inserted or removed
 */

public class Q5 {

    public static void main(String[] args){
        String base = "pale";
        String child = "pale";
        System.out.println("base: " + base + " child: " + child + "\ncan be made identical with at most one edit? "+checkEdit(base,child));
    }
    public static boolean checkEdit(String base ,String child){
//        boolean oneOrZeroEditAway = false;
        int difference = base.length() - child.length();

        //removed?
        if(difference == 1 || difference == -1  ){ return checkRemoveOrInset(base,child); }
        else if (difference == 0) { return checkReplaced(base,child); }
        else if (base.equals(child)){return true; }
        return false;
    }

    public static boolean checkRemoveOrInset(String base, String child) {
        int foundDifference = 0;
        int i =0;
        int j = 0;

        while(i < base.length() && j < child.length()) {
            if (base.charAt(i) != child.charAt(j)) {
                foundDifference++;
                if(base.length()> child.length()) i++;
                else j++;
            }
                else{
                    i++;
                    j++;
                }
                if (foundDifference > 1) {
                    return false;
                }
        }
        return true;
    }

    public static boolean checkReplaced(String base, String child) {
        int replaced = 0;
        for (int i = 0; i < base.length(); i++) {
            if (base.charAt(i) != child.charAt(i)) {
                replaced++;
                if (replaced > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}