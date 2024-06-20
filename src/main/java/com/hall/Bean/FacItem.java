package com.hall.Bean;

import java.util.ArrayList;
import java.util.Arrays;

public class FacItem {

    public static ArrayList<String> services =new ArrayList<>(Arrays.asList("免费停车位","付费停车位" ,"行李寄存","前台接待","管家式服务","团建会议"));
    public static ArrayList<String> basic =new ArrayList<>(Arrays.asList("无线网络","电梯" ,"落地窗","空调","暖气","晾衣架","电热水壶","沙发","电视","冰箱","洗衣机","空气净化器","加湿器","烘干机","净水器","免费瓶装水"));

    public static ArrayList<String> bathroom =new ArrayList<>(Arrays.asList("热水","独立卫浴" ,"电吹风","洗浴用品","牙具","浴巾","毛巾","干湿分离"));
    public static ArrayList<String> kitchen =new ArrayList<>(Arrays.asList("微波炉","餐具" ,"刀具菜板","烹饪锅具","电磁炉","燃气灶","洗涤用品","饮水机","餐桌"));
    public static ArrayList<String> surround =new ArrayList<>(Arrays.asList("超市","便利店","餐厅","药店","公园","儿童乐园","充电桩"));
    public static ArrayList<String> safety =new ArrayList<>(Arrays.asList("急救包","智能门锁" ,"门禁卡","可视对讲","保安","火灾警报器","灭火器"));
    public static ArrayList<String> entertainment =new ArrayList<>(Arrays.asList("投影设备","读书品茶"));
    public static ArrayList<String> leisure =new ArrayList<>(Arrays.asList("落地窗","玻璃房"));

    public static ArrayList<String> children =new ArrayList<>(Arrays.asList("儿童餐椅","防护设备","桌角防护"));

    public static ArrayList<ArrayList<String>> facItemTextList = new ArrayList<>(Arrays.asList(services,basic,bathroom,kitchen,surround,safety,entertainment,leisure,children));

    private String FacName;
    private boolean isVaild;

    public String getFacName() {
        return FacName;
    }

    public void setFacName(String facName) {
        FacName = facName;
    }

    public boolean isVaild() {
        return isVaild;
    }

    public void setVaild(boolean vaild) {
        isVaild = vaild;
    }
}
