package com.myapplication.demo.bean;

import java.util.List;

public class CircleBean {
    /**
     * total : 9
     * per_page : 10
     * current_page : 1
     * last_page : 1
     * data : [{"id":3,"type":"image","title":"文字文字文字文字文字文字文字","images":[{"url":"http://ysf.com/static/index/img/noimage.png"}],"add_time":"2018-11-14 17:59","did":1,"content":"","dname":"辣条直营店","dlogo":"108","dtel":"18626896961","is_zhan":0,"is_manager":"0","comment_list":[{"id":12,"avatar":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLms53NQribxPXFnic09lqoicoGDHYhq1xpnSTfCGDqggPziancxicI0OwibBm8nLpuzP0Y3p8Pvs9degVw/132","username":"Leeqy","content":"4556","add_time":"1天前","is_manager":0},{"id":13,"avatar":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLms53NQribxPXFnic09lqoicoGDHYhq1xpnSTfCGDqggPziancxicI0OwibBm8nLpuzP0Y3p8Pvs9degVw/132","username":"Leeqy","content":"6667","add_time":"1天前","is_manager":0}],"zhan_list":[{"id":14,"avatar":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLms53NQribxPXFnic09lqoicoGDHYhq1xpnSTfCGDqggPziancxicI0OwibBm8nLpuzP0Y3p8Pvs9degVw/132","username":"Leeqy"}],"btn_show":1}]
     * is_manager : 0
     * new_count : 0
     * new_avatar :
     * new_username :
     * sharestr : e5fazYPJk+9EzaUj/ooxaItq8fZhR/oup3hRg0ofcMc7wXIAzjnV
     */

    private int total;
    private int per_page;
    private int current_page;
    private int last_page;
    private int is_manager;
    private int new_count;
    private String new_avatar;
    private String new_username;
    private String sharestr;
    private List<DataBean> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int getLast_page() {
        return last_page;
    }

    public void setLast_page(int last_page) {
        this.last_page = last_page;
    }

    public int getIs_manager() {
        return is_manager;
    }

    public void setIs_manager(int is_manager) {
        this.is_manager = is_manager;
    }

    public int getNew_count() {
        return new_count;
    }

    public void setNew_count(int new_count) {
        this.new_count = new_count;
    }

    public String getNew_avatar() {
        return new_avatar;
    }

    public void setNew_avatar(String new_avatar) {
        this.new_avatar = new_avatar;
    }

    public String getNew_username() {
        return new_username;
    }

    public void setNew_username(String new_username) {
        this.new_username = new_username;
    }

    public String getSharestr() {
        return sharestr;
    }

    public void setSharestr(String sharestr) {
        this.sharestr = sharestr;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 3
         * type : image
         * title : 文字文字文字文字文字文字文字
         * images : [{"url":"http://ysf.com/static/index/img/noimage.png"}]
         * add_time : 2018-11-14 17:59
         * did : 1
         * content :
         * dname : 辣条直营店
         * dlogo : 108
         * dtel : 18626896961
         * is_zhan : 0
         * is_manager : 0
         * comment_list : [{"id":12,"avatar":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLms53NQribxPXFnic09lqoicoGDHYhq1xpnSTfCGDqggPziancxicI0OwibBm8nLpuzP0Y3p8Pvs9degVw/132","username":"Leeqy","content":"4556","add_time":"1天前","is_manager":0},{"id":13,"avatar":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLms53NQribxPXFnic09lqoicoGDHYhq1xpnSTfCGDqggPziancxicI0OwibBm8nLpuzP0Y3p8Pvs9degVw/132","username":"Leeqy","content":"6667","add_time":"1天前","is_manager":0}]
         * zhan_list : [{"id":14,"avatar":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLms53NQribxPXFnic09lqoicoGDHYhq1xpnSTfCGDqggPziancxicI0OwibBm8nLpuzP0Y3p8Pvs9degVw/132","username":"Leeqy"}]
         * btn_show : 1
         */

        private int id;
        private String type;
        private String title;
        private String add_time;
        private int did;
        private String content;
        private String dname;
        private String dlogo;
        private String dtel;
        private int is_zhan;
        private String is_manager;
        private int btn_show;
        private List<ImagesBean> images;
        private List<CommentListBean> comment_list;
        private List<ZhanListBean> zhan_list;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public int getDid() {
            return did;
        }

        public void setDid(int did) {
            this.did = did;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDname() {
            return dname;
        }

        public void setDname(String dname) {
            this.dname = dname;
        }

        public String getDlogo() {
            return dlogo;
        }

        public void setDlogo(String dlogo) {
            this.dlogo = dlogo;
        }

        public String getDtel() {
            return dtel;
        }

        public void setDtel(String dtel) {
            this.dtel = dtel;
        }

        public int getIs_zhan() {
            return is_zhan;
        }

        public void setIs_zhan(int is_zhan) {
            this.is_zhan = is_zhan;
        }

        public String getIs_manager() {
            return is_manager;
        }

        public void setIs_manager(String is_manager) {
            this.is_manager = is_manager;
        }

        public int getBtn_show() {
            return btn_show;
        }

        public void setBtn_show(int btn_show) {
            this.btn_show = btn_show;
        }

        public List<ImagesBean> getImages() {
            return images;
        }

        public void setImages(List<ImagesBean> images) {
            this.images = images;
        }

        public List<CommentListBean> getComment_list() {
            return comment_list;
        }

        public void setComment_list(List<CommentListBean> comment_list) {
            this.comment_list = comment_list;
        }

        public List<ZhanListBean> getZhan_list() {
            return zhan_list;
        }

        public void setZhan_list(List<ZhanListBean> zhan_list) {
            this.zhan_list = zhan_list;
        }

        public static class ImagesBean {
            /**
             * url : http://ysf.com/static/index/img/noimage.png
             */

            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class CommentListBean {
            /**
             * id : 12
             * avatar : https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLms53NQribxPXFnic09lqoicoGDHYhq1xpnSTfCGDqggPziancxicI0OwibBm8nLpuzP0Y3p8Pvs9degVw/132
             * username : Leeqy
             * content : 4556
             * add_time : 1天前
             * is_manager : 0
             */

            private int id;
            private String avatar;
            private String username;
            private String content;
            private String add_time;
            private int is_manager;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public int getIs_manager() {
                return is_manager;
            }

            public void setIs_manager(int is_manager) {
                this.is_manager = is_manager;
            }
        }

        public static class ZhanListBean {
            /**
             * id : 14
             * avatar : https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLms53NQribxPXFnic09lqoicoGDHYhq1xpnSTfCGDqggPziancxicI0OwibBm8nLpuzP0Y3p8Pvs9degVw/132
             * username : Leeqy
             */

            private int id;
            private String avatar;
            private String username;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }
        }
    }
}
