package com.kankoo.kankoo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistActivity1_auth extends AppCompatActivity implements View.OnClickListener, Dialog.OnCancelListener {

    final int randomNum = 106254; //테스트할 6자리 인증번호

    EditText authEmail;
    Button btnSendAuthNum;

    /*Dialog에 관련된 필드 */

    LayoutInflater dialog; //LayoutInflater
    View dialogLayout; //layout을 담을 View
    Dialog authDialog; //dialog 객체

    /*카운트 다운 타이머에 관련된 필드*/

    TextView time_counter; //시간을 보여주는 TextView
    EditText emailAuth_number; //인증 번호를 입력 하는 칸
    Button btnDone; // 인증버튼
    CountDownTimer countDownTimer;
    final int MILLISINFUTURE = 300 * 1000; //총 시간 (300초 = 5분)
    final int COUNT_DOWN_INTERVAL = 1000; //onTick 메소드를 호출할 간격 (1초)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_activity1_auth);

        authEmail=(EditText)findViewById(R.id.authEmail);
        btnSendAuthNum=(Button)findViewById(R.id.btnSendAuthNum);
        btnSendAuthNum.setOnClickListener(this);


    }

    public void countDownTimer() { //카운트 다운 메소드

        time_counter = (TextView) dialogLayout.findViewById(R.id.emailAuth_time_counter);
        //줄어드는 시간을 나타내는 TextView
        emailAuth_number = (EditText) dialogLayout.findViewById(R.id.emailAuth_number);
        //사용자 인증 번호 입력창
        btnDone = (Button) dialogLayout.findViewById(R.id.btnDone);
        //인증하기 버튼


        countDownTimer = new CountDownTimer(MILLISINFUTURE, COUNT_DOWN_INTERVAL) {
            @Override
            public void onTick(long millisUntilFinished) { //(300초에서 1초 마다 계속 줄어듬)

                long emailAuthCount = millisUntilFinished / 1000;
                Log.d("Alex", emailAuthCount + "");

                if ((emailAuthCount - ((emailAuthCount / 60) * 60)) >= 10) { //초가 10보다 크면 그냥 출력
                    time_counter.setText((emailAuthCount / 60) + " : " + (emailAuthCount - ((emailAuthCount / 60) * 60)));
                } else { //초가 10보다 작으면 앞에 '0' 붙여서 같이 출력. ex) 02,03,04...
                    time_counter.setText((emailAuthCount / 60) + " : 0" + (emailAuthCount - ((emailAuthCount / 60) * 60)));
                }

                //emailAuthCount은 종료까지 남은 시간임. 1분 = 60초 되므로,
                // 분을 나타내기 위해서는 종료까지 남은 총 시간에 60을 나눠주면 그 몫이 분이 된다.
                // 분을 제외하고 남은 초를 나타내기 위해서는, (총 남은 시간 - (분*60) = 남은 초) 로 하면 된다.

            }


            @Override
            public void onFinish() { //시간이 다 되면 다이얼로그 종료

                authDialog.cancel();

            }
        }.start();

        btnSendAuthNum.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnSendAuthNum :

                dialog = LayoutInflater.from(this);
                dialogLayout = dialog.inflate(R.layout.activity_regist_activity1_auth_dialog, null); // LayoutInflater를 통해 XML에 정의된 Resource들을 View의 형태로 반환 시켜 줌
                authDialog = new Dialog(this); //다이로그 객체 생성
                authDialog.setContentView(dialogLayout); //다이로그에 인플랫한 뷰를 탑재 하여줌
                authDialog.setCanceledOnTouchOutside(false); //Dialog 바깥 부분을 선택해도 닫히지 않게 설정함.
                authDialog.show(); //다일로그를 나타내어 준다.
                countDownTimer();
                break;

            case R.id.btnDone : //다이얼로그 내의 인증번호 인증 버튼을 눌렀을 시

                int user_answer = Integer.parseInt(emailAuth_number.getText().toString());
                if(user_answer==randomNum){
                    Toast.makeText(this, "이메일 인증 성공", Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(this, "이메일 인증 실패", Toast.LENGTH_SHORT).show();
                }
                break;



        }

    }

    @Override
    public void onCancel(DialogInterface dialog) {
        countDownTimer.cancel();
    } //다이얼로그 닫을 때 카운트 다운 타이머의 cancel()메소드 호출


}
