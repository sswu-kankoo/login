package com.kankoo.kankoo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;


public class RegistActivity1 extends Activity {

    private EditText etID;
    private EditText etPassword;
    private EditText etPasswordConfirm;

    private EditText etPersonName;
    private EditText etStudentID;
    private Button btnDone;
    private Button btnCancel;

    private AutoCompleteTextView etMajor;
    private MultiAutoCompleteTextView textProgrammingLanguage;

    private String[] Majors = {"국어국문학과", "영어영문학과", "독어독문학과", "독일어·문화학과",
            "불어불문학과", "프랑스어문·문화학괴", "일어일문학과", "일본어문·문화학과", "중어중문학과",
            "중국어문·문화학과", "사학과", "정치외교학과", "심리학과", "지리학과", "경제학과", "경영학과",
            "미디어커뮤니케이션학과", "융합보안학과", "법학과", "지식산업법학과", "수학과", "통계학과",
            "생명과학·화학부", "화학과", "IT학부", "청정융합과학과", "서비스·디자인공학과", "융합보안공학과",
            "컴퓨터공학과","정보시스템공학과", "청정융합에너지공학과", "바이오식품공학과", "바이오생명공학과",
            "간호학과", "글로벌의과학과", "식품영양학과", "사회복지학과", "스포츠레저학과", "운동재활복지학과",
            "글로벌비즈니스학과", "의류산업학과", "뷰티산업학과", "소비자생활문화산업학과", "교육학과", "사회교육과",
            "윤리교육과", "한문교육과", "유야교육과", "동양화과", "서양화과", "조소과", "공예과",
            "산업디자인과", "성악과", "기악과", "작곡과", "문화예술경영학과", "미디어영상연기학과", "현대실용음악학과",
            "무용예술학과", "메이크업디자인학과", "의류학과", "생활문화소비자학과"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist1);

        etID = (EditText) findViewById(R.id.etID);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPasswordConfirm = (EditText) findViewById(R.id.etPasswordConfirm);
//        etMajor = (EditText) findViewById(R. id.etMajor);
        etPersonName = (EditText) findViewById(R.id.etPersonName);
        etStudentID = (EditText) findViewById(R.id.etStudentID);

        btnDone = (Button) findViewById(R.id.btnDone);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        // 비밀번호 일치 검사
        etPasswordConfirm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = etPassword.getText().toString();
                String confirm = etPasswordConfirm.getText().toString();

                if( password.equals(confirm) ) {
                    etPassword.setBackgroundColor(Color.GREEN);
                    etPasswordConfirm.setBackgroundColor(Color.GREEN);
                } else {
                    etPassword.setBackgroundColor(Color.RED);
                    etPasswordConfirm.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 아이디 입력 확인
                if( etID.getText().toString().length() == 0 ) {
                    Toast.makeText(RegistActivity1.this, "아이디를 입력하세요!", Toast.LENGTH_SHORT).show();
                    etID.requestFocus();
                    return;
                }

                // 비밀번호 입력 확인
                if( etPassword.getText().toString().length() == 0 ) {
                    Toast.makeText(RegistActivity1.this, "비밀번호를 입력하세요!", Toast.LENGTH_SHORT).show();
                    etPassword.requestFocus();
                    return;
                }

                // 비밀번호 확인 입력 확인
                if( etPasswordConfirm.getText().toString().length() == 0 ) {
                    Toast.makeText(RegistActivity1.this, "비밀번호 확인을 입력하세요!", Toast.LENGTH_SHORT).show();
                    etPasswordConfirm.requestFocus();
                    return;
                }

                // 비밀번호 일치 확인
                if( !etPassword.getText().toString().equals(etPasswordConfirm.getText().toString()) ) {
                    Toast.makeText(RegistActivity1.this, "비밀번호가 일치하지 않습니다!", Toast.LENGTH_SHORT).show();
                    etPassword.setText("");
                    etPasswordConfirm.setText("");
                    etPassword.requestFocus();
                    return;
                }

                // 전공 입력 확인
                if( etMajor.getText().toString().length() == 0 ) {
                    Toast.makeText(RegistActivity1.this, "전공을 입력하세요!", Toast.LENGTH_SHORT).show();
                    etMajor.requestFocus();
                    return;
                }

                // 이름 입력 확인
                if( etPersonName.getText().toString().length() == 0 ) {
                    Toast.makeText(RegistActivity1.this, "이름을 입력하세요!", Toast.LENGTH_SHORT).show();
                    etPersonName.requestFocus();
                    return;
                }

                // 학번 입력 확인
                if( etStudentID.getText().toString().length() == 0 ) {
                    Toast.makeText(RegistActivity1.this, "아이디를 입력하세요!", Toast.LENGTH_SHORT).show();
                    etStudentID.requestFocus();
                    return;
                }

                Intent result = new Intent();
                result.putExtra("ID", etID.getText().toString());

                // 자신을 호출한 엑티비티로 데이터를 보낸다.
                setResult(RESULT_OK, result);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
/*    private void submitForm() {
        String text="안녕하세요? "+ this.etPersonName.getText().toString();

        Toast.makeText(this, text,Toast.LENGTH_LONG).show();
        } */
    }
}



