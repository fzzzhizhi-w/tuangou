package com.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

@TableName("cart")
public class CartEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;
    private String tablename;
    private Long userid;
    private Long goodid;
    private String goodname;
    private String picture;
    private Integer buynumber;
    private Double price;
    private Double discountprice;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTablename() { return tablename; }
    public void setTablename(String tablename) { this.tablename = tablename; }
    public Long getUserid() { return userid; }
    public void setUserid(Long userid) { this.userid = userid; }
    public Long getGoodid() { return goodid; }
    public void setGoodid(Long goodid) { this.goodid = goodid; }
    public String getGoodname() { return goodname; }
    public void setGoodname(String goodname) { this.goodname = goodname; }
    public String getPicture() { return picture; }
    public void setPicture(String picture) { this.picture = picture; }
    public Integer getBuynumber() { return buynumber; }
    public void setBuynumber(Integer buynumber) { this.buynumber = buynumber; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Double getDiscountprice() { return discountprice; }
    public void setDiscountprice(Double discountprice) { this.discountprice = discountprice; }
    public Date getAddtime() { return addtime; }
    public void setAddtime(Date addtime) { this.addtime = addtime; }
}
