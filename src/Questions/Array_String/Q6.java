/*String Compression: Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z)*/
package Questions.Array_String;

public class Q6 {
    public static void main(String[] args){
        String str = "aabbaaaa";

        System.out.println(compressedString(str));
    }

    public static String compressedString(String str){
        StringBuilder compressedString = new StringBuilder();
        int count = 0 ;

//        for (int i = 0 ; i < str.length();i++){
//            for (int j = i ; j < str.length();j++){
//                if (str.charAt(i)==str.charAt(j)){
//                    count++;
//
//                }else {
//                    i = j ;
//                    System.out.println(count);
//                    count = 0;
//                    if (str.charAt(i)==str.charAt(j)){
//                        count++;
//                    }
//                }
//
//            }
//
//        }

        for (int i = 0 ; i < str.length();i++){
            count++;

            if ( i+1 >= str.length() || str.charAt(i)!=str.charAt(i+1)){
                compressedString.append(str.charAt(i)).append(count) ;
                count=0;
            }
        }
//        return compressedString.toString();
        return compressedString.length() < str.length() ? compressedString.toString() : str;
    }

}
