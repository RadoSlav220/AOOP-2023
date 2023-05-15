import java.util.Random;

public class SquareMatrixTest {
    public static void main(String[] args) {
        Random generator = new Random();

        //Generate dimension
        int dimension = generator.nextInt(11) + 2;

        //Generate matrix
        int[][] matrix = new int[dimension][];
        for (int i=0; i<matrix.length; ++i){
            matrix[i] = new int[dimension];
            for (int j=0; j<matrix[i].length; ++j){
                matrix[i][j] = generator.nextInt(9);
            }
        }

        SquareMatrix squareMatrix = new SquareMatrix(matrix);
        System.out.println(squareMatrix);
        squareMatrix.printAll();
    }
}