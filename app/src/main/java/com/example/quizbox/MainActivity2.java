package com.example.quizbox;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {


    public TextView tvPertanyaan, tvNilai, tvNoPertanyaan, tvWaktu, tv_id_soal, tv_soal, tv_pilihan_1, tv_pilihan_2, tv_pilihan_3, tv_pilihan_4, tv_jawaban;
    private RadioGroup radioGroup;
    private RadioButton rb1, rb2, rb3, rb4;
    private Button btnNext;

    int totalPertanyaan;
    int qCounter = 0;
    int nilai;

    ColorStateList dfRbColor;
    boolean jawaban;
    CountDownTimer countDownTimer;

    private Pertanyaan currentQuestion;

    private List<Pertanyaan> questionList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        questionList = new ArrayList<>();
        tvPertanyaan = findViewById(R.id.pertanyaan);
        tvNilai = findViewById(R.id.nilai);
        tvNoPertanyaan = findViewById(R.id.noSoal);
        tvWaktu = findViewById(R.id.waktu);

        radioGroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);

        btnNext = findViewById(R.id.btnNext);
        dfRbColor = rb1.getTextColors();

        tv_id_soal = findViewById(R.id.tv_id_soal);
        tv_soal = findViewById(R.id.tv_soal);
        tv_pilihan_1 =findViewById(R.id.tv_pilihan_1);
        tv_pilihan_2 =findViewById(R.id.tv_pilihan_2);
        tv_pilihan_3 =findViewById(R.id.tv_pilihan_3);
        tv_pilihan_4 =findViewById(R.id.tv_pilihan_4);
        tv_jawaban =findViewById(R.id.tv_jawaban);



        addQuestions();

        totalPertanyaan = questionList.size();
        showNextQuestion();
        timer();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jawaban == false){
                    if(rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()){
                        checkAnswer();
                    }else {
                        Toast.makeText(com.example.quizbox.MainActivity2.this, "Tolong isi jawaban", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    showNextQuestion();
                }
            }
        });
    }

    public void checkAnswer() {
        jawaban = true;
        RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int jawabanNo = radioGroup.indexOfChild(rbSelected) + 1;
        if(jawabanNo == currentQuestion.getCorrectAnsNo()){
            nilai++;
            tvNilai.setText("Nilai: "+nilai);
        }
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);
        switch (currentQuestion.getCorrectAnsNo()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                break;
        }
        if(qCounter < totalPertanyaan){
            btnNext.setText("Pertanyaan Selanjutnya");
        }else {
            btnNext.setText("Finish");
        }
    }

    public void showNextQuestion() {
        radioGroup.clearCheck();
        rb1.setTextColor(dfRbColor);
        rb2.setTextColor(dfRbColor);
        rb3.setTextColor(dfRbColor);
        rb4.setTextColor(dfRbColor);

        if(qCounter < totalPertanyaan){
            currentQuestion = questionList.get(qCounter);
            tvPertanyaan.setText(currentQuestion.getPertanyaannya());
            rb1.setText(currentQuestion.getPilihan1());
            rb2.setText(currentQuestion.getPilihan2());
            rb3.setText(currentQuestion.getPilihan3());
            rb4.setText(currentQuestion.getPilihan4());

            qCounter++;
            btnNext.setText("Submit");
            tvNoPertanyaan.setText("Pertanyaan: "+qCounter+"/"+totalPertanyaan);
            jawaban = false;

        }else{
            countDownTimer.cancel();
            countDownTimer.onFinish();
        }
    }

    private void timer() {
        countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long l) {
                tvWaktu.setText("00:" + l/1000);
            }

            @Override
            public void onFinish() {
                String totalNilai = String.valueOf(nilai);
                Intent intent = new Intent(com.example.quizbox.MainActivity2.this, MainActivity3.class);
                intent.putExtra("nilai", totalNilai);
                startActivity(intent);
            }
        }.start();
    }

    private void addQuestions() {
        Intent intent = getIntent();
        int length = intent.getExtras().getInt("length");

        for(int i=0; i<length; i++ ){
            tv_soal.setText(MainActivity5.soalArrayList.get(i).getSoal());
            String soal_1 = tv_soal.getText().toString();

            tv_pilihan_1.setText(MainActivity5.soalArrayList.get(i).getPilihan_1());
            String pilihan_1 = tv_pilihan_1.getText().toString();

            tv_pilihan_2.setText(MainActivity5.soalArrayList.get(i).getPilihan_2());
            String pilihan_2 = tv_pilihan_2.getText().toString();

            tv_pilihan_3.setText(MainActivity5.soalArrayList.get(i).getPilihan_3());
            String pilihan_3 = tv_pilihan_3.getText().toString();

            tv_pilihan_4.setText(MainActivity5.soalArrayList.get(i).getPilihan_4());
            String pilihan_4 = tv_pilihan_4.getText().toString();

            tv_jawaban.setText(MainActivity5.soalArrayList.get(i).getJawaban());
            String jawaban0 = tv_jawaban.getText().toString();
            int jawaban1 = Integer.parseInt(jawaban0);


            questionList.add(new Pertanyaan(soal_1, pilihan_1, pilihan_2, pilihan_3, pilihan_4, jawaban1));
        }

    }

}