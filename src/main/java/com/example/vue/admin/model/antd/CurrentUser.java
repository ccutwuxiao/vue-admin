package com.example.vue.admin.model.antd;

import java.util.List;

public class CurrentUser {

    /**
     * name : Serati Ma
     * avatar : https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png
     * userid : 00000001
     * email : antdesign@alipay.com
     * signature : 海纳百川，有容乃大
     * title : 交互专家
     * group : 蚂蚁金服－某某某事业群－某某平台部－某某技术部－UED
     * tags : [{"key":"0","label":"很有想法的"},{"key":"1","label":"专注设计"},{"key":"2","label":"辣~"},{"key":"3","label":"大长腿"},{"key":"4","label":"川妹子"},{"key":"5","label":"海纳百川"}]
     * notifyCount : 12
     * unreadCount : 11
     * country : China
     * geographic : {"province":{"label":"浙江省","key":"330000"},"city":{"label":"杭州市","key":"330100"}}
     * address : 西湖区工专路 77 号
     * phone : 0752-268888888
     */

    private String name;
    private String avatar;
    private String userid;
    private String email;
    private String signature;
    private String title;
    private String group;
    private int notifyCount;
    private int unreadCount;
    private String country;
    private GeographicBean geographic;
    private String address;
    private String phone;
    private List<TagsBean> tags;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getNotifyCount() {
        return notifyCount;
    }

    public void setNotifyCount(int notifyCount) {
        this.notifyCount = notifyCount;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public GeographicBean getGeographic() {
        return geographic;
    }

    public void setGeographic(GeographicBean geographic) {
        this.geographic = geographic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public static class GeographicBean {
        /**
         * province : {"label":"浙江省","key":"330000"}
         * city : {"label":"杭州市","key":"330100"}
         */

        private ProvinceBean province;
        private CityBean city;

        public ProvinceBean getProvince() {
            return province;
        }

        public void setProvince(ProvinceBean province) {
            this.province = province;
        }

        public CityBean getCity() {
            return city;
        }

        public void setCity(CityBean city) {
            this.city = city;
        }

        public static class ProvinceBean {
            /**
             * label : 浙江省
             * key : 330000
             */

            private String label;
            private String key;

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }
        }

        public static class CityBean {
            /**
             * label : 杭州市
             * key : 330100
             */

            private String label;
            private String key;

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }
        }
    }

    public static class TagsBean {
        /**
         * key : 0
         * label : 很有想法的
         */

        private String key;
        private String label;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }
}
