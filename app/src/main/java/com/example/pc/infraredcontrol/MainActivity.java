package com.example.pc.infraredcontrol;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Class aClass;
    ImageView iag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app_intiset();
        aClass=activity_study.class;
        iag =findViewById(R.id.imageView);

        //app_intiset();
    }

//    private boolean isTwitterChecked = false;
//    public void cc(View view){
//        isTwitterChecked = !isTwitterChecked;
//        final int[] stateSet = {android.R.attr.state_checked * (isTwitterChecked ? 1 : -1)};
//        iag.setImageState(stateSet, true);
//    }
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
