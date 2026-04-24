package com.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

@TableName("yonghu")
public class YonghuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;
    private String zhanghao;
    private String mima;
    private String xingming;
    private String xingbie;
    private String shouji;
    private String youxiang;
    private String touxiang;
    private Double money;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getZhanghao() { return zhanghao; }
    public void setZhanghao(String zhanghao) { this.zhanghao = zhanghao; }
    public String getMima() { return mima; }
    public void setMima(String mima) { this.mima = mima; }
    public String getXingming() { return xingming; }
    public void setXingming(String xingming) { this.xingming = xingming; }
    public String getXingbie() { return xingbie; }
    public void setXingbie(String xingbie) { this.xingbie = xingbie; }
    public String getShouji() { return shouji; }
    public void setShouji(String shouji) { this.shouji = shouji; }
    public String getYouxiang() { return youxiang; }
    public void setYouxiang(String youxiang) { this.youxiang = youxiang; }
    public String getTouxiang() { return touxiang; }
    public void setTouxiang(String touxiang) { this.touxiang = touxiang; }
    public Double getMoney() { return money; }
    public void setMoney(Double money) { this.money = money; }
    public Date getAddtime() { return addtime; }
    public void setAddtime(Date addtime) { this.addtime = addtime; }
}
