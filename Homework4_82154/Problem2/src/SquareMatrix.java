public class SquareMatrix {
    private int[][] dataArray;

    public SquareMatrix(){
        this(new int[][]{{1,2,3}, {1,2,3}, {1,2,3}});
    }

    public SquareMatrix(int[][] dataArray) {
        setDataArray(dataArray);
    }

    public SquareMatrix(SquareMatrix other){
        setDataArray(other.dataArray);
    }

    public int[][] getDataArray() {
        return dataArray;
    }

    public void setDataArray(int[][] dataArray) {
        if (dataArray != null){
            this.dataArray = dataArray;
        }
        else {
            this.dataArray = new int[][]{{1,2,3}, {1,2,3}, {1,2,3}};
        }
    }

    //startRow and startCol must be valid indexes
    private int calculateSumSubmatrix(int startRow, int startCol){
        return dataArray[startRow][startCol] +
                dataArray[startRow][startCol+1] +
                dataArray[startRow+1][startCol] +
                dataArray[startRow+1][startCol+1];
    }

    public int findMaxSum(){
        int maxSum = Integer.MIN_VALUE;
        for (int startRow = 0; startRow < dataArray.length-1; ++startRow){
            for (int startCol = 0; startCol < dataArray[startRow].length-1; ++startCol){
                int sumSubmatrix = calculateSumSubmatrix(startRow, startCol);
                if (sumSubmatrix > maxSum){
                    maxSum = sumSubmatrix;
                }
            }
        }
        return maxSum;
    }

    public void printAll(){
        int maxSum = findMaxSum();
        if (maxSum == Integer.MIN_VALUE){
            return;
        }
        System.out.println("Maximum sum of 2x2 submatrix: " + maxSum);
        System.out.println("Submatrices with Maximum sum:");
        for (int startRow = 0; startRow < dataArray.length-1; ++startRow){
            for (int startCol = 0; startCol < dataArray[startRow].length-1; ++startCol){
                int sumSubmatrix = calculateSumSubmatrix(startRow, startCol);
                if (sumSubmatrix == maxSum){
                    System.out.printf("[%d, %d]\n", startRow, startCol);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int[] row : dataArray) {
            for (int i : row) {
                result.append(i + " ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
