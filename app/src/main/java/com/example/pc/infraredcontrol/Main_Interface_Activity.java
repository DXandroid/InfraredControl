package com.example.pc.infraredcontrol;

import android.app.Activity;
import android.app.WallpaperManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.os.strictmode.Violation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.MotionEvent;

public class Main_Interface_Activity extends AppCompatActivity {

    Infrared_Control in_con;
    boolean can_infrared;

    Button button_power,button_add,button_minus;

    TextView t,f;

    int F;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setEnterTransition(new Explode());
        setContentView(R.layout.activity_main_interface);
        intiset_button();
        //设定监听
        button_power.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        button_power.setScaleX((float)0.95);
                        button_power.setScaleY((float)0.95);
                        break;
                    case MotionEvent.ACTION_UP:
                        button_power.setScaleX(1);
                        button_power.setScaleY(1);
                        break;
                }
                return false;
            }
        });

        //把桌面背景设置为activity背景
        WallpaperManager  manager=WallpaperManager.getInstance(this);
        Drawable drawable=manager.getDrawable();
        this.getWindow().setBackgroundDrawable(drawable);

        t=findViewById(R.id.get);
        f=findViewById(R.id.number);

        can_infrared=false;
        in_con=new Infrared_Control((ConsumerIrManager)getSystemService(CONSUMER_IR_SERVICE));
    }


    /**
     * 初始化按键
     */
    private void intiset_button(){
        button_power=findViewById(R.id.power);
        //button_power.setEnabled(false);
        button_add=findViewById(R.id.add);
        button_add.setEnabled(false);
        button_minus=findViewById(R.id.minus);
        button_minus.setEnabled(false);
    }

    protected void onStart() {
        super.onStart();
//        if(in_con.equipment_judge_useful())
//           set_button_useful();
    }
    /**
     * 当设备有红外可用时才使所有按键有效
     */
    private void set_button_useful(){
        can_infrared=true;
        button_power.setEnabled(true);
    }
    public void button_power_onclick(View view){
        in_con.set_power();
        if (in_con.isPower()) {
            F = 25;
            button_add.setEnabled(true);
            button_minus.setEnabled(true);
        }
        else {
            F = 00;
            button_add.setEnabled(false);
            button_minus.setEnabled(false);
        }
        set_f();
        //in_con.get_mag(t);
    }
    public void button_add_onclick(View view){
        if(F<28)
        F++;
        set_f();
    }
    //github test
    public void button_minus_onclick(View view){
        if(F>23)
        F--;
        set_f();
    }

    private void set_f(){
        f.setText(String.valueOf(F));
    }

}
