package com.example.alexandru.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Reset the score
     *
     * @param view
     */
    public void reset(View view) {
        score = 0;
    }

    /**
     * @param view
     */
    public void submitTest(View view) {

        checkQuestionRadioInputAnswer(1);
        checkTextAnswer(getString(R.string.q_2_answer));
        checkQuestionRadioInputAnswer(4);
        checkCheckBoxAnswer(Integer.parseInt(getString(R.string.q_3_number_of_answers)), 3);

        displayScore();
    }

    /**
     * Checks the answer for a question with a radio buttons
     *
     * @param questionNumber the number of the question
     */
    public void checkQuestionRadioInputAnswer(int questionNumber) {

        if (questionNumber == 1) {
            String correctAnswerQuestion1 = getString(R.string.q_1_answer);
            RadioButton radioButton = (RadioButton) findViewById(R.id.radio_q_1_answer_1);
            if (compareAnswerForRadioButtonInput(correctAnswerQuestion1, radioButton)) {
                score++;
                return;
            }
            radioButton = (RadioButton) findViewById(R.id.radio_q_1_answer_2);
            if (compareAnswerForRadioButtonInput(correctAnswerQuestion1, radioButton)) {
                score++;
                return;
            }

            radioButton = (RadioButton) findViewById(R.id.radio_q_1_answer_3);
            if (compareAnswerForRadioButtonInput(correctAnswerQuestion1, radioButton)) {
                score++;
                return;
            }

        }
        if (questionNumber == 4) {
            String correctAnswerQuestion4 = getString(R.string.q_4_answer);
            RadioButton radioButton = (RadioButton) findViewById(R.id.radio_q_2_answer_1);
            if (compareAnswerForRadioButtonInput(correctAnswerQuestion4, radioButton)) {
                score++;
                return;
            }
            radioButton = (RadioButton) findViewById(R.id.radio_q_2_answer_2);
            if (compareAnswerForRadioButtonInput(correctAnswerQuestion4, radioButton)) {
                score++;
                return;
            }
        }

    }

    /**
     * @param correctAnswer   the correct answer for a question
     * @param radioButtonTemp the radio button that has been checked  by the user
     * @return
     */

    public boolean compareAnswerForRadioButtonInput(String correctAnswer, RadioButton radioButtonTemp) {
        if (radioButtonTemp.isChecked()) {
            String answerQuestion = radioButtonTemp.getText().toString();
            if (correctAnswer.equalsIgnoreCase(answerQuestion)) {

                return true;
            }
        }
        return false;
    }

    /**
     * Checks the answer for a question with a Edit Text
     *
     * @param answer
     */

    public void checkTextAnswer(String answer) {
        EditText editText = (EditText) findViewById(R.id.edit_text_answer_1);
        if (editText.getText().toString().equalsIgnoreCase(answer)) score++;

    }

    /**
     * Checks the answer for a question with checkboxes
     *
     * @param numberOfCorrectAnswers
     * @param questionNumber
     */


    public void checkCheckBoxAnswer(int numberOfCorrectAnswers, int questionNumber) {

        if (questionNumber == 3) {
            int numberOfAnswers = 0;
            String correctAnswerQuestion = getString(R.string.q_3_answer_1);
            String correctAnswerQuestion2 = getString(R.string.q_3_answer_2);

            CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkbox_q_3_a_1);
            if (checkBox1.isChecked()) {
                if (compareAnswerForCheckBoxInput(correctAnswerQuestion, checkBox1) |
                        compareAnswerForCheckBoxInput(correctAnswerQuestion2, checkBox1)) {
                    numberOfAnswers++;
                }
            }
            checkBox1 = (CheckBox) findViewById(R.id.checkbox_q_3_a_2);
            if (checkBox1.isChecked()) {
                if (compareAnswerForCheckBoxInput(correctAnswerQuestion, checkBox1) |
                        compareAnswerForCheckBoxInput(correctAnswerQuestion2, checkBox1)) {
                    numberOfAnswers++;
                }
            }


            checkBox1 = (CheckBox) findViewById(R.id.checkbox_q_3_a_3);
            if (checkBox1.isChecked()) {
                if (compareAnswerForCheckBoxInput(correctAnswerQuestion, checkBox1) |
                        compareAnswerForCheckBoxInput(correctAnswerQuestion2, checkBox1)) {
                    numberOfAnswers++;
                }
            }

            checkBox1 = (CheckBox) findViewById(R.id.checkbox_q_3_a_4);
            if (checkBox1.isChecked()) {
                if (compareAnswerForCheckBoxInput(correctAnswerQuestion, checkBox1) |
                        compareAnswerForCheckBoxInput(correctAnswerQuestion2, checkBox1)) {
                    numberOfAnswers++;
                }
            }

            if (numberOfAnswers == numberOfCorrectAnswers) score++;
        }
    }

    public boolean compareAnswerForCheckBoxInput(String correctAnswer, CheckBox checkBoxTemp) {
        String answerQuestion = checkBoxTemp.getText().toString();
        if (correctAnswer.equalsIgnoreCase(answerQuestion)) {
            return true;
        }

        return false;
    }

    /**
     * Displays the score
     */
    private void displayScore() {

        Context context = getApplicationContext();

        int maxNumber = Integer.parseInt(getString(R.string.number_of_question));
        CharSequence text;
        if (maxNumber == score)
            text = "Your score is: " + score + " 100% correct";
        else text = "Your score is: " + score;

        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
