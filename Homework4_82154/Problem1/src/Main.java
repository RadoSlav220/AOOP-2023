import java.util.Scanner;

public class Main {
    private static char[] convertToBinary(byte number){
        char[] result = new char[8];
        for (int i=7; i>=0; --i){
            result[i] = (char) ('0' + number % 2);
            number = (byte) (number / 2);
        }
        return result;
    }

    private static String printCharArray(char[] arr){
        StringBuilder result = new StringBuilder();
        for (char c : arr) {
            result.append(c);
        }
        return result.toString();
    }

    //Works correctly only with arrays with equal length
    private static int hammingDistance(char[] num1, char[] num2){
        int distance = 0;
        for (int i=0; i<num1.length; ++i){
            if (num1[i] != num2[i]){
                ++distance;
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte num1, num2;
        num1 = input.nextByte();
        num2 = input.nextByte();

        char[] binaryNum1 = convertToBinary(num1);
        char[] binaryNum2 = convertToBinary(num2);

        System.out.println("First number in binary:  " + printCharArray(binaryNum1));
        System.out.println("Second number in binary: " + printCharArray(binaryNum2));
        System.out.println("The Hamming distance is: " + hammingDistance(binaryNum1, binaryNum2));
    }
}