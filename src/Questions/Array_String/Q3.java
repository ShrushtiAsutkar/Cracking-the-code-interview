/*URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: If implementing in Java, please use a character array so that you can
perform this operation in place.)
Input: "Mr John Smith    ",13
Output: "Mr%20John%20Smith"
*/

package Questions.Array_String;

public class Q3 {

    public static void main(String[] args){
        String str = "Mr John Smith    ";
        int validLength = 13;
        replaceSpace(str,validLength);
    }

    public static void replaceSpace(String str,int validLength){
        char[] charArray = str.toCharArray();
        int spaceCount = 0 ;

        //add space in array for %20 - 3 different character
        for (int i = validLength-1; i>0;i--){
            if (charArray[i] == ' '){
                spaceCount++;}
        }
        System.out.println("Number of space: "+ spaceCount);
        int newArraySize = validLength + (spaceCount*2); //13 + 4 = 17
        for (int i = validLength-1; i>=0;i--){
            if (charArray[i] == ' '){
                    charArray[newArraySize - 1] = '0';
                    charArray[newArraySize - 2] = '2';
                    charArray[newArraySize - 3] = '%';
                    newArraySize-=3;
            }
            else{
                charArray[newArraySize-1] = charArray[i];
                newArraySize--;
            }
        }


//        for(char x : charArray){
//            System.out.print(x);
//        }

        System.out.println(new String(charArray)); // Print final result
    }

}
