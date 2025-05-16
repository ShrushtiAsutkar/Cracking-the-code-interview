package Questions.Array_String;


//Q1: Implement an algorithm to determine if a string has all unique characters. What if you
//cannot use additional data structures?

//implementing hashSet
//public class Q1{
//    public static void main(String[] args){
//        HashSet<Character> alreadyPrinted = new HashSet<>();
//        HashSet<Character> checking = new HashSet<>();
//        String str = "abc"; boolean hasDuplicate = false;
//
//        for(char c : str.toCharArray()){
//            if(checking.contains(c) && !alreadyPrinted.contains(c)){
//                System.out.println("Duplicate "+c);
//                alreadyPrinted.add(c);
//                hasDuplicate = true ;
//            }
//            checking.add(c);
//        }
//        if (!hasDuplicate){
//            System.out.println("unique string");
//        }
//
//    }
//}
//2nd solution - not printed twice a duplicate letter
//public class Q1 {
//    public static void main (String[] args) {
//        String str = "abccca";
//        findDuplicate(str);
//
//    }
//
//    public static void findDuplicate(String str){
//
//        boolean isUnique = true ;
//
//
//        for(int i = 0  ; i < str.length() ; i++){
//            boolean alreadyPrinted = false;
//            //checking if duplicate letter is being iterated again
//           for(int j = 0 ; j < i ; j++){
//               if(str.charAt(j)==str.charAt(i)){
//                   alreadyPrinted = true ;
//                   break;
//               }
//           }
//            if (!alreadyPrinted) {
//                    for(int j = i+1 ; j < str.length() ; j++){
//                        if(str.charAt(j)==str.charAt(i)){
//                            isUnique = false ;
//                            System.out.println("Duplicate: "+str.charAt(j));
//                            break;
//                    }
//                }
//            }
//        }
//
//        //check for duplicate
//
//        System.out.println(showResult(isUnique));
//
//    }
//    public static String showResult(boolean isUnique) {
//        String result ="";
//        if (isUnique) {
//             result ="String has all unique character";
//        } else {
//             result ="String does not have all unique character";
//        }
//        return result;
//    }
//}
//1stSoltuion
//public class Q1 {
//    public static void main (String[] args) {
//        String str = "abca";
//        int length = str.length();
//        char[] arr = new char[length];
//        boolean isUnique = true;
//
//        for (int i = 0; i < length; i++) {
//            char c = str.charAt(i);
//            arr[i] = c;
//        }
//
//        for (int i = 0; i < length; i++) {
//            //j = 0 wont wokr bcox u compare the same value
//            for (int j = i + 1; j < length; j++) {
//                if (arr[j] == arr[i]) {
//                    isUnique = false;
//                }
//            }
//        }
//
//        if(isUnique){
//            System.out.println("String has all unique character");
//        }
//        else {
//            System.out.println("Has duplicates: ");
//        }
//    }
//}


//PRACTCE: Given two strings, check if they share any common character.
//public class Q1{
//    public static void main(String[] args){
//        String str1 ="helloyv";
//        String str2 ="world";
//
//        HashSet<Character> str1Hash = new HashSet<>();
//        HashSet<Character> str2Hash = new HashSet<>();
//        HashSet<Character> common = new HashSet<>();
//
//        for(char x : str1.toCharArray()){
//            str1Hash.add(x);
//        }
//        for(char x : str2.toCharArray()){
//            str2Hash.add(x);
//        }
////        for(char x : str1.toCharArray()){
////            if(str1Hash.contains(x) && str2Hash.contains(x)){
////            common.add(x);
////            }
////        }
//        //or
//
//        for(char x : str2.toCharArray()){
//            if(!str1Hash.contains(x)){
//                common.add(x);
//            }
//        }
//
//        System.out.println(common);
//
//
//
//    }
//}

//
//public class Q1{
//    public static void main(String[] args){
//        String str ="hheell";
//        HashSet<Character> hashSet = new HashSet<>();
//      HashSet<Character> DuplicatehashSet = new HashSet<>();
//      int count = 0;
//
////        for(char x : str.toCharArray()){
////            if (hashSet.contains(x)){
////                DuplicatehashSet.add(x);
////                break;
////            }
////           hashSet.add(x);
////        }
//
//        for(char x : str.toCharArray()){
//            if (!hashSet.add(x)){
//                count++;
//                if(count==1){
//                DuplicatehashSet.add(x);
//                break;}
//            }
//            hashSet.add(x);
//        }
//        System.out.println(DuplicatehashSet);
//
//    }
//}