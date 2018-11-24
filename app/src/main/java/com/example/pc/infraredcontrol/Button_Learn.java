package com.example.pc.infraredcontrol;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Button_Learn extends AppCompatActivity implements View.OnClickListener{

    EventProcessing EP;
    Button back, cancel, save,learn;
    int[] code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button__learn);
        EP = (EventProcessing) getApplication();

        cancel = findViewById(R.id.cancel);
        save = findViewById(R.id.save);
        back = findViewById(R.id.back);
        back.setOnClickListener(this);
        learn = findViewById(R.id.learn);
        learn.setText(EP.getButtonName());



    }

    @Override
    protected void onStart() {
        super.onStart();
        setButton();


    }

    private void setButton(){
        code = EP.getCode();
        if(code == null){
            cancel.setText("重新学习");
        }
        else{
            cancel.setText("取消");
            save.setBackgroundColor(Color.parseColor("#f34649"));
        }
    }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                this.finish();
                break;
        }
    }
}