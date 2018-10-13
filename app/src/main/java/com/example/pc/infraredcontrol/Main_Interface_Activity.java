package com.example.pc.infraredcontrol;

import android.app.WallpaperManager;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main_Interface_Activity extends AppCompatActivity {

    Infrared_Control in_con;
    boolean can_infrared;

    Button button_power,button_add,button_minus;

    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_interface);
        intiset_button();
        //加载第一份动画效果
       // final Animation anim = AnimationUtils;
        //把桌面背景设置为activity背景
        WallpaperManager  manager=WallpaperManager.getInstance(this);
        Drawable drawable=manager.getDrawable();
        this.getWindow().setBackgroundDrawable(drawable);

        t=findViewById(R.id.get);

        can_infrared=false;
        in_con=new Infrared_Control((ConsumerIrManager) getSystemService(CONSUMER_IR_SERVICE));
    }

    private void intiset_button(){
        button_power=findViewById(R.id.power);
        button_power.setEnabled(false);
        button_add=findViewById(R.id.add);
        button_add.setEnabled(false);
        button_minus=findViewById(R.id.minus);
        button_minus.setEnabled(false);
    }

    protected void onStart() {
        super.onStart();
        if(in_con.equipment_judge_useful())
            set_button_useful();
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
        //in_con.get_mag(t);
    }
    public void button_add_onclick(View view){

    }
    //github test
    public void button_minus_onclick(View view){

    }

}
