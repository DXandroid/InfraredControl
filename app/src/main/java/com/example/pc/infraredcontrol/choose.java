package com.example.pc.infraredcontrol;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.app.LauncherActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.drm.DrmErrorEvent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class choose extends AppCompatActivity {
    EventProcessing EP;
    private ListView devicelist;
    private  String[] names;

    //定义一个simpleAdapter,供列表项使用
    SimpleAdapter simpleAdapter;

    class MyBaseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return names [position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }




        @Override
        public View getView(int position, View convertView, ViewGroup parent) {//组装数据
            View view=View.inflate(choose.this,R.layout.sublist,null);//在list_item中有两个id,现在要把他们拿过来
            TextView mTextView=view.findViewById(R.id.devicename);
            //组件一拿到，开始组装
            mTextView.setText(names[position]);
            //组装完开始返回
            return view;

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        EP= (EventProcessing) getApplication();
    }

    @Override
    protected void onStart() {
        super.onStart();
        names=EP.generateDevice();
        devicelist=findViewById(R.id.device);
        devicelist.setAdapter(new MyBaseAdapter());


        //长按监听

        devicelist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            //定义AlertDialog.Builder对象，当长按列表项的时候弹出确认删除对话框
            new AlertDialog.Builder(choose.this)
            .setMessage("确定删除?")
            .setTitle("提示")

                //添加AlertDialog.Builder对象的setPositiveButton()方法
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        Toast.makeText(getBaseContext(), "删除列表项", Toast.LENGTH_SHORT).show();
                    }
                })

            //添加AlertDialog.Builder对象的setNegativeButton()方法
           .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            })
            .create().show();
            return true;
        }
        });



        devicelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (EP.getlist_deviceLenght()!=0)
                EP.openDevice((String)adapterView.getItemAtPosition(i));
                app_intiset();
            }
        });
    }

    public void ddt(View view){
        final EditText et = new EditText(this);
        new AlertDialog.Builder(this).
                setTitle("请给新设备一个名字").
                setView(et).
                setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String name = et.getText().toString();
                                EP.addDevice(name);
                                app_intiset();
                            }
                        }).create().show();
    }


    private void app_intiset() {
        /*
        //界面跳转intent，并设置flags，清除活动堆栈并让跳转的界面置为活动堆栈底
         */
        Intent intent = new Intent(choose.this,power_Activity.class);
        /*
        跳转界面，并传递android5.0转场动画bundle
         */
        startActivity(intent/*, ActivityOptions.makeSceneTransitionAnimation(this).toBundle()*/);
    }


}
