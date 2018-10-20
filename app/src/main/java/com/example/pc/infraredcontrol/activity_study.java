package com.example.pc.infraredcontrol;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class activity_study extends AppCompatActivity implements View.OnClickListener {

    Button study;
    TextView tip;
    String btn[]={"开","关","+","+","+","+","+","+"};
    int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setEnterTransition(new Explode());
        setContentView(R.layout.activity_study);
        study=findViewById(R.id.study);
        study.setOnClickListener(this);
        tip=findViewById(R.id.tip);
        flag=-1;
    }

    @Override
    public void onClick(View view) {
        switch (flag){
            case -1:
                tip.setText(R.string.study_s1);
                study.setText(R.string.ok);
                flag++;
                break;
            case 2:
                tip.setText(R.string.study_s4);
                flag++;
                break;
            case 0:
            case 1:
                tip.setText(getString(R.string.study_s2,btn[flag]));
                flag++;
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                tip.setText(getString(R.string.study_s3,btn[flag-1],22+flag-2));
                flag++;
                break;
            case 9:
                tip.setText(R.string.study_over);
                app_intiset();
                break;
        }
    }

    /**
     * 界面跳转
     */
    private void app_intiset(){
        /*
        //界面跳转intent，并设置flags，清除活动堆栈并让跳转的界面置为活动堆栈底
         */
        Intent intent= new Intent(this,Main_Interface_Activity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        /*
        跳转界面，并传递android5.0转场动画bundle
         */
        Bundle bundle=ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
        startActivity(intent,bundle);
    }
}
