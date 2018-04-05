package com.yanftch.applibrary.net;

import java.util.List;

/**
 * Author : yanftch
 * Date : 2018/2/8
 * Time : 16:39
 * Desc :
 */

public class MyTestBean extends BaseResponse {

    private ProductIntrBean productIntr;
    private List<HotProductBean> hotProduct;
    private List<HomeProductListBean> HomeProductList;
    private List<BannerListBean> bannerList;
    private List<HeadlineListBean> headlineList;
    private List<HighHotProductBean> highHotProduct;

    public ProductIntrBean getProductIntr() {
        return productIntr;
    }

    public void setProductIntr(ProductIntrBean productIntr) {
        this.productIntr = productIntr;
    }

    public List<HotProductBean> getHotProduct() {
        return hotProduct;
    }

    public void setHotProduct(List<HotProductBean> hotProduct) {
        this.hotProduct = hotProduct;
    }

    public List<HomeProductListBean> getHomeProductList() {
        return HomeProductList;
    }

    public void setHomeProductList(List<HomeProductListBean> HomeProductList) {
        this.HomeProductList = HomeProductList;
    }

    public List<BannerListBean> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<BannerListBean> bannerList) {
        this.bannerList = bannerList;
    }

    public List<HeadlineListBean> getHeadlineList() {
        return headlineList;
    }

    public void setHeadlineList(List<HeadlineListBean> headlineList) {
        this.headlineList = headlineList;
    }

    public List<HighHotProductBean> getHighHotProduct() {
        return highHotProduct;
    }

    public void setHighHotProduct(List<HighHotProductBean> highHotProduct) {
        this.highHotProduct = highHotProduct;
    }

    public static class ProductIntrBean {
        /**
         * piNo : 64d7561d161d41e090f0d27140be8cec
         * piTitle : 图解安邦龙腾
         * imageUrl : https://s3.cn-north-1.amazonaws.com.cn/uploadfiles/activityFile/5b8504370d2f40e08f3d25f9ad76a05f.png
         * tagUri : http://dat.dahuobaoxian.com/custserv/activity/item/diagram/newlongteng/longteng.html
         * type : 4
         * state : 1
         * sort : null
         * createDate : 1516268179000
         * startTime : null
         * endTime : null
         * productNo :
         * iconurl :
         * des : null
         */

        private String piNo;
        private String piTitle;
        private String imageUrl;
        private String tagUri;
        private String type;
        private String state;
        private Object sort;
        private long createDate;
        private Object startTime;
        private Object endTime;
        private String productNo;
        private String iconurl;
        private Object des;

        public String getPiNo() {
            return piNo;
        }

        public void setPiNo(String piNo) {
            this.piNo = piNo;
        }

        public String getPiTitle() {
            return piTitle;
        }

        public void setPiTitle(String piTitle) {
            this.piTitle = piTitle;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getTagUri() {
            return tagUri;
        }

        public void setTagUri(String tagUri) {
            this.tagUri = tagUri;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public Object getSort() {
            return sort;
        }

        public void setSort(Object sort) {
            this.sort = sort;
        }

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public Object getStartTime() {
            return startTime;
        }

        public void setStartTime(Object startTime) {
            this.startTime = startTime;
        }

        public Object getEndTime() {
            return endTime;
        }

        public void setEndTime(Object endTime) {
            this.endTime = endTime;
        }

        public String getProductNo() {
            return productNo;
        }

        public void setProductNo(String productNo) {
            this.productNo = productNo;
        }

        public String getIconurl() {
            return iconurl;
        }

        public void setIconurl(String iconurl) {
            this.iconurl = iconurl;
        }

        public Object getDes() {
            return des;
        }

        public void setDes(Object des) {
            this.des = des;
        }
    }

    public static class HotProductBean {
        /**
         * productNo : 310102002
         * supplierCode : 2160423
         * productName : 和谐定投长期护理保险
         * description : 18周岁-59周岁| 保险期限：至85周岁
         * detailUrl : http://dat.dahuobaoxian.com/cms/wwwroot/dahuo/health/3101C20170619001.shtml
         * price : 1000.00
         * maxProfit : 4%
         * maxProfitDescription : null
         * imgUrl : https://s3.cn-north-1.amazonaws.com.cn/uploadfiles/eriskfile/ERiskPic/310102002.png
         * brightSpot : <p>财富管理与保障兼顾</p><p>分期投入 灵活支取</p>
         * saleNum : 234
         * label : null
         * category :
         * planName : null
         * toTop : 0
         * comCode : null
         * status : null
         */

        private String productNo;
        private String supplierCode;
        private String productName;
        private String description;
        private String detailUrl;
        private String price;
        private String maxProfit;
        private Object maxProfitDescription;
        private String imgUrl;
        private String brightSpot;
        private String saleNum;
        private Object label;
        private String category;
        private Object planName;
        private int toTop;
        private Object comCode;
        private Object status;

        public String getProductNo() {
            return productNo;
        }

        public void setProductNo(String productNo) {
            this.productNo = productNo;
        }

        public String getSupplierCode() {
            return supplierCode;
        }

        public void setSupplierCode(String supplierCode) {
            this.supplierCode = supplierCode;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDetailUrl() {
            return detailUrl;
        }

        public void setDetailUrl(String detailUrl) {
            this.detailUrl = detailUrl;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getMaxProfit() {
            return maxProfit;
        }

        public void setMaxProfit(String maxProfit) {
            this.maxProfit = maxProfit;
        }

        public Object getMaxProfitDescription() {
            return maxProfitDescription;
        }

        public void setMaxProfitDescription(Object maxProfitDescription) {
            this.maxProfitDescription = maxProfitDescription;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getBrightSpot() {
            return brightSpot;
        }

        public void setBrightSpot(String brightSpot) {
            this.brightSpot = brightSpot;
        }

        public String getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(String saleNum) {
            this.saleNum = saleNum;
        }

        public Object getLabel() {
            return label;
        }

        public void setLabel(Object label) {
            this.label = label;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public Object getPlanName() {
            return planName;
        }

        public void setPlanName(Object planName) {
            this.planName = planName;
        }

        public int getToTop() {
            return toTop;
        }

        public void setToTop(int toTop) {
            this.toTop = toTop;
        }

        public Object getComCode() {
            return comCode;
        }

        public void setComCode(Object comCode) {
            this.comCode = comCode;
        }

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
            this.status = status;
        }
    }

    public static class HomeProductListBean {
        /**
         * id : c0c4f123908d4b8fa3ae7470e68b76b2
         * name : 有实力
         * description : 康利二号
         * identity : AB_HX
         * roleType : 4
         * imgUrl : https://s3.cn-north-1.amazonaws.com.cn/uploadfiles/eriskfile/ERiskPic/878a879acdfc4e21b25dcf004fda605d.png
         * sort : 1
         * productNo : 310101025
         * detailUrl : https://www.dahuobaoxian.com/cms/wwwroot/dahuo/health/3101C20171026002.shtml
         * price : 5000.00
         */

        private String id;
        private String name;
        private String description;
        private String identity;
        private String roleType;
        private String imgUrl;
        private int sort;
        private String productNo;
        private String detailUrl;
        private String price;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIdentity() {
            return identity;
        }

        public void setIdentity(String identity) {
            this.identity = identity;
        }

        public String getRoleType() {
            return roleType;
        }

        public void setRoleType(String roleType) {
            this.roleType = roleType;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getProductNo() {
            return productNo;
        }

        public void setProductNo(String productNo) {
            this.productNo = productNo;
        }

        public String getDetailUrl() {
            return detailUrl;
        }

        public void setDetailUrl(String detailUrl) {
            this.detailUrl = detailUrl;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }

    public static class BannerListBean {
        /**
         * adNo : 310101012
         * adTitle : 健康之尊
         * imageUrl : https://s3.cn-north-1.amazonaws.com.cn/uploadfiles/systempic/JKZZ2.png
         * adUri : https://www.dahuobaoxian.com/cms/wwwroot/dahuo/health/310120170309001.shtml
         * adType : 1
         * state : null
         * sort : 0
         * createDate : null
         * startTime : null
         * endTime : null
         * activityId : 0
         * productNo :
         */

        private String adNo;
        private String adTitle;
        private String imageUrl;
        private String adUri;
        private String adType;
        private Object state;
        private int sort;
        private Object createDate;
        private Object startTime;
        private Object endTime;
        private int activityId;
        private String productNo;

        public String getAdNo() {
            return adNo;
        }

        public void setAdNo(String adNo) {
            this.adNo = adNo;
        }

        public String getAdTitle() {
            return adTitle;
        }

        public void setAdTitle(String adTitle) {
            this.adTitle = adTitle;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getAdUri() {
            return adUri;
        }

        public void setAdUri(String adUri) {
            this.adUri = adUri;
        }

        public String getAdType() {
            return adType;
        }

        public void setAdType(String adType) {
            this.adType = adType;
        }

        public Object getState() {
            return state;
        }

        public void setState(Object state) {
            this.state = state;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public Object getCreateDate() {
            return createDate;
        }

        public void setCreateDate(Object createDate) {
            this.createDate = createDate;
        }

        public Object getStartTime() {
            return startTime;
        }

        public void setStartTime(Object startTime) {
            this.startTime = startTime;
        }

        public Object getEndTime() {
            return endTime;
        }

        public void setEndTime(Object endTime) {
            this.endTime = endTime;
        }

        public int getActivityId() {
            return activityId;
        }

        public void setActivityId(int activityId) {
            this.activityId = activityId;
        }

        public String getProductNo() {
            return productNo;
        }

        public void setProductNo(String productNo) {
            this.productNo = productNo;
        }
    }

    public static class HeadlineListBean {
        /**
         * headlineId : 48737d6c7f8f40fa8ae1769b1cb527c6
         * headlineTitle : 搭伙下半年第一波重磅产品震撼来临！
         * headlineContent : http://dahuo.bangcommunity.com/mc/notify/81698.html
         * headlineSort : 1
         * createDate : 1500277543000
         * headlineSummay : 【搭伙保险】今日火热上线！五款产品引爆上市！您最佳的展业武器。
         * headlineType : 1
         * headlineState : 1
         */

        private String headlineId;
        private String headlineTitle;
        private String headlineContent;
        private int headlineSort;
        private long createDate;
        private String headlineSummay;
        private String headlineType;
        private String headlineState;

        public String getHeadlineId() {
            return headlineId;
        }

        public void setHeadlineId(String headlineId) {
            this.headlineId = headlineId;
        }

        public String getHeadlineTitle() {
            return headlineTitle;
        }

        public void setHeadlineTitle(String headlineTitle) {
            this.headlineTitle = headlineTitle;
        }

        public String getHeadlineContent() {
            return headlineContent;
        }

        public void setHeadlineContent(String headlineContent) {
            this.headlineContent = headlineContent;
        }

        public int getHeadlineSort() {
            return headlineSort;
        }

        public void setHeadlineSort(int headlineSort) {
            this.headlineSort = headlineSort;
        }

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public String getHeadlineSummay() {
            return headlineSummay;
        }

        public void setHeadlineSummay(String headlineSummay) {
            this.headlineSummay = headlineSummay;
        }

        public String getHeadlineType() {
            return headlineType;
        }

        public void setHeadlineType(String headlineType) {
            this.headlineType = headlineType;
        }

        public String getHeadlineState() {
            return headlineState;
        }

        public void setHeadlineState(String headlineState) {
            this.headlineState = headlineState;
        }
    }

    public static class HighHotProductBean {
        /**
         * productNo : 032
         * supplierCode : 032
         * productName : 车险
         * description : 投保轻松 理赔便捷
         * detailUrl : http://dat.dahuobaoxian.com/car/detail
         * price : 960
         * maxProfit : null
         * maxProfitDescription : null
         * imgUrl : https://s3.cn-north-1.amazonaws.com.cn/uploadfiles/eriskfile/ERiskPic/h_car.png
         * brightSpot : null
         * saleNum : 0
         * label : 爆款！
         * category :
         * planName : null
         * toTop : 0
         * comCode : null
         * status : null
         */

        private String productNo;
        private String supplierCode;
        private String productName;
        private String description;
        private String detailUrl;
        private String price;
        private Object maxProfit;
        private Object maxProfitDescription;
        private String imgUrl;
        private Object brightSpot;
        private String saleNum;
        private String label;
        private String category;
        private Object planName;
        private int toTop;
        private Object comCode;
        private Object status;

        public String getProductNo() {
            return productNo;
        }

        public void setProductNo(String productNo) {
            this.productNo = productNo;
        }

        public String getSupplierCode() {
            return supplierCode;
        }

        public void setSupplierCode(String supplierCode) {
            this.supplierCode = supplierCode;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDetailUrl() {
            return detailUrl;
        }

        public void setDetailUrl(String detailUrl) {
            this.detailUrl = detailUrl;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public Object getMaxProfit() {
            return maxProfit;
        }

        public void setMaxProfit(Object maxProfit) {
            this.maxProfit = maxProfit;
        }

        public Object getMaxProfitDescription() {
            return maxProfitDescription;
        }

        public void setMaxProfitDescription(Object maxProfitDescription) {
            this.maxProfitDescription = maxProfitDescription;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public Object getBrightSpot() {
            return brightSpot;
        }

        public void setBrightSpot(Object brightSpot) {
            this.brightSpot = brightSpot;
        }

        public String getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(String saleNum) {
            this.saleNum = saleNum;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public Object getPlanName() {
            return planName;
        }

        public void setPlanName(Object planName) {
            this.planName = planName;
        }

        public int getToTop() {
            return toTop;
        }

        public void setToTop(int toTop) {
            this.toTop = toTop;
        }

        public Object getComCode() {
            return comCode;
        }

        public void setComCode(Object comCode) {
            this.comCode = comCode;
        }

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
            this.status = status;
        }
    }
}
