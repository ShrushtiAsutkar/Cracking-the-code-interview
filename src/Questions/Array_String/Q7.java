/*Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. Can you do this in place? */
package Questions.Array_String;

public class Q7 {
    public static void main(String[] args){
        char[][] myMatrix = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'}

        };

        System.out.println("before swap");
        showMatrix(myMatrix);
        for(int row = 0 ; row < myMatrix.length ;row++) {
            if (myMatrix[row].length!= myMatrix.length){
                System.out.println("cant swap its not nXn");
                return;
            }
        }

        rotateMatrix(myMatrix);

        System.out.println("after swap");
        showMatrix(myMatrix);
    }

    public static void rotateMatrix(char[][] myMatrix){

        int Y = myMatrix.length;

        for ( int layer = 0 ; layer < Y/2; layer++ ) //one row amongst the matrix
        {
            int first = layer; //starting index of current layer
            int last = Y - 1 - layer; //last index of current layer
            for (int i = first; i < last; i++)//fist 3 characters in row
                 {
                     int offset = i - first;

                     char temp = myMatrix[first][i]; //a
                     //bottom left -- top left g -- a
                     myMatrix[first][i] = myMatrix[last-offset][first];
                     //bottom right -- bottom left i --g
                     myMatrix[last-offset][first] = myMatrix[last][last-offset];
                     //top right -- bottom right c--i
                     myMatrix[last] [last-offset]= myMatrix[i][last];
                     //top -- top right a---c
                     myMatrix[i][last] = temp;

                 }
        }
    }

    public static void showMatrix(char[][] myMatrix) {
        for (char[] row : myMatrix) {
            for (char element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
