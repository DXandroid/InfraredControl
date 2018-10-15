package com.example.pc.infraredcontrol;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_study extends AppCompatActivity {

    Button button_power_studying,button_add_studying,button_minus_studying;
    TextView study_info,reminder;
    //学习成果
    boolean isSuccess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        intiset_butten();

        isSuccess=false;
        study_info=findViewById(R.id.studyinfo);
        study_info.setText("");

        //是否学习成功
        isStudySuccess();

        //背景
        WallpaperManager manager=WallpaperManager.getInstance(this);
        Drawable drawable=manager.getDrawable();
        this.getWindow().setBackgroundDrawable(drawable);

        reminder=findViewById(R.id.reminder);
        reminder.setText("1：请将手机对准电器并点击开关学习按钮\n2：根据电器响应结果选择是/否");
    }
    protected void intiset_butten() {
        button_power_studying=findViewById(R.id.power);
        button_add_studying=findViewById(R.id.add);
        button_minus_studying=findViewById(R.id.minus);
    }
    public void butten_power_study_onclick(View view) {

    }
    public void butten_add_study_onclick(View view) {

    }
    public void butten_minus_study_onclick(View view) {

    }
    public void isStudySuccess(){
        if(isSuccess==true){
            Intent intent=new Intent(activity_study.this,Main_Interface_Activity.class);
            startActivity(intent);
            activity_study.this.finish();
        }
        else {
            study_info.setText("红外学习失败\n");
        }
    }
}
