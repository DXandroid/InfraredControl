package com.example.pc.infraredcontrol;
/*
* 空调控制界面
* */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.time.Instant;
import java.util.HashMap;

public class power_Activity extends AppCompatActivity {
    //按钮
    Button button_power,button_mode,button_speed,button_dir,button_swing,button_minus,button_sleep,button_timing,button_add,button_bra,button_tit,button_study_temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.power_activity);
        button_set();
    }

    //初始化按钮
    void button_set(){
        button_add=(Button)findViewById(R.id.add);//加
        button_minus=(Button)findViewById(R.id.minus);//减
        button_bra=(Button)findViewById(R.id.brainpower);//智能遥控
        button_dir=(Button)findViewById(R.id.direction);//风向
        button_mode=(Button)findViewById(R.id.mode);//模式
        button_power=(Button)findViewById(R.id.power);//开关
        button_sleep=(Button)findViewById(R.id.sleep);//睡眠
        button_timing=(Button)findViewById(R.id.timing);//定时
        button_speed=(Button)findViewById(R.id.speed);//风速
        button_swing=(Button)findViewById(R.id.swing);//扫风
        button_study_temp=(Button)findViewById(R.id.study_temp);//学习按键
        button_tit=(Button)findViewById(R.id.tit);//显示温度两个字
        button_tit.setEnabled(false);
    }
    /**
     * 按钮点击事件*/
    //开关事件
    public void setButton_power_onclick(View view)
    {
        String t="power";
            //    switch (sendInfrared(t)){
            //  case 0:
            //  case 1:     Toast toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);
        //                  toast.show();
        //                  break;
            //  case -1:   Toast toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);
            //            toast.show();
            //              break;
            //   }


    }
    //加温度事件
    public void setButton_add_onclick(View view)
    {
        String t="add";

            //    switch (sendInfrared(t)){
            //       case 0:
        //  case 1:     Toast toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);
        //                  toast.show();
        //                  break;
            //  case -1:     Toast toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);
            //                toast.show();
            //                break;
            //   }


    }
    //减温度事件
    public void setButton_minus_onclick(View view)
    {
        String t="minus";
            //    switch (sendInfrared(t)){
            //       case 0:
        //  case 1:     Toast toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);
        //                  toast.show();
        //                  break;
            //  case -1：    Toast toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);
            //                toast.show();
            //                break;
            //   }
        }

    //风速事件
    public void setButton_speed_onclick(View view)
    {
        String t="speed";
            //    switch (sendInfrared(t)){
            //       case 0:
        //  case 1:     Toast toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);
        //                  toast.show();
        //                  break;
            //  case -1: Toast toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);
            //           toast.show();
            //           break;
            //   }
        }

    //模式事件
    public void setButton_mode_onclick(View view)
    {
        String t="mode";
            //    switch (sendInfrared(t)){
            //       case 0:
        //  case 1:     Toast toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);
        //                  toast.show();
        //                  break;
            //  case -1: Toast toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);
            //            toast.show();
            //            break;
            //   }
        }

    //风向事件
    public void setButton_dir_onclick(View view)
    {
        String t="direction";
       //    switch (sendInfrared(t)){
        //       case 0:
        //  case 1:     Toast toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);
        //                  toast.show();
        //                  break;
            //  case -1: Toast toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);
            //           toast.show();
            //           break;
        //   }
        }

    //定时事件
    public void setButton_timing_onclick(View view)
    {
        String t="timing";
            //    switch (sendInfrared(t)){
            //       case 0:
        //  case 1:     Toast toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);
        //                  toast.show();
        //                  break;
            //  case -1: Toast toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);
            //           toast.show();
            //           break;
            //   }
        }

    //睡眠事件
    public void setButton_sleep_onclick(View view)
    {
        String t="sleep";
            //    switch (sendInfrared(t)){
            //       case 0:
        //  case 1:     Toast toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);
        //                  toast.show();
        //                  break;
            //  case -1: Toast toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);
            //           toast.show();
            //           break;
            //   }
        }

    //扫风事件
    public void setButton_swing_onclick(View view)
    {
        String t="swing";

            //    switch (sendInfrared(t)){
            //       case 0:
        //  case 1:     Toast toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);
        //                  toast.show();
        //                  break;
            //  case -1: Toast toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);
            //           toast.show();
            //           break;
            //   }
        }

    public void setButton_bra_onclick(View view) {
            //    switch (intelligentMode()){
            //   关闭    case 0:
            //   打开 case 1:
            //  case -1: Toast toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);
            //           toast.show();
            //           break;
            //   }
        }

    //进入学习界面
    public void setButton_study_temp_onclick(View view){
        Intent intent = new Intent();
        intent.setClass(power_Activity.this, power_study_activity.class);//从power_activity页面跳转至study页面
        startActivity(intent);
    }
}
