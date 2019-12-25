package com.myapplication.demo.bean;

import java.util.List;

public class ActiveEntity {


    /**
     * code : 1
     * msg : 店铺圈
     * time : 1577175176
     * data : {"total":9,"per_page":10,"current_page":1,"last_page":1,"data":[{"id":3,"type":"image","title":"文字文字文字文字文字文字文字","images":[{"url":"http://ysf.com/static/index/img/noimage.png"}],"add_time":"2018-11-14 17:59","did":1,"content":"","dname":"辣条直营店","dlogo":"108","dtel":"18626896961","is_zhan":0,"is_manager":"0","comment_list":[{"id":12,"avatar":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLms53NQribxPXFnic09lqoicoGDHYhq1xpnSTfCGDqggPziancxicI0OwibBm8nLpuzP0Y3p8Pvs9degVw/132","username":"Leeqy","content":"4556","add_time":"1天前","is_manager":0},{"id":13,"avatar":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLms53NQribxPXFnic09lqoicoGDHYhq1xpnSTfCGDqggPziancxicI0OwibBm8nLpuzP0Y3p8Pvs9degVw/132","username":"Leeqy","content":"6667","add_time":"1天前","is_manager":0}],"zhan_list":[{"id":14,"avatar":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLms53NQribxPXFnic09lqoicoGDHYhq1xpnSTfCGDqggPziancxicI0OwibBm8nLpuzP0Y3p8Pvs9degVw/132","username":"Leeqy"}],"btn_show":1}],"is_manager":0,"new_count":0,"new_avatar":"","new_username":"","sharestr":"e5fazYPJk+9EzaUj/ooxaItq8fZhR/oup3hRg0ofcMc7wXIAzjnV"}
     */

    private int code;
    private String msg;
    private String time;
    private DataBeanX data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {

    }
}
