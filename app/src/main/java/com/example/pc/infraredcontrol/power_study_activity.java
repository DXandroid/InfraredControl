package com.example.pc.infraredcontrol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class power_study_activity extends AppCompatActivity {

    EventProcessing EP;
    //按键
    Button button_back,study_power,study_mode,study_speed,study_dir,study_swing,study_minus,study_sleep,study_timing,study_add,study_bra,study_tit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.power_study_activity);
        setButton();
        EP = (EventProcessing) getApplication();
    }

    /***
     * 按键
     */
    void setButton() {
        button_back=(Button)findViewById(R.id.back);//返回power_activity界面
        study_power=(Button)findViewById(R.id.power_study);//开关学习
        study_mode=(Button)findViewById(R.id.mode_study);//模式学习
        study_speed=(Button)findViewById(R.id.speed_stuay);//风速学习
        study_dir=(Button)findViewById(R.id.direction_study);//风向学习
        study_swing=(Button)findViewById(R.id.swing_study);//扫风学习
        study_minus=(Button)findViewById(R.id.minus_study);//减温度学习
        study_sleep=(Button)findViewById(R.id.sleep_study);//睡眠学习
        study_timing=(Button)findViewById(R.id.timing_study);//定时学习
        study_add=(Button)findViewById(R.id.add_study);//增加学习
        study_bra=(Button)findViewById(R.id.brainpower_study);//智能模式学习
        study_tit=(Button)findViewById(R.id.tit_study);//显示温度按钮
        study_tit.setEnabled(false);
    }
    /**
     * 设置点击事件
     * */

    //模式学习事件
    public void setStudy_mode_onclick(View view){
            setActivity();
            EP.setButtonName(study_mode.getText().toString());
    }
    //风速学习事件
    public void setStudy_speed_onclick(View view){
            setActivity();
        EP.setButtonName(study_speed.getText().toString());
    }
    //风向学习事件
    public void setStudy_dir_onclick(View view){
            setActivity();
        EP.setButtonName(study_dir.getText().toString());
    }
    //扫风学习事件
    public void setStudy_swing_onclick(View view){
            setActivity();
        EP.setButtonName(study_swing.getText().toString());
    }
    //减温度学习事件
    public void setStudy_minus_onclick(View view){
            setActivity();
        EP.setButtonName(study_minus.getText().toString());
    }
    //加温度学习事件
    public void setStudy_add_onclick(View view){
            setActivity();
        EP.setButtonName(study_add.getText().toString());
    }
    //定时学习事件
    public void setStudy_timing_onclick(View view){
            setActivity();
        EP.setButtonName(study_timing.getText().toString());
    }
    //智能模式学习事件
    public void setStudy_bra_onclick(View view){
            setActivity();
        EP.setButtonName(study_bra.getText().toString());
    }
    //开关学习事件
    public void setStudy_power_onclick(View view){
            setActivity();
        EP.setButtonName(study_power.getText().toString());
    }
    //睡眠学习事件
    public void setStudy_sleep_onclick(View view){
        setActivity();
        EP.setButtonName(study_sleep.getText().toString());
    }
    /**
     * 跳转按钮界面
     * */
    public  void setActivity(){
        Intent intent=new Intent();
        intent.setClass(power_study_activity.this,Button_Learn.class);
        startActivity(intent);
    }
     //返回power 界面
    public  void setButton_back_onclick(View view){
        Intent intent=new Intent();
        intent.setClass(power_study_activity.this,power_Activity.class);
        startActivity(intent);
    }
}
