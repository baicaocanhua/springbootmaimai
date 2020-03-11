package com.maimai.springbootdev;

import java.util.List;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-03-11 10:38
 **/
public class MaiMai {

    /**
     * errcode : 0
     * errmsg : ok
     * checkindata : [{"userid":"james","groupname":"打卡一组","checkin_type":"上班打卡","exception_type":"地点异常","checkin_time":1492617610,"location_title":"依澜府","location_detail":"四川省成都市武侯区益州大道中段784号附近","wifiname":"办公一区","notes":"路上堵车，迟到了5分钟","wifimac":"3c:46:d8:0c:7a:70","mediaids":["WWCISP_G8PYgRaOVHjXWUWFqchpBqqqUpGj0OyR9z6WTwhnMZGCPHxyviVstiv_2fTG8YOJq8L8zJT2T2OvTebANV-2MQ"]},{"userid":"paul","groupname":"打卡二组","checkin_type":"外出打卡","exception_type":"时间异常","checkin_time":1492617620,"location_title":"重庆出口加工区","location_detail":"重庆市渝北区金渝大道101号金渝大道","wifiname":"办公室二区","notes":"","wifimac":"3c:46:d8:0c:7a:71","mediaids":["WWCISP_G8PYgRaOVHjXWUWFqchpBqqqUpGj0OyR9z6WTwhnMZGCPHxyviVstiv_2fTG8YOJq8L8zJT2T2OvTebANV-2MQ"],"lat":30547645,"lng":104063236,"deviceid":"E5FA89F6-3926-4972-BE4F-4A7ACF4701E2"}]
     */

    private int errcode;
    private String errmsg;
    private List<CheckindataBean> checkindata;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public List<CheckindataBean> getCheckindata() {
        return checkindata;
    }

    public void setCheckindata(List<CheckindataBean> checkindata) {
        this.checkindata = checkindata;
    }

    public static class CheckindataBean {
        /**
         * userid : james
         * groupname : 打卡一组
         * checkin_type : 上班打卡
         * exception_type : 地点异常
         * checkin_time : 1492617610
         * location_title : 依澜府
         * location_detail : 四川省成都市武侯区益州大道中段784号附近
         * wifiname : 办公一区
         * notes : 路上堵车，迟到了5分钟
         * wifimac : 3c:46:d8:0c:7a:70
         * mediaids : ["WWCISP_G8PYgRaOVHjXWUWFqchpBqqqUpGj0OyR9z6WTwhnMZGCPHxyviVstiv_2fTG8YOJq8L8zJT2T2OvTebANV-2MQ"]
         * lat : 30547645
         * lng : 104063236
         * deviceid : E5FA89F6-3926-4972-BE4F-4A7ACF4701E2
         */

        private String userid;
        private String groupname;
        private String checkin_type;
        private String exception_type;
        private int checkin_time;
        private String location_title;
        private String location_detail;
        private String wifiname;
        private String notes;
        private String wifimac;
        private int lat;
        private int lng;
        private String deviceid;
        private List<String> mediaids;

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getGroupname() {
            return groupname;
        }

        public void setGroupname(String groupname) {
            this.groupname = groupname;
        }

        public String getCheckin_type() {
            return checkin_type;
        }

        public void setCheckin_type(String checkin_type) {
            this.checkin_type = checkin_type;
        }

        public String getException_type() {
            return exception_type;
        }

        public void setException_type(String exception_type) {
            this.exception_type = exception_type;
        }

        public int getCheckin_time() {
            return checkin_time;
        }

        public void setCheckin_time(int checkin_time) {
            this.checkin_time = checkin_time;
        }

        public String getLocation_title() {
            return location_title;
        }

        public void setLocation_title(String location_title) {
            this.location_title = location_title;
        }

        public String getLocation_detail() {
            return location_detail;
        }

        public void setLocation_detail(String location_detail) {
            this.location_detail = location_detail;
        }

        public String getWifiname() {
            return wifiname;
        }

        public void setWifiname(String wifiname) {
            this.wifiname = wifiname;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public String getWifimac() {
            return wifimac;
        }

        public void setWifimac(String wifimac) {
            this.wifimac = wifimac;
        }

        public int getLat() {
            return lat;
        }

        public void setLat(int lat) {
            this.lat = lat;
        }

        public int getLng() {
            return lng;
        }

        public void setLng(int lng) {
            this.lng = lng;
        }

        public String getDeviceid() {
            return deviceid;
        }

        public void setDeviceid(String deviceid) {
            this.deviceid = deviceid;
        }

        public List<String> getMediaids() {
            return mediaids;
        }

        public void setMediaids(List<String> mediaids) {
            this.mediaids = mediaids;
        }
    }
}
