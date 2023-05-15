import java.text.NumberFormat;
import java.util.SplittableRandom;

public class Problem3 {
    //Generates a random integer in [1,3] with the following probability:
    //P(1) = 0.2
    //P(2) = 0.3
    //P(3) = 0.5
    private static int drawRandomNumber(){
        SplittableRandom random = new SplittableRandom();
        int num = random.nextInt(1, 11);

        if (num <= 2) return 1;
        else if (num <= 5) return 2;
        else return 3;
    }

    private static void makeExperiment(int attempts){
        int numberOf1s = 0;
        int numberOf2s = 0;
        int numberOf3s = 0;

        for (int i=0; i<attempts; ++i){
            int number = drawRandomNumber();

            if (number == 1) ++numberOf1s;
            else if (number == 2) ++numberOf2s;
            else if (number == 3) ++numberOf3s;
        }

        double probability1 = (double)numberOf1s / attempts;
        double probability2 = (double)numberOf2s / attempts;
        double probability3 = (double)numberOf3s / attempts;

        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMinimumFractionDigits(2);
        System.out.println("Experiment with " + attempts + " attempts:");
        System.out.println("Probability for 1: " + percentFormat.format(probability1));
        System.out.println("Probability for 2: " + percentFormat.format(probability2));
        System.out.println("Probability for 3: " + percentFormat.format(probability3));
    }

    public static void main(String[] args) {
        makeExperiment(10000);
        makeExperiment(60000);
    }
}