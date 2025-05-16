/*Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0. */
package Questions.Array_String;

//book solution
public class Q8 {
    public static void main(String[] args){
        int[][] myMatrix = {
                {1,2,0},
                {9,5,8},
                {0,9,5}
        };
        System.out.println("Your matrix");
        showMatrix(myMatrix);

        System.out.println("Zero matrix");
        zeroMatrix(myMatrix);
        showMatrix(myMatrix);
    }
    public static void zeroMatrix(int[][] myMatrix){
        int row = myMatrix.length;
        int cols = myMatrix[0].length;

       boolean[] rowFlag = new boolean[row];
       boolean[] colFlag = new boolean[cols];

       //found zeros
       for ( int i = 0 ; i < row;i++){
           for ( int j = 0 ; j < cols;j++){
               if (myMatrix[i][j]==0){
                   rowFlag[i] = true;
                   colFlag[j] = true;
               }
           }
       }

       //zero the row
       for(int i = 0 ; i < row ;i++){
           if (rowFlag[i]) {
               for(int j = 0 ; j < cols ;j++){
                myMatrix[i][j]=0;
               }
           }
       }

       //zero the column
        for(int j = 0 ; j < cols;j++){
            if (colFlag[j]) {
              {for(int i = 0; i < row ; i++)
                    myMatrix[i][j]=0;
                }
            }
        }
    }

    public static void showMatrix(int[][] myMatrix){
        for (int[] row : myMatrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
//public class Q8 {
//    public static void main(String[] args){
//        int[][] myMatrix = {
//                {1,2,0},
//                {3,9,5}
//        };
//        System.out.println("Your matrix");
//        showMatrix(myMatrix);
//
//        for(int[] row: myMatrix){
//            int present = 0;
//            for(int element : row){
//                if (element==0){
//                    present++;
//                }
//                if(present<0){//will always be true bcoz u have intialised it to 0
//                    return;
//                }
//            }
//        }
//        System.out.println("Zero matrix");
//        zeroMatrix(myMatrix);
//        showMatrix(myMatrix);
//    }
//    public static void zeroMatrix(int[][] myMatrix){
//        int U = myMatrix.length;
//        int row = 0;
//        int column = 0;
//
//    //retrive the row and column number
//        for ( int i = 0 ; i <= U-1 ; i ++){
//            for (int j = i ; j <= U ; j++){
//                if(myMatrix[i][j]==0){
//                    row = i ;
//                    column = j ;
//              }
//            }
//        }
////will only check for last zero if multiple zero are present then it breaks
//        for ( int i = 0 ; i <= U-1 ; i ++){
//            for (int j = i ; j <= U ; j++){
//                myMatrix[i][column]=0;
//                myMatrix[row][j]=0;
//            }
//        }
//
//    }
//    public static void showMatrix(int[][] myMatrix){
//        for (int[] row : myMatrix) {
//            for (int element : row) {
//                System.out.print(element + " ");
//            }
//            System.out.println();
//        }
//    }
//}
