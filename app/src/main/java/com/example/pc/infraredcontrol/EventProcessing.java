package com.example.pc.infraredcontrol;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class EventProcessing extends Application {

    /**
     * 保存的配置文件的文件名
     */
    private String file_name = "Device.json";

    private String buttonName;

    /**
     * 已有的设备的设备编码字典列表
     */
    private List<Device> list_device;

    /**
     * 当前设备的设备编码字典
     */
    private Device current;

    /**
     * 当前设备的设备状态数组
     */
    private int[] deviceStatus;

    /**
     * 智能模式开关
     */
    boolean intelligent;

    /**
     * 编码字典类
     */
    class Device{
        String name;//设备名称
        Map<String,int[]> code = new HashMap<String,int[]>(){
            {
                put("power_on", null);//开关开
                put("power_off", null);//开关关
                put("mode_0", null);//自动模式
                put("mode_1", null);//除湿模式
                put("mode_2", null);//制冷模式
                put("mode_3", null);//制热模式
                put("mode_4", null);//送风模式
                put("speed_1", null);//风速1
                put("speed_2", null);//风速2
                put("speed_3", null);//风速3
                put("direction_1", null);//风向1
                put("direction_2", null);//风向2
                put("direction_3", null);//风向3
                put("temp_16", null);//温度16度
                put("temp_17", null);//温度17度
                put("temp_18", null);//温度18度
                put("temp_19", null);//温度19度
                put("temp_20", null);//温度20度
                put("temp_21", null);//温度21度
                put("temp_22", null);//温度22度
                put("temp_23", null);//温度23度
                put("temp_24", null);//温度24度
                put("temp_25", null);//温度25度
                put("temp_26", null);//温度26度
                put("temp_27", null);//温度27度
                put("temp_28", null);//温度28度
                put("temp_29", null);//温度29度
                put("temp_30", null);//温度30度
                put("timing", null);//定时
                put("sleep", null);//睡眠
                put("swing_on", null);//扫风开
                put("swing_off", null);//扫风关
            }
        };
    }

    /**
    * 将json字符串转换成object对象
 * @param json json字符串
 * @param c 对象类
 * @return object对象
 */
    private Object stringToObject( String json ,Class c){
        Gson gson =new Gson();
        return  gson.fromJson( json , c);
    }

    /**
     * 将object对象转换为json字符串
     * @param object object对象实列
     * @param <T> object对象类
     * @return 转换得到的json字符串
     */
    private   <T>String objectToString(T object) {
        Gson gson =new Gson();
        return gson.toJson(object);
    }

    /**
     * 将json字符串转换成对象列表
     * @param json json字符串
     * @param cls 对象列表
     * @param <T> 对象类型
     * @return 转换得到的对象列表
     */
    private  <T>  List<T> stringToList(String json ,Class<T> cls  ){
        Gson gson = new Gson();
        List<T> list = new ArrayList<T>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for(JsonElement elem : array){
            list.add(gson.fromJson(elem, cls));
        }
        return list;
    }

    /**
     * 写入私有目录文件
     * @param filename 文件名字
     * @param content 文件内容字符串
     */
    private void writeFileData(String filename, String content) {
        try{
            FileOutputStream fos = this.openFileOutput(filename,MODE_PRIVATE);

            byte[] bytes = content.getBytes();

            fos.write(bytes);

            fos.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 读取私有目录文件内容
     * @param fileName 文件名字
     * @return 文件内容字符串
     */
    private String readFileData(String fileName){
        String result = "";
        String filePath = getApplicationContext().getFilesDir().getPath()+"/"+file_name;
        if(!fileIsExists(filePath))
            return null;
        try{
            FileInputStream fis = this.openFileInput(fileName);
            int lenght = fis.available();
            byte[] buffer = new byte[lenght];
            fis.read(buffer);
            result = new String(buffer,"UTF-8");
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 初始化设备状态数组
     */
    private void initDeviceStatus(){
        deviceStatus = new int[]{0,0,1,2,24,0};
        intelligent=false;
    }

    private boolean fileIsExists(String strFile) {
        try
        {
            File f=new File(strFile);
            if(!f.exists())
            {
                return false;
            }

        }
        catch (Exception e)
        {
            return false;
        }

        return true;
    }

    private void saveConfigFile(Object configObject){
        String fileContent = objectToString(configObject);
        writeFileData(file_name,fileContent);
    }



    public int getlist_deviceLenght(){
        return list_device.size();
    }

    /**
     * 读取配置文件生成设备，返回一个字符串数组，存放设备名
     * @return 设备名字数组，返回NULL则不生成设备
     */
    public String[] generateDevice(){
        String device = readFileData(file_name);
        if(device==null){
            list_device = new ArrayList<>();
            return new String[]{""};
        }
        list_device= stringToList(device,Device.class);
        String[] returnValue = new String[list_device.size()];
        int i=0;
        for (Device t:list_device){
            returnValue[i]=t.name;
            i++;
        }
        return returnValue;
    }

    /**
     * 添加设备的方法，传递一个字符串参数作为设备名字
     * @param deviceName 要添加的设备名字
     * @return 操作码，返回0为成功，返回-1为失败
     */
    public int addDevice(String deviceName){
        Device newDevice = new Device();
        newDevice.name=deviceName;
        list_device.add(newDevice);


        saveConfigFile(list_device);
        current=newDevice;
        initDeviceStatus();


        return 0;
    }

    /**
     *打开设备的方法，传递一个字符串参数为设备名字
     * @param deviceName
     * @return 操作码，返回0为成功，返回-1为失败，返回1为该设备不存在
     */
    public int openDevice(String deviceName){
        for(Device d:list_device){
            if(d.name.equals(deviceName)) {
                current = d;
                initDeviceStatus();
                return 0;
            }
        }
        return 1;
    }

    /**
     * 获取红外编码，返回一个编码数组
     * @return 红外编码数组，返回NULL为获取失败
     */
    public int[] getCode(){
        return new int[]{0};
    }

    /**
     * 设置按键的编码，传递一个字符串为按键名字，传递一个编码数组为获取的编码数组
     * @param buttonName 按键名字字符串
     * @param code 红外编码数组
     * @return 操作码，返回0为成功，返回-1为失败
     */
    public int setButtonCode(String buttonName,int[] code){
        switch (buttonName){
            case "power_on":
            case "power_off":
            case "mode_0":
            case "mode_1":
            case "mode_2":
            case "mode_3":
            case "mode_4":
            case "speed_1":
            case "speed_2":
            case "speed_3":
            case "direction_1":
            case "direction_2":
            case "direction_3":
            case "temp_16":
            case "temp_17":
            case "temp_18":
            case "temp_19":
            case "temp_20":
            case "temp_21":
            case "temp_22":
            case "temp_23":
            case "temp_24":
            case "temp_25":
            case "temp_26":
            case "temp_27":
            case "temp_28":
            case "temp_29":
            case "temp_30":
            case "timing":
            case "sleep":
            case "swing_on":
            case "swing_off":
            current.code.put(buttonName,code);
            break;
            default:
                return -1;
        }
        return 0;
    }

    /**
     * 发送红外信号，传递一个字符串为发送的按键名字
     * @param buttonName 按键名字
     * @return 操作码，返回0为成功，返回-1为失败，返回1为按键暂未学习
     */
    public int sendInfrared(String buttonName){
        if(current.code.get(buttonName)==null)
            return 1;
        switch (buttonName){
            case "power_on":{deviceStatus[0]=1;break;}
            case "power_off":{deviceStatus[0]=0;break;}
            case "mode_0":{deviceStatus[1]=0;break;}
            case "mode_1":{deviceStatus[1]=1;break;}
            case "mode_2":{deviceStatus[1]=2;break;}
            case "mode_3":{deviceStatus[1]=3;break;}
            case "mode_4":{deviceStatus[1]=4;break;}
            case "speed_1":{deviceStatus[2]=1;break;}
            case "speed_2":{deviceStatus[2]=2;break;}
            case "speed_3":{deviceStatus[2]=3;break;}
            case "direction_1":{deviceStatus[3]=1;break;}
            case "direction_2":{deviceStatus[3]=2;break;}
            case "direction_3":{deviceStatus[3]=3;break;}
            case "temp_16":{deviceStatus[4]=16;break;}
            case "temp_17":{deviceStatus[4]=17;break;}
            case "temp_18":{deviceStatus[4]=18;break;}
            case "temp_19":{deviceStatus[4]=19;break;}
            case "temp_20":{deviceStatus[4]=20;break;}
            case "temp_21":{deviceStatus[4]=21;break;}
            case "temp_22":{deviceStatus[4]=22;break;}
            case "temp_23":{deviceStatus[4]=23;break;}
            case "temp_24":{deviceStatus[4]=24;break;}
            case "temp_25":{deviceStatus[4]=25;break;}
            case "temp_26":{deviceStatus[4]=26;break;}
            case "temp_27":{deviceStatus[4]=27;break;}
            case "temp_28":{deviceStatus[4]=28;break;}
            case "temp_29":{deviceStatus[4]=29;break;}
            case "temp_30":{deviceStatus[4]=30;break;}
            case "timing":{break;}
            case "sleep":{break;}
            case "swing_on":{deviceStatus[5]=1;break;}
            case "swing_off":{deviceStatus[5]=0;break;}
            default:
                return -1;
        }
        //此处发射红外信号
        return 0;
    }

    /**
     * 智能模式开关
     * @return 操作码 返回1为开，返回0为关，返回-1为失败
     */
    public int intelligentMode(){
        intelligent=!intelligent;
        return intelligent?1:0;
    }


    public void setButtonName(String name){
        buttonName=name;
    }


    public String getButtonName(){
        return buttonName;
    }
}
