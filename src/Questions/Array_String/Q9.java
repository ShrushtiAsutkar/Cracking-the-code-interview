package Questions.Array_String;

public class Q9 {
    public static void main(String[] args){
        String x = "wat";
        String y = "erbottle";
       // String z = "erbottly";
        String s1 = x+y;
        String s2 = y+x;
      //  String s2 = z+x;

        if(isRotate(s1,s2)){
            System.out.println("substring");
        }else {
            System.out.println("not a substring");
        }
    }

    public static boolean isRotate(String s1,String s2){
        if(s1.length()!=s2.length()){
          return false;
        }
        s1 = s1+s1;
       return isSubString(s1,s2);
    }
//    public static boolean isSubString(String s1,String s2){
//       if(s1.contains(s2)){
//        return true;
//       }else {
//            return false;
//       }
//    }

    public static boolean isSubString(String s1,String s2){
        return s1.contains(s2);
    }
}
