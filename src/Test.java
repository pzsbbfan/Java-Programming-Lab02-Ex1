import javax.swing.*;
import java.util.Random;

public class Test {

    //declare multiple arrays for use in the functions
    private String questions[] = new String[5];

    private String promptAnswers[] = new String[5];

    public String correctAnswers[] = new String[5];

    public String userAnswers[] = new String[5];

    //counter for loop
    public int counter = 0;

    //counter for correct and incorrect answers
    private int correct = 0;
    private int incorrect = 0;
    public Test(){
        //initializing the arrays
        questions[0] = "What is my name?";
        questions[1] = "What is my hobby?";
        questions[2] = "where do I live?";
        questions[3] = "What program am I taking?";
        questions[4] = "What is my cat's name?";

        promptAnswers[0] = "A. Lucas  B. Evelyn C. Jack  D. Tom";
        promptAnswers[1] = "A. Basketball  B. League Of Legend C. Soccer  D. Sleep";
        promptAnswers[2] = "A. Scarborough  B. Bradford C. Downtown  D. New Market";
        promptAnswers[3] = "A. SET  B. Business C. Painting  D. Cooking";
        promptAnswers[4] = "A. Pipi  B. Cici C. Fifi  D. Nini";

        correctAnswers[0] = "A";
        correctAnswers[1] = "C";
        correctAnswers[2] = "B";
        correctAnswers[3] = "A";
        correctAnswers[4] = "A";
    }


    //main function in this class to connect all other functions
    public void simulateQuestion(){
        while (counter < 5){
            inputAnswer();
            generateMessage();
        }
        JOptionPane.showMessageDialog(null,"Correct Answers: " + correct + " Incorrect" +
                " Answers: " + incorrect + " Total: " + String.format("%.2f",(double)correct/(double)(incorrect+correct) * 100)+"%");
    }

    // function use to display Joptionpanel to prompt user input
    public void inputAnswer(){
        userAnswers[counter] = JOptionPane.showInputDialog(questions[counter] +
                "\n " + promptAnswers[counter]);
    }

    //checks if the user input matches the correct answer
    public boolean checkAnswer(){
        return userAnswers[counter].toUpperCase().equals(correctAnswers[counter].toUpperCase());
    }

    //base on checkAnswer() to display different messages
    public void generateMessage(){
        Random random = new Random();
        String message = "";

        //if true loop will keep going
        if (checkAnswer()){
            counter++;
            correct++;
            switch (random.nextInt(4)) {
                case 0 -> message = "Excellent!";
                case 1 -> message = "Very good!";
                case 2 -> message = "Nice work!";
                case 3 -> message = "Fantastic!";
            }
        }

        //if false loop with repeat the same iteration with adding one to incorrect counter
        else {
            incorrect++;
            message = switch (random.nextInt(4)) {
                case 0 -> "Please Try Again!";
                case 1 -> "Try once more!";
                case 2 -> "Don't give up!";
                case 3 -> "Keep Trying!";
                default -> message;
            };
        }
        // display message
        JOptionPane.showMessageDialog(null,message);
    }

}