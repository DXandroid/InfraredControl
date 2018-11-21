package com.example.pc.infraredcontrol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class power_study_activity extends AppCompatActivity {
    //按键
    Button button_back,study_power,study_mode,study_speed,study_dir,study_swing,study_minus,study_sleep,study_timing,study_add,study_bra,study_tit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.power_study_activity);
        setButton();
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
     * 设置点击事件*/
    //返回power 界面
    public  void setButton_back_onclick(View view){
        Intent intent=new Intent();
        intent.setClass(power_study_activity.this,power_Activity.class);
        startActivity(intent);
    }
    //模式学习事件
    public void setStudy_mode_onclick(View view){
            setActivity();
    }
    //风速学习事件
    public void setStudy_speed_onclick(View view){
            setActivity();
    }
    //风向学习事件
    public void setStudy_dir_onclick(View view){
            setActivity();
    }
    //扫风学习事件
    public void setStudy_swing_onclick(View view){
            setActivity();
    }
    //减温度学习事件
    public void setStudy_minus_onclick(View view){
            setActivity();
    }
    //加温度学习事件
    public void setStudy_add_onclick(View view){
            setActivity();
    }
    //定时学习事件
    public void setStudy_timing_onclick(View view){
            setActivity();
    }
    //智能模式学习事件
    public void setStudy_bra_onclick(View view){
            setActivity();
    }
    //开关学习事件
    public void setStudy_power(View view){
            setActivity();
    }
    /**
     * 跳转到按钮学习界面
     * */
    public  void setActivity(){
        Intent intent=new Intent();
        intent.setClass(power_study_activity.this,Button_Learn.class);
        startActivity(intent);
    }
}
