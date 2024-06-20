package com.hall.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Facilities {
    public static ArrayList<String> facGroupList =new ArrayList<>(Arrays.asList("服务","基础" ,"卫浴","厨房","周边","安全","娱乐","休闲","儿童" ));




    private String group;

    private List<FacItem> items;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<FacItem> getItems() {
        return items;
    }

    public void setItems(List<FacItem> items) {
        this.items = items;
    }
}
