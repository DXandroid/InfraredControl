package com.example.pc.infraredcontrol;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Class aClass;
    ImageView ib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* ib=findViewById(R.id.ib);
        Drawable drawable=ib.getDrawable();
        ((Animatable)drawable).start();
        aClass=activity_study.class;*/
    }

    @Override
    protected void onStart() {
        super.onStart();
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
app_intiset();
    }

    /**
     * 界面跳转
     */
    private void app_intiset(){
        /*
        //界面跳转intent，并设置flags，清除活动堆栈并让跳转的界面置为活动堆栈底
         */
        Intent intent= new Intent(this,activity_study.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        /*
        跳转界面，并传递android5.0转场动画bundle
         */
        startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
}
