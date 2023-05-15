public class Main {

    public static boolean property1 (int number){
        return (number / 10000 >= 1) && (number / 10000 <= 6);
    }

    public static boolean property2 (int number){
        return (number / 1000 % 10 >= 4) && (number / 1000 % 10 <= 8);
    }

    public static boolean property3 (int number){
        return (number / 100 % 10 >= 3) && (number / 100 % 10) <= 7;
    }

    public static boolean property4 (int number){
        return (number / 10 % 10) != 0; //equivalent to "is in [1, 9]"
    }

    public static boolean property5 (int number){
        return (number % 10 >= 1) && (number % 10) <= 8;
    }

    //Checks if a given 5-digit number meets the requirements.
    public static boolean checkRequirements(int number){
        return property1(number) && property2(number) && property3(number) &&
                property4(number) && property5(number);
    }

    //Solved the problem in the easiest way.
    public static void main(String[] args) {
        int totalCount = 0;
        int countOfSearchedNumbers = 0;
        int allDividableNumbers = 0;

        for (int i=10000; i<100000; ++i){
            if (checkRequirements(i)){
                ++totalCount;
                if (i % 12 == 0){
                    ++countOfSearchedNumbers;
                }
            }

            if (i % 12 == 0){
                ++allDividableNumbers;
            }
        }

        //We calculate classic probability. Good cases divided by all cases.
        double probability = (double)countOfSearchedNumbers / totalCount;

        String result = String.format(
           """
           All numbers with the properties: %d
           All dividable by 12 numbers: %d
           Numbers with the properties and dividable by 12: %d
           Probability of picking a dividable by 12 number: %.2f%%
           """, totalCount, allDividableNumbers, countOfSearchedNumbers, probability);

        System.out.print(result);
    }
}