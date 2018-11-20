package com.example.pc.infraredcontrol;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Button_Learn extends AppCompatActivity {

    EventProcessing EP;
    Button back, cancel, save;
    int[] code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button__learn);
        EP = (EventProcessing) getApplication();
        back = findViewById(R.id.back);
        cancel = findViewById(R.id.cancel);
        save = findViewById(R.id.save);

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

}