package com.example.pc.infraredcontrol;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaRecorder;

public class Peripherals_Control {

    int frequency = 44100;//通信信号频率
    int channelConfiguration_in = AudioFormat.CHANNEL_IN_MONO;//CHANNEL_CONFIGURATION_MONO;
    int channelConfiguration_out = AudioFormat.CHANNEL_OUT_MONO;
    int audioEncoding = AudioFormat.ENCODING_PCM_16BIT;//编码制式

    int recBufSize = AudioRecord.getMinBufferSize(frequency,
            channelConfiguration_in, audioEncoding)*2;//接收缓冲区大小
    int plyBufSize = AudioTrack.getMinBufferSize(frequency,
            channelConfiguration_out, audioEncoding)*2;//发送缓冲区大小

    AudioRecord audioRecord;
    AudioTrack audioTrack;

    public int getRecBufSize() {
        return recBufSize;
    }


    Peripherals_Control(){
        audioRecord = new AudioRecord(MediaRecorder.AudioSource.VOICE_COMMUNICATION, frequency, channelConfiguration_in, audioEncoding, recBufSize);//安卓音频播放接口
        audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, frequency, channelConfiguration_out, audioEncoding, plyBufSize, AudioTrack.MODE_STREAM);//安卓音频接收接口
    }

    /***
     * 学习编码
     * @return
     */
    public byte[] Learn_code(){
        byte[] recBuf = new byte[recBufSize];
        return recBuf;
    }

    /**
     * 发送编码
     * @param recBuf 编码二进制数组
     */
    public void Send_code(byte recBuf){
        
    }

}
