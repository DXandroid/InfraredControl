package com.example.pc.infraredcontrol;

import android.hardware.ConsumerIrManager;
import android.os.Build;
import android.widget.TextView;

import com.example.pc.infraredcontrol.codecommand.Code_Command;

public class Infrared_Control {
    ConsumerIrManager IR;
    boolean isPower;
    Infrared_Control(ConsumerIrManager ir){
        IR=ir;
        isPower=false;
    }
    /**
     *发送红外信息的函数
     * @param carrierFrequency 红外传输频率
     * @param pattern 红外开光交替时间，单位微秒
     */
    private void send_IRMag(int carrierFrequency, int[] pattern){
        IR.transmit(carrierFrequency,pattern);
    }
    /**
     * 判断设备是否可用红外
     * @return
     */
    public boolean equipment_judge_useful(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT)
            if(IR.hasIrEmitter())
            return true;
        return false;
    }

    public boolean isPower() {
        return isPower;
    }

    public void set_power(){
        isPower=!isPower;
        //send_IRMag(38000, Code_Command.auto);
    }

    public void get_mag(TextView show){
        StringBuilder b=new StringBuilder();
        ConsumerIrManager.CarrierFrequencyRange[] freqs = IR.getCarrierFrequencies();
        b.append("IR Carrier Frequencies:\n");
        for (ConsumerIrManager.CarrierFrequencyRange range : freqs) {
            b.append(String.format("    %d - %d\n", range.getMinFrequency(), range.getMaxFrequency()));
        }
        show.setText(b.toString());
    }
}
