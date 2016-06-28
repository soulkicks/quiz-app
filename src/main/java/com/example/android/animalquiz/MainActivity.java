package com.example.android.animalquiz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void review(View view) {
        score = 0;

        EditText questionOne = (EditText) findViewById(R.id.answer_one);
        String answerOne = questionOne.getText().toString();

        if(answerOne.equalsIgnoreCase("cheetah"))
        {
            score = score + 1;
        }

        EditText questionTwo = (EditText) findViewById(R.id.answer_two);
        String answerTwo = questionTwo.getText().toString();

        if(answerTwo.equalsIgnoreCase("sailfish"))
        {
            score = score + 1;
        }

        //checks answer for question 3
        CheckBox sharkCheckBox = (CheckBox)findViewById(R.id.shark_checkbox);
        CheckBox seagullCheckBox = (CheckBox)findViewById(R.id.seagull_checkbox);
        CheckBox whaleCheckBox = (CheckBox)findViewById(R.id.whale_checkbox);
        CheckBox chimpCheckBox = (CheckBox)findViewById(R.id.chimp_checkbox);

        int questionThree = 0;

        if((sharkCheckBox.isEnabled()) && (whaleCheckBox.isEnabled()) )
        {
            questionThree = questionThree + 2;
        }

        if((seagullCheckBox.isEnabled()) || (chimpCheckBox.isEnabled()))
        {
            questionThree = questionThree - 1;
        }

        //Log.v("MainActivity", Integer.toString(questionThree));

        if(questionThree >= 2)
        {
            score = score + 1;
        }

        //checks answer for question 4
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio);
        // get selected radio button from radioGroup
        int selectedId = radioGroup.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        RadioButton radioButton = (RadioButton) findViewById(selectedId);
        String answerFour = (String) radioButton.getText();

        if(answerFour.equalsIgnoreCase("No"))
        {
            score = score + 1;
        }

        Context context = getApplicationContext();
        CharSequence text = "You got " + score + " right!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
