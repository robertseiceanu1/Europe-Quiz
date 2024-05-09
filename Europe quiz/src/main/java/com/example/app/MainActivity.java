package com.example.app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Question[] workingQuestions;
    Question[] easyCapitalsQuestions = new Question[]{
            new Question(R.drawable.amsterdam, 40f, 52.5f,"Amsterdam"),
            new Question(R.drawable.athens, 75.9f, 93.7f,"Athens"),
            new Question(R.drawable.berlin, 52.6f, 53.7f,"Berlin"),
            new Question(R.drawable.istanbul, 85.8f, 83.6f,"Istanbul"),
            new Question(R.drawable.london, 30.1f, 52.5f,"London"),
            new Question(R.drawable.moscow, 95.8f, 36.7f,"Moscow"),
            new Question(R.drawable.paris, 34.5f, 64.1f,"Paris"),
            new Question(R.drawable.rome, 50.7f, 83.6f,"Rome"),
    };
    Question[] mediumCapitalsQuestions = new Question[]{
            new Question(R.drawable.stockholm, 60.2f, 32.7f,"Stockholm"),
            new Question(R.drawable.copenhagen, 50.7f, 44.6f,"Copenhagen"),
            new Question(R.drawable.brussels, 37.6f, 56.2f,"Brussels"),
            new Question(R.drawable.lisbon, 4.0f, 83.6f,"Lisbon"),
            new Question(R.drawable.vienna, 58.3f, 66.3f,"Vienna"),
            new Question(R.drawable.madrid, 15.7f, 83.6f,"Madrid"),
            new Question(R.drawable.prague, 57.0f, 60.6f,"Prague"),
            new Question(R.drawable.budapest, 64.6f, 68.5f,"Budapest"),
    };
    Question[] hardCapitalsQuestions = new Question[]{
            new Question(R.drawable.warsaw, 64.6f, 53.7f,"Warsaw"),
            new Question(R.drawable.zagreb, 58.3f, 72,"Zagreb"),
            new Question(R.drawable.sofia, 75.9f, 79.8f,"Sofia"),
            new Question(R.drawable.belgrade, 68.3f, 75.7f,"Belgrade"),
            new Question(R.drawable.helsinki, 70.1f, 24.8f,"Helsinki"),
            new Question(R.drawable.bucharest, 78.2f, 74.2f,"Bucharest"),
            new Question(R.drawable.bern, 43.1f, 68.2f,"Bern"),
            new Question(R.drawable.kiev, 85.8f, 56.2f,"Kiev"),
    };
    Question[] easyFlagsQuestions = new Question[]{
            new Question(R.drawable.spain, 15.9f, 85.2f,"Spain"),
            new Question(R.drawable.france, 32.7f, 64.7f,"France"),
            new Question(R.drawable.uk, 28.7f, 49f,"UK"),
            new Question(R.drawable.portugal, 4f, 85.2f,"Portugal"),
            new Question(R.drawable.germany, 47.9f, 55f,"Germany"),
            new Question(R.drawable.italy, 50.7f, 81.4f,"Italy"),
            new Question(R.drawable.greece, 72.7f, 93f,"Greece"),
            new Question(R.drawable.russia, 95.8f, 38.6f,"Russia"),
    };
    Question[] mediumFlagsQuestions = new Question[]{
            new Question(R.drawable.sweden, 56.5f, 30.8f,"Sweden"),
            new Question(R.drawable.denmark, 47.9f, 41.1f,"Denmark"),
            new Question(R.drawable.belgium, 38.2f, 56.9f,"Belgium"),
            new Question(R.drawable.netherlands, 40.3f, 52.5f,"Netherlands"),
            new Question(R.drawable.czechia, 58.3f, 60.3f,"Czechia"),
            new Question(R.drawable.austria, 57.5f, 67.2f,"Austria"),
            new Question(R.drawable.ukraine, 89.2f, 56.9f,"Ukraine"),
            new Question(R.drawable.hungary, 65.1f, 69.4f,"Hungary"),
    };
    Question[] hardFlagsQuestions = new Question[]{
            new Question(R.drawable.andorra, 28.7f, 79.8f,"Andorra"),
            new Question(R.drawable.bosnia, 61.5f, 77.3f,"Bosnia"),
            new Question(R.drawable.kosovo, 69.1f, 81.4f,"Kosovo"),
            new Question(R.drawable.moldova, 83.7f, 66.9f,"Moldova"),
            new Question(R.drawable.slovakia, 64.1f, 63.8f,"Slovakia"),
            new Question(R.drawable.slovenia, 55.4f, 72f,"Slovenia"),
            new Question(R.drawable.liechtenstein, 45.8f, 69.4f,"Liechtenstein"),
            new Question(R.drawable.finland,71.7f,26.4f,"Finland")
    };
    Question[] easyMountainsQuestions = new Question[]{
            new Question(R.drawable.alps, 36.6f, 68.5f,"Alps"),
            new Question(R.drawable.balkan, 58.3f, 82f,"Balkan"),
            new Question(R.drawable.carpathians, 60.7f, 66.3f,"Carpathians"),
            new Question(R.drawable.caucasus, 95.8f, 79.8f,"Caucasus"),
            new Question(R.drawable.ural, 100.0f, 22.0f,"Ural"),
            new Question(R.drawable.scandinavian, 34.8f, 22.0f,"Scandinavian"),
    };
    Question[] mediumMountainsQuestions = new Question[]{
            new Question(R.drawable.pannonia, 50.7f, 68.5f,"Pannonia"),
            new Question(R.drawable.pyrenees, 15.4f, 79.8f,"Pyrenees"),
            new Question(R.drawable.sierra_nevada, 10.4f, 94.9f,"Sierra Nevada"),
            new Question(R.drawable.massif_central, 21.2f, 74.2f,"Massif Central"),
            new Question(R.drawable.iberian_plateau, 10.4f, 87.7f,"Iberian Plateau"),
            new Question(R.drawable.loire_valley, 15.4f, 68.5f,"Loire Valley"),
    };
    Question[] hardMountainsQuestions = new Question[]{
            new Question(R.drawable.scottish_highlands, 7.8f, 36.7f,"Scottish Highlands"),
            new Question(R.drawable.welsh, 10.4f, 50.6f,"Welsh"),
            new Question(R.drawable.cantabrian, 6f, 79.8f,"Cantabrian"),
            new Question(R.drawable.dinarics, 50.7f, 79.8f,"Dinarics"),
            new Question(R.drawable.harz, 36.6f, 58.4f,"Harz"),
            new Question(R.drawable.po_valley, 36.6f, 74.2f,"Po Valley"),
    };
    Question[] easyWaterwaysQuestions = new Question[]{
            new Question(R.drawable.adriatic, 50.7f, 81.1f,"Adriatic"),
            new Question(R.drawable.aegean, 70.4f, 93.0f,"Aegean"),
            new Question(R.drawable.baltic, 58.3f, 27.9f,"Baltic"),
            new Question(R.drawable.black_sea, 88.4f, 81.1f,"Black Sea"),
            new Question(R.drawable.danube, 56.5f, 70.7f,"Danube"),
            new Question(R.drawable.danube_delta, 76.1f, 73.5f,"Danube Delta"),
            new Question(R.drawable.english_channel, 18f, 59.1f,"English Channel"),
            new Question(R.drawable.north_sea, 27.4f, 35.8f,"North Sea"),
    };
    Question[] mediumWaterwaysQuestions = new Question[]{
            new Question(R.drawable.bay_of_biscay, 10.4f, 73.8f,"Bay of Biscay"),
            new Question(R.drawable.irish_sea, 8.3f, 48.1f,"Irish Sea"),
            new Question(R.drawable.ligurian, 37.4f, 81.1f,"Ligurian"),
            new Question(R.drawable.seine, 25.6f, 62.8f,"Seine"),
            new Question(R.drawable.themse, 19.8f, 51.8f,"Themse"),
            new Question(R.drawable.tyrrhenian, 45.0f, 93.0f,"Tyrrhenian"),
            new Question(R.drawable.rhine, 35.0f, 58.4f,"Rhine"),
            new Question(R.drawable.loire, 19.8f, 66.9f,"Loire"),
    };
    Question[] hardWaterwaysQuestions = new Question[]{
            new Question(R.drawable.constance, 39.5f, 66.9f,"Constance"),
            new Question(R.drawable.como, 37.4f, 73.2f,"Como"),
            new Question(R.drawable.dnieper, 80.8f, 56.9f,"Dnieper"),
            new Question(R.drawable.venetian_lagoon, 43.1f, 74.8f,"Venetian Lagoon"),
            new Question(R.drawable.vistula, 60.9f, 51.8f,"Vistula"),
            new Question(R.drawable.volga, 100f, 41.1f,"Volga"),
            new Question(R.drawable.ladoga, 80.8f, 16f,"Ladoga"),
            new Question(R.drawable.norwegian_sea, 25.6f, 8.1f,"Norwegian Sea"),
    };
    int[] options = new int[]{
            R.id.Capitals,
            R.id.Flags,
            R.id.Mountains,
            R.id.Waterways,
    };
    int counter = 0;
    int points = 0;
    int wrongTries = 0;
    int percentage = 0;
    int displayImageId;
    int select;

    private void shuffleQuestions() {
        Collections.shuffle(Arrays.asList(workingQuestions));
    }

    private void nextImage() {
        resetRadioButtons();
        ImageView imageView = findViewById(R.id.Image);
        TextView score = findViewById(R.id.Score);
        //update scor

        counter++;
        if (counter < workingQuestions.length) {
            if (counter != 0) {
                percentage = (int) (points * 1.0 / counter * 100);
            }
            score.setText(getString(R.string.percentage,percentage));
            TextView counterImages = findViewById(R.id.CounterImages);
            //update imagine
            imageView.setImageResource(workingQuestions[counter].imageId);
            wrongTries = 0;
            //update nr imagine
            counterImages.setText(getString(R.string.counterImages,counter + 1, workingQuestions.length));
            if((select==2 || select==3) && counter<workingQuestions.length) {
                TextView imageText = findViewById(R.id.ImageText);
                imageText.setText(workingQuestions[counter].name);
            }
        }
    }

    private boolean nothingChecked() {
        for (Question question : workingQuestions) {
            RadioButton radioButton = findViewById(question.buttonId);
            if (radioButton.isChecked()) {
                return false;
            }
        }
        return true;
    }

    //resetare butoane
    private void resetRadioButtons() {
        for (Question question : workingQuestions) {
            RadioButton radioButton = findViewById(question.buttonId);
            radioButton.setChecked(false);
        }
    }

    //variabile timer
    TextView timerText;
    Timer timer;
    TimerTask timerTask;
    boolean timerStarted = false;
    Double time = 0.0;

    private void setWorkingAnswersVisibility(int visibility) {
        for (Question workingQuestion : workingQuestions)
            findViewById(workingQuestion.buttonId).setVisibility(visibility);
    }

    private void setCategoriesVisibility(int visibility) {
        for (int option : options) {
            findViewById(option).setVisibility(visibility);
        }
    }

    //reset
    public void reset(View view) {
        AlertDialog.Builder resetAlert = new AlertDialog.Builder(this);
        resetAlert.setTitle("Reset Attempt");
        resetAlert.setMessage("Are you sure you want to reset?");
        resetAlert.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                counter=0;
                points = 0;
                percentage = 0;
                TextView counterImages = findViewById(R.id.CounterImages);
                TextView finalscore = findViewById(R.id.FinalScore);
                ImageView imageView = findViewById(R.id.Image);
                TextView score = findViewById(R.id.Score);
                Button start = findViewById(R.id.Start);
                Button checkButton = findViewById(R.id.Button);
                TextView imageText = findViewById(R.id.ImageText);
                TextView finalText = findViewById(R.id.FinalText);

                start.setText(getString(R.string.select));
                checkButton.setEnabled(true);
                start.setVisibility(View.VISIBLE);
                setCategoriesVisibility(View.VISIBLE);
                counterImages.setVisibility(View.INVISIBLE);
                score.setVisibility(View.INVISIBLE);
                finalscore.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.INVISIBLE);
                findViewById(R.id.Question).setVisibility(View.INVISIBLE);
                timerText.setVisibility(View.INVISIBLE);
                imageText.setText("");
                findViewById(R.id.Button).setVisibility(View.INVISIBLE);
                findViewById(R.id.Reset).setVisibility(View.INVISIBLE);
                finalText.setText("");
                finalscore.setText("");

                setWorkingAnswersVisibility(View.INVISIBLE);
                if (timerTask != null) {
                    timerTask.cancel();
                    time = 0.0;
                    timerStarted = false;
                    timerText.setText(formatTime(0, 0));
                }
            }
        });
        resetAlert.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        resetAlert.show();
    }

    public void startStopTimer(View view) {
        if (!timerStarted) {
            timerStarted = true;
            startTimer();
        } else {
            timerStarted = false;
            timerTask.cancel();
        }
    }

    private void startTimer() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time++;
                        timerText.setText(getTimerText());
                    }
                });
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    private String getTimerText() {
        int rounded = (int) Math.round(time);

        int seconds = ((rounded % 86400) % 3600) % 60;
        int minutes = ((rounded % 86400) % 3600) / 60;

        return formatTime(seconds, minutes);
    }

    private String formatTime(int seconds, int minutes) {
        return getString(R.string.time, minutes, seconds);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayImageId = addDisplayImage(R.drawable.europe_default);
        ImageView displayImage = findViewById(displayImageId);
        displayImage.setAdjustViewBounds(true);

        timerText = findViewById(R.id.timerText);
        timer = new Timer();
        //butoane principale
        Button checkButton = findViewById(R.id.Button);
        Button reset = findViewById(R.id.Reset);
        //imaginea de inceput
        ImageView imageView = findViewById(R.id.Image);
        TextView score = findViewById(R.id.Score);
        //text de inceput
        TextView title = findViewById(R.id.Title);
        TextView counterImages = findViewById(R.id.CounterImages);
        TextView finalscore = findViewById(R.id.FinalScore);
        TextView finalText = findViewById(R.id.FinalText);
        TextView questionText = findViewById(R.id.Question);

        Button start = findViewById(R.id.Start);
        start.setEnabled(false);
        TextView imageText = findViewById(R.id.ImageText);

        RadioGroup categories = findViewById(R.id.Categories);
        RadioGroup difficulty = findViewById(R.id.Difficulty);
        categories.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                start.setEnabled(true);

                if (id == R.id.Capitals) {
                    questionText.setText(getText(R.string.q1));
                    displayImage.setImageResource(R.drawable.europe_capitals);
                    select = 0;
                }
                if (id == R.id.Flags) {
                    questionText.setText(getText(R.string.q2));
                    displayImage.setImageResource(R.drawable.europe_flags);
                    select = 1;
                }
                if (id == R.id.Mountains) {
                    questionText.setText(getText(R.string.q3));
                    displayImage.setImageResource(R.drawable.europe_mountains);
                    select = 2;
                }
                if (id == R.id.Waterways) {
                    questionText.setText(getText(R.string.q4));
                    displayImage.setImageResource(R.drawable.europe_rivers);
                    select = 3;
                }
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (start.getText().equals(getText(R.string.select))) {
                    setCategoriesVisibility(View.INVISIBLE);
                    difficulty.setVisibility(View.VISIBLE);
                    start.setText(getString(R.string.start));
                }
                else
                {
                    RadioButton easyRadioButton = findViewById(R.id.Easy);
                    RadioButton mediumRadioButton = findViewById(R.id.Medium);
                    RadioButton hardRadioButton = findViewById(R.id.Hard);
                    if (select == 0) {
                        if (easyRadioButton.isChecked()) {
                            workingQuestions = easyCapitalsQuestions;
                        }
                        if (mediumRadioButton.isChecked()) {
                            workingQuestions = mediumCapitalsQuestions;
                        }
                        if (hardRadioButton.isChecked()) {
                            workingQuestions = hardCapitalsQuestions;
                        }
                    }
                    if (select == 1) {
                        if (easyRadioButton.isChecked()) {
                            workingQuestions = easyFlagsQuestions;
                        }
                        if (mediumRadioButton.isChecked()) {
                            workingQuestions = mediumFlagsQuestions;
                        }
                        if (hardRadioButton.isChecked()) {
                            workingQuestions = hardFlagsQuestions;
                        }
                    }
                    if (select == 2) {
                        if (easyRadioButton.isChecked()) {
                            workingQuestions = easyMountainsQuestions;
                        }
                        if (mediumRadioButton.isChecked()) {
                            workingQuestions = mediumMountainsQuestions;
                        }
                        if (hardRadioButton.isChecked()) {
                            workingQuestions = hardMountainsQuestions;
                        }
                    }
                    if (select == 3) {
                        if (easyRadioButton.isChecked()) {
                            workingQuestions = easyWaterwaysQuestions;
                        }
                        if (mediumRadioButton.isChecked()) {
                            workingQuestions = mediumWaterwaysQuestions;
                        }
                        if (hardRadioButton.isChecked()) {
                            workingQuestions = hardWaterwaysQuestions;
                        }
                    }
                    shuffleQuestions();

                    difficulty.setVisibility(View.INVISIBLE);
                    start.setVisibility(View.INVISIBLE);
                    title.setVisibility(View.INVISIBLE);
                    for (Question question : workingQuestions) {
                        question.buttonId = addRadioButton(displayImage, question.percentLeft, question.percentTop);
                    }

                    if(select==2 || select==3) imageText.setText(workingQuestions[counter].name);
                    //doar un radio button selectat
                    for (Question question : workingQuestions) {
                        RadioButton button = findViewById(question.buttonId);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                resetRadioButtons();
                                button.setChecked(true);
                            }
                        });
                    }
                    setCategoriesVisibility(View.INVISIBLE);
                    start.setVisibility(View.INVISIBLE);
                    counterImages.setText(getString(R.string.counterImages,counter,workingQuestions.length));
                    counterImages.setVisibility(View.VISIBLE);
                    score.setText(getString(R.string.score, percentage));
                    score.setVisibility(View.VISIBLE);
                    finalscore.setText("");
                    finalscore.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.VISIBLE);
                    imageView.setImageResource(workingQuestions[counter].imageId);
                    timerText.setVisibility(View.VISIBLE);

                    //vizibilitate radio buttons
                    setWorkingAnswersVisibility(View.VISIBLE);

                    //vizibilitate
                    checkButton.setVisibility(View.VISIBLE);
                    reset.setVisibility(View.VISIBLE);
                    findViewById(R.id.Question).setVisibility(View.VISIBLE);

                    startStopTimer(view);
                }
            }
        });

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkButton.getText().equals("CHECK")) {
                    if (nothingChecked()) {
                        Toast.makeText(MainActivity.this, "Select an option", Toast.LENGTH_LONG).show();
                    } else {
                        RadioButton correctRadioButton = findViewById(workingQuestions[counter].buttonId);

                        //raspuns corect
                        if (correctRadioButton.isChecked()) {
                            Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_LONG).show();
                            points++;
                            nextImage();
                        }
                        //raspuns gresit
                        else {
                            if (wrongTries == 0) {
                                wrongTries++;
                                Toast.makeText(MainActivity.this, "Try again", Toast.LENGTH_LONG).show();
                            } else if (wrongTries == 1) {
                                wrongTries++;
                                Toast.makeText(MainActivity.this, "Last try", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(MainActivity.this, "Wrong again. The correct answer is marked on the screen", Toast.LENGTH_LONG).show();
                                resetRadioButtons();
                                correctRadioButton.setChecked(true);
                                checkButton.setText(getString(R.string.check));
                            }
                        }
                    }
                } else if (checkButton.getText().equals(getString(R.string.next))) {
                    checkButton.setText(getString(R.string.next));
                    nextImage();
                }
                //conditie de sfarsit
                if (counter == workingQuestions.length) {
                    setWorkingAnswersVisibility(View.INVISIBLE);
                    questionText.setVisibility(View.INVISIBLE);
                    imageText.setText("");
                    checkButton.setEnabled(false);
//                    reset.setEnabled(false);
                    imageView.setVisibility(View.INVISIBLE);
                    timerTask.cancel();
                    timerText.setText(getTimerText());
                    finalText.setText(getString(R.string.finaltext));
                    finalscore.setText(getString(R.string.finalscore, percentage, timerText.getText()));
                    reset.setText("FINISH");
                }
            }
        });
        //daca se da reset
        String resetText= (String) reset.getText();
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(resetText!="FINISH")
                    reset(view);
            }
        });
    }
    private int addRadioButton(ImageView imageView, float percentLeft, float percentTop) {
        RadioButton radioButton = new RadioButton(this);
        int id = View.generateViewId();
        radioButton.setId(id);

        ConstraintLayout constraintLayout = findViewById(R.id.app_layout);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT);

        int leftMargin = (int) (imageView.getWidth() * percentLeft / 100.0 * 0.92);
        int topMargin = (int) (imageView.getHeight() * percentTop / 100.0 * 0.92);

        layoutParams.startToStart = imageView.getId();
        layoutParams.topToTop = imageView.getId();

        layoutParams.setMargins(leftMargin, topMargin, 0, 0);

        constraintLayout.addView(radioButton, layoutParams);
        return id;
    };
    private int addDisplayImage(int imageId) {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(imageId);
        imageView.setAdjustViewBounds(false);
        int id = View.generateViewId();
        imageView.setId(id);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
        );
        int marginStart = (int) (getResources().getDisplayMetrics().widthPixels * 0f / 100.0);
        int marginTop = (int) (getResources().getDisplayMetrics().heightPixels * 45.5 / 100.0);
        layoutParams.setMargins(marginStart, marginTop, 0, 0);
        layoutParams.horizontalBias=0.0f;
        imageView.setLayoutParams(layoutParams);

        ConstraintLayout layout = findViewById(R.id.app_layout);
        layout.addView(imageView);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(layout);
        constraintSet.connect(imageView.getId(), ConstraintSet.START, layout.getId(), ConstraintSet.START, marginStart);
        constraintSet.connect(imageView.getId(), ConstraintSet.TOP, layout.getId(), ConstraintSet.TOP, marginTop);
        constraintSet.applyTo(layout);
        return id;
    }
}