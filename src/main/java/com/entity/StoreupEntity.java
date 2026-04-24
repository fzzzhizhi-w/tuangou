package com.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

@TableName("storeup")
public class StoreupEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;
    private Long userid;
    private Long refid;
    private String tablename;
    private String name;
    private String picture;
    private String type;
    private String inteltype;
    private String remark;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserid() { return userid; }
    public void setUserid(Long userid) { this.userid = userid; }
    public Long getRefid() { return refid; }
    public void setRefid(Long refid) { this.refid = refid; }
    public String getTablename() { return tablename; }
    public void setTablename(String tablename) { this.tablename = tablename; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPicture() { return picture; }
    public void setPicture(String picture) { this.picture = picture; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getInteltype() { return inteltype; }
    public void setInteltype(String inteltype) { this.inteltype = inteltype; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
    public Date getAddtime() { return addtime; }
    public void setAddtime(Date addtime) { this.addtime = addtime; }
}
