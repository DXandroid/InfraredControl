package com.example.pc.infraredcontrol;
/*
* 空调控制界面
* */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Instant;
import java.util.HashMap;

public class power_Activity extends AppCompatActivity {

    EventProcessing EP;
    //显示text
    TextView temp,speed_text,mode_text,direction_text,swing_text,bra_text;
    //按钮
    Button button_power,button_mode,button_speed,button_dir,button_swing,button_minus,button_sleep,button_timing,button_add,button_bra,button_tit,button_study_temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.power_activity);
        //得到当前空调信息
        EP=(EventProcessing)getApplication();
        EP.getDeviceStatus();
        //初始化设置
        button_study_temp=(Button)findViewById(R.id.study_temp);//学习按键
        button_tit=(Button)findViewById(R.id.tit);//显示温度两个字
        button_tit.setEnabled(false);

        button_power=(Button)findViewById(R.id.power);//开关
        if(EP.getDeviceStatus()[0]==1){
            button_set();
            text_set();
        }else {
            button_off();
        }
    }
    /**
    * 初始化按钮
    * */
    void button_set(){
        button_add=(Button)findViewById(R.id.add);//加
        button_minus=(Button)findViewById(R.id.minus);//减
        button_bra=(Button)findViewById(R.id.brainpower);//智能遥控
        button_dir=(Button)findViewById(R.id.direction);//风向
        button_mode=(Button)findViewById(R.id.mode);//模式
        button_sleep=(Button)findViewById(R.id.sleep);//睡眠
        button_timing=(Button)findViewById(R.id.timing);//定时
        button_speed=(Button)findViewById(R.id.speed);//风速
        button_swing=(Button)findViewById(R.id.swing);//扫风

    }
    /**
     * 设置按键不可用，当空调处于关闭状态时
     * */
    void button_off(){
        button_add.setEnabled(false);
        button_minus.setEnabled(false);
        button_bra.setEnabled(false);
        button_dir.setEnabled(false);
        button_mode.setEnabled(false);
        button_sleep.setEnabled(false);
        button_timing.setEnabled(false);
        button_speed.setEnabled(false);
        button_swing.setEnabled(false);
    }

    /**
     * 初始化显示温度等信息的textview
     * */
    void text_set(){
        temp=(TextView)findViewById(R.id.temp_text);
        speed_text=(TextView)findViewById(R.id.speed_text);
        mode_text=(TextView)findViewById(R.id.mode_text);
        direction_text=(TextView)findViewById(R.id.direction_text);
        swing_text=(TextView)findViewById(R.id.swing_text);
        bra_text=(TextView)findViewById(R.id.brainpower_text);
        //显示初始化的信息
        //温度
        temp.setText(EP.getDeviceStatus()[4]);
        //风速
        switch (EP.getDeviceStatus()[2]){
            case 1: speed_text.setText("慢");break;
            case 2: speed_text.setText("中");break;
            case 3: speed_text.setText("快");break;
        }
        //模式
        switch (EP.getDeviceStatus()[1]){
            case 0: mode_text.setText("自动");break;
            case 1: mode_text.setText("除湿");break;
            case 2: mode_text.setText("制冷");break;
            case 3: mode_text.setText("制热");break;
            case 4: mode_text.setText("送风");break;
        }
        //风向
        switch (EP.getDeviceStatus()[3]){
            case 1:direction_text.setText("上");break;
            case 2:direction_text.setText("中");break;
            case 3:direction_text.setText("下");break;
        }
        //扫风
        switch(EP.getDeviceStatus()[5]){
            case 0:swing_text.setText("扫风关");break;
            case 1:swing_text.setText("扫风开");break;
        }
        //智能模式默认为关
        bra_text.setText("关闭");
    }
    /**
     * 按钮点击事件*/
    /**
     * 开关点击事件
     * */
    public void setButton_power_onclick(View view)
    {
        Toast toast;
        switch (EP.getDeviceStatus()[0]){
            case 0: switch (EP.sendInfrared("power_on")){
                case 0: break;
                case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            case 1: switch (EP.sendInfrared("power_off")){
                    case 0:
                    case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                    case 2: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
        }

    }
    /**
     * 温度增加按钮
     * */

    public void setButton_add_onclick(View view) {
        Toast toast;
        switch (EP.getDeviceStatus()[4]){
            //初始温度是16度
            case 16: switch (EP.sendInfrared("temp_17")){
                case 0: temp.setText("17");break;
                case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            //初始温度是17度
            case 17: switch (EP.sendInfrared("temp_18")){
                case 0:  temp.setText("18");break;
                case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case 2: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            //初始温度是18度
            case 18: switch (EP.sendInfrared("temp_19")){
                case 0: temp.setText("19");break;
                case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            //初始温度是19度
            case 19: switch (EP.sendInfrared("temp_20")){
                case 0: temp.setText("20");break;
                case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            //初始温度是20度
            case 20:switch (EP.sendInfrared("temp_21")){
                case 0: temp.setText("21");break;
                case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            //初始温度是21度
            case 21:switch (EP.sendInfrared("temp_22")){
                case 0: temp.setText("22");break;
                case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            //初始温度是22度
            case 22:switch (EP.sendInfrared("temp_23")){
                case 0: temp.setText("23");break;
                case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            //初始温度是23度
            case 23:switch (EP.sendInfrared("temp_24")){
                case 0: temp.setText("24");break;
                case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            //初始温度是24度
            case 24:switch (EP.sendInfrared("temp_25")){
                case 0: temp.setText("25");break;
                case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            //初始温度是25度
            case 25:switch (EP.sendInfrared("temp_26")){
                case 0: temp.setText("26");break;
                case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            //初始温度是26度
            case 26:switch (EP.sendInfrared("temp_27")){
                case 0: temp.setText("27");break;
                case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            //初始温度是27度
            case 27:switch (EP.sendInfrared("temp_28")){
                case 0: temp.setText("27");break;
                case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            //初始温度是28度
            case 28:switch (EP.sendInfrared("temp_29")){
                case 0: temp.setText("28");break;
                case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            //初始温度是29度
            case 29:switch (EP.sendInfrared("temp_30")){
                case 0: temp.setText("30");break;
                case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            //初始温度是30度
            case 30: break;
        }
    }
    /**
     * 温度减少按钮
     * */
    public void setButton_minus_onclick(View view) {
       Toast toast;
       switch (EP.getDeviceStatus()[4]){
           //初始温度是16
           case 16: break;
           //初始温度是17
           case 17: switch (EP.sendInfrared("temp_16")){
               case 0: temp.setText("16");break;
               case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
               case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
           }break;
           //初始温度是18
           case 18: switch (EP.sendInfrared("temp_17")){
               case 0: temp.setText("17");break;
               case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
               case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
           }break;
           //初始温度是19
           case 19: switch (EP.sendInfrared("temp_18")){
               case 0: temp.setText("18");break;
               case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
               case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
           }break;
           //初始温度是20
           case 20: switch (EP.sendInfrared("temp_19")){
               case 0: temp.setText("19");break;
               case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
               case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
           }break;
           //初始温度是21
           case 21: switch (EP.sendInfrared("temp_20")){
               case 0: temp.setText("20");break;
               case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
               case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
           }break;
           //初始温度是22
           case 22: switch (EP.sendInfrared("temp_21")){
               case 0: temp.setText("21");break;
               case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
               case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
           }break;
           //初始温度是23
           case 23: switch (EP.sendInfrared("temp_22")){
               case 0: temp.setText("22");break;
               case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
               case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
           }break;
           //初始温度是24
           case 24: switch (EP.sendInfrared("temp_23")){
               case 0: temp.setText("23");break;
               case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
               case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
           }break;
           //初始温度是25
           case 25: switch (EP.sendInfrared("temp_24")){
               case 0: temp.setText("24");break;
               case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
               case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
           }break;
           //初始温度是26
           case 26: switch (EP.sendInfrared("temp_25")){
               case 0: temp.setText("25");break;
               case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
               case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
           }break;
           //初始温度是27
           case 27: switch (EP.sendInfrared("temp_26")){
               case 0: temp.setText("26");break;
               case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
               case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
           }break;
           //初始温度是28
           case 28: switch (EP.sendInfrared("temp_27")){
               case 0: temp.setText("27");break;
               case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
               case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
           }break;
           //初始温度是17
           case 29: switch (EP.sendInfrared("temp_28")){
               case 0: temp.setText("28");break;
               case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
               case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
           }break;
           //初始温度是30
           case 30: switch (EP.sendInfrared("temp_29")){
               case 0: temp.setText("29");break;
               case 1: toast= Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
               case -1: toast= Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
           }break;
       }
    }
    /**
     * 风速事件
     * */
    public void setButton_speed_onclick(View view) {
        Toast toast;
        switch (EP.getDeviceStatus()[2]){
            //初始为慢
            case 1: switch (EP.sendInfrared("speed_2")){
                case 0: speed_text.setText("中");break;
                case 1: toast=Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1:toast=Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            //初始为中
            case 2: switch (EP.sendInfrared("speed_3")){
                case 0: speed_text.setText("快");break;
                case 1: toast=Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1:toast=Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            //初始为快
            case 3: switch (EP.sendInfrared("speed_1")){
                case 0: speed_text.setText("慢");break;
                case 1: toast=Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1:toast=Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
        }
        }

    /**
     * 模式事件
     * */
    public void setButton_mode_onclick(View view) {
        Toast toast;
        switch (EP.getDeviceStatus()[1]){
            //初始为自动
            case 0: switch (EP.sendInfrared("mode_1")){
                case 0: mode_text.setText("除湿");break;
                case 1: toast=Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1:toast=Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            //初始为除湿
            case 1: switch (EP.sendInfrared("mode_2")){
                case 0: mode_text.setText("制冷");break;
                case 1: toast=Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1:toast=Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            //初始为制冷
            case 2: switch (EP.sendInfrared("mode_3")){
                case 0: mode_text.setText("制热");break;
                case 1: toast=Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1:toast=Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            //初始为制热
            case 3: switch (EP.sendInfrared("mode_4")){
                case 0: mode_text.setText("送风");break;
                case 1: toast=Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1:toast=Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            //初始为送风
            case 4: switch (EP.sendInfrared("mode_0")){
                case 0: mode_text.setText("自动");break;
                case 1: toast=Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1:toast=Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
        }
    }


    /**
     * 风向
     * */
    public void setButton_dir_onclick(View view) {
        Toast toast;
        switch (EP.getDeviceStatus()[3]){
            //初始为上
            case 1: switch (EP.sendInfrared("direction_2")){
                case 0: direction_text.setText("中");break;
                case 1: toast=Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1:toast=Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            //初始为中
            case 2: switch (EP.sendInfrared("direction_3")){
                case 0: direction_text.setText("下");break;
                case 1: toast=Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1:toast=Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            //初始为下
            case 3: switch (EP.sendInfrared("direction_1")){
                case 0: direction_text.setText("上");break;
                case 1: toast=Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1:toast=Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
        }
    }

   /**
    * 定时事件
    * */
    public void setButton_timing_onclick(View view) {

        }
/**
 * 睡眠事件
 * */
    public void setButton_sleep_onclick(View view) {

        }
/**
 * 扫风事件
 * */
    public void setButton_swing_onclick(View view) {
        Toast toast;
        switch (EP.getDeviceStatus()[5]){
            //初始为0
            case 0: switch (EP.sendInfrared("swing_on")){
                case 0: swing_text.setText("扫风开");break;
                case 1: toast=Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1:toast=Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
            //初始为1
            case 1: switch (EP.sendInfrared("swing_off")){
                case 0: swing_text.setText("扫风关");break;
                case 1: toast=Toast.makeText(power_Activity.this,"请先进行学习",Toast.LENGTH_LONG);toast.show();break;
                case -1:toast=Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();break;
            }break;
        }
        }
/**
 * 智能模式键
 * */
    public void setButton_bra_onclick(View view) {
        Toast toast;
            switch (EP.intelligentMode()){
                case 0: bra_text.setText("关");break;
                case 1: bra_text.setText("开");break;
                    default: toast=Toast.makeText(power_Activity.this,"发送失败",Toast.LENGTH_LONG);toast.show();
            }
        }
/**
 * 进入学习事件键
 * */
    public void setButton_study_temp_onclick(View view){
        Intent intent = new Intent();
        intent.setClass(power_Activity.this, power_study_activity.class);//从power_activity页面跳转至study页面
        startActivity(intent);
    }
}
