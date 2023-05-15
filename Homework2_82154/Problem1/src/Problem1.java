import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.Scanner;

public class Problem1 extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    private static int getInputValue(String valueName, int lowerLimit, int upperLimit){
        TextInputDialog inputDialog = new TextInputDialog();
        inputDialog.setTitle("Welcome");
        inputDialog.setHeaderText("Enter the number of a " + valueName);
        inputDialog.setContentText("" + valueName + ":");

        int value = -1;
        do {
           try {
               value = Integer.parseInt(inputDialog.showAndWait().get());
           } catch (Exception e){
               value = -1;
           }
           if (value < lowerLimit || value > upperLimit){
               inputDialog.setHeaderText("Invalid input, please try again. Enter the number of a " + valueName);
           }
        } while (value < lowerLimit || value > upperLimit);

        return value;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 350, 200);

        int month = getInputValue("Month", 1, 12);
        int year = getInputValue("Year", 1, 99999);

        double limitsOffset = scene.getWidth() / 11;
        double wordsHorizontalOffset = 40;
        double wordsVerticalOffset = 20;

        String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        for (int i=0; i<days.length; ++i){
            group.getChildren().add(new Text(limitsOffset + i * wordsHorizontalOffset,
                                                limitsOffset,
                                                days[i]));
        }

        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate currDate = LocalDate.now();

        int dayOfWeek = startDate.getDayOfWeek().getValue() - 1;
        int weekNumber = 1;
        for (int i=0; i < startDate.lengthOfMonth(); ++i){
            Text day = new Text(limitsOffset + dayOfWeek * wordsHorizontalOffset,
                                limitsOffset + weekNumber * wordsVerticalOffset,
                                    Integer.toString(i+1));
            if (currDate.getYear() == year && currDate.getMonth().getValue() == month && currDate.getDayOfMonth() == i + 1){
                day.setStroke(Color.RED);
            }
            group.getChildren().add(day);
            if (dayOfWeek == 6) ++weekNumber;
            dayOfWeek = (dayOfWeek + 1) % 7;
        }

        stage.setTitle("Calendar for " + startDate.getMonth() + " " + year);
        stage.setScene(scene);
        stage.show();
    }
}