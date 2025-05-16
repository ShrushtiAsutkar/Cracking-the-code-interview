package Questions.Array_String;


/*Check Permutation: Given two strings, write a method to decide if one is a permutation of the
other*/
public class Q2 {
    public static void main(String[] args){
        StringBuilder stringBuilder = new StringBuilder();
        String str1 = "tah";
        String str2 = "aht";

        System.out.println("Permutation?"+checkIfPurmutation(str1,str2));
    }

    public static boolean checkIfPurmutation(String str1,String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }


        char[] charArray = new char[256];//ASCII value
        //charArray[256]= {0,0,0,0...}

        //increase value at each character in string1
        for(char c : str1.toCharArray()){
            charArray[c]++;  //charArray[a] a = ASCII integer value when used as an array index.
                                //[P,A,T,H] [0,1,1,1] FOR HAT
        }

        for(char c : str2.toCharArray()){
            charArray[c]--;   //[-1,0,0,1] FOR PAT
            if(charArray[c] < 0){
                return false;

            }
        }

        return true;
    }
}

