package com.example.akinade.civilrightsmovementquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    //Declaring score as a global variable
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Grading button
     */
    public void gradeButton(View v) {

        //Get reply for question 1
        RadioGroup question1 = findViewById(R.id.radioQuestion1);
        int answer1 = question1.getCheckedRadioButtonId();

        //Get reply for question 2
        RadioGroup question2 = findViewById(R.id.radioQuestion2);
        int answer2 = question2.getCheckedRadioButtonId();

        //Get reply for question 3
        RadioGroup question3 = findViewById(R.id.radioQuestion3);
        int answer3 = question3.getCheckedRadioButtonId();

        //Get reply for question 4
        RadioGroup question4 = findViewById(R.id.radioQuestion4);
        int answer4 = question4.getCheckedRadioButtonId();

        //Get reply for question 5
        RadioGroup question5 = findViewById(R.id.radioQuestion5);
        int answer5 = question5.getCheckedRadioButtonId();

        //Get reply for question 6
        RadioGroup question6 = findViewById(R.id.radioQuestion6);
        int answer6 = question6.getCheckedRadioButtonId();

        //Get reply for question 7
        RadioGroup question7 = findViewById(R.id.radioQuestion7);
        int answer7 = question7.getCheckedRadioButtonId();

        //Get reply for question 8
        RadioGroup question8 = findViewById(R.id.radioQuestion8);
        int answer8 = question8.getCheckedRadioButtonId();

        //Get reply for question 9
        CheckBox question9 = findViewById(R.id.CrowtherBailey);
        String option9_a = question9.getText().toString();
        CheckBox question9_b = findViewById(R.id.HueyNewton);
        String option9_b = question9_b.getText().toString();
        CheckBox question9_c = findViewById(R.id.BobbySeale);
        String option9_c = question9_c.getText().toString();

        //Get reply for question 10
        EditText question10 = findViewById(R.id.question10);
        String answer10 = question10.getText().toString();


        /*
         * Compare user input with correct answers
         *
         *  -1 as the value of "unselected" RadioGroup. That, I discovered serendipitously and from Commonsense
         * i.e IDs are usually unique, so if RadioGroup 1 has children 1,2,3; then RadioGroup 2 most likely should have its children as 4,5,6.
         * Each of them can not be 1,2,3 , or there won't be uniqueness
         */
        if (answer1 != -1 && answer2 != -1 && answer3 != -1 && answer4 != -1 && answer5 != -1 && answer6 != -1 && answer7 != -1 && answer8 != -1 &&
                option9_a.length() > 0 && option9_b.length() > 0 && option9_c.length() > 0 && question10.getText().toString().length() > 0) {
            if (answer1 == 3) {
                score += 1;
            }
            if (answer2 == 5) {
                score += 1;
            }
            if (answer3 == 9) {
                score += 1;
            }
            if (answer4 == 10) {
                score += 1;
            }
            if (answer5 == 14) {
                score += 1;
            }
            if (answer6 == 16) {
                score += 1;
            }
            if (answer7 == 19) {
                score += 1;
            }
            if (answer8 == 23) {
                score += 1;
            }
            if (question9_b.isChecked() && question9_c.isChecked()) {
                if (question9.isChecked()) score -= 1;
                score += 1;
            }
            if (answer10.equalsIgnoreCase("Harriet Tubman")) {
                score += 1;
            }
            int finalPercentage = score * 10;
            String grading = "Thank you for taking this test, your score is: " + finalPercentage + "% " + gradeComment(finalPercentage);
            Toast.makeText(this, grading, LENGTH_LONG).show();

            //Reinitialize the score so that any other alteration in the answer is taken as a new test
            // and not an increment on the previous test
            score = 0;

        } else {
            Toast.makeText(this, "There are missing items, check through, fill them, and click \'Grade me\' again.", LENGTH_LONG).show();
        }
        }

    /*
     *Grades the user using their percentage 50 and above is pass mark, anything below?...We know who skipped history class.
     * @param grade
     */
    public String gradeComment(int grade) {
        String comment;
        if (grade <= 49) {
            comment = "Sorry, you failed the quiz! Do try again.";
        } else {
            comment = "You passed! Congratulations!!!";
        }
        return comment;
    }

    public void reset(View v) {

        RadioGroup question1 = findViewById(R.id.radioQuestion1);

        //Get reply for question 2
        RadioGroup question2 = findViewById(R.id.radioQuestion2);

        //Get reply for question 3
        RadioGroup question3 = findViewById(R.id.radioQuestion3);

        //Get reply for question 4
        RadioGroup question4 = findViewById(R.id.radioQuestion4);

        //Get reply for question 5
        RadioGroup question5 = findViewById(R.id.radioQuestion5);

        //Get reply for question 6
        RadioGroup question6 = findViewById(R.id.radioQuestion6);

        //Get reply for question 7
        RadioGroup question7 = findViewById(R.id.radioQuestion7);

        //Get reply for question 8
        RadioGroup question8 = findViewById(R.id.radioQuestion8);

        //Get reply for question 9
        CheckBox question9 = findViewById(R.id.CrowtherBailey);
        CheckBox question9_a = findViewById(R.id.HueyNewton);
        CheckBox question9_b = findViewById(R.id.BobbySeale);

        //Get reply for question 10
        EditText question10 = findViewById(R.id.question10);
        String answer10 = question10.getText().toString();

        //Resets score to zero
        score = 0;

        //Unchecks all checked RadioButtons and clears all other items on the quiz
        question1.clearCheck();
        question2.clearCheck();
        question3.clearCheck();
        question4.clearCheck();
        question5.clearCheck();
        question6.clearCheck();
        question7.clearCheck();
        question8.clearCheck();
        question9.setChecked(false);
        question9_a.setChecked(false);
        question9_b.setChecked(false);
        question10.setText("");
    }
}