package com.example.medicinesubsitutes;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

class HerbRecommend extends AppCompatActivity implements View.OnClickListener
{

    private TextView questionTextView;
    private Button yesButton;
    private Button noButton;
    private TextView recommendedHerbTextView;

    private String[] questions = {"Do you have a fever?", "Do you have a headache?", "Do you have a cough?"};
    private String[] recommendations = {"Elderflowers", "Butterbur", "Fermented onions covered in honey syrup (natural remedy)"};

    private int currentQuestionIndex = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTextView = findViewById(R.id.questionTextView);
        yesButton = findViewById(R.id.yesButton);
        noButton = findViewById(R.id.noButton);
        recommendedHerbTextView = findViewById(R.id.recommendedHerbTextView);
        yesButton.setOnClickListener((View.OnClickListener) this);
        noButton.setOnClickListener((View.OnClickListener) this);

        // Display the first question and wats being queued later so multiple questions
        showQuestion(currentQuestionIndex);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.yesButton:
                handleResponse(true);
                break;
            case R.id.noButton:
                handleResponse(false);
                break;
        }
    }

    private void showQuestion(int index)
    {
        questionTextView.setText(questions[index]);
    }

    private void handleResponse(boolean isYes)
    {
        if (isYes)
        {
            // "Yes" response
        } else
        {
            // "No" response
        }

        currentQuestionIndex++;

        if (currentQuestionIndex < questions.length)
        {
            // this will display the next question
            showQuestion(currentQuestionIndex);
        } else {
            // this will calculate and display the recommended herb
            String recommendedHerb = calculateRecommendedHerb();
            displayRecommendedHerb(recommendedHerb);
        }
    }

    private String calculateRecommendedHerb()
    {

        return recommendations[0]; // Return the first recommendation holder
    }

    private void displayRecommendedHerb(String herb)
    {
        recommendedHerbTextView.setText("Recommended Herb: " + herb);
        recommendedHerbTextView.setVisibility(View.VISIBLE);
    }
}

