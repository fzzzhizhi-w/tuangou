package com.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

@TableName("shangjia")
public class ShangjiaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;
    private String shangjiabianhao;
    private String shangjiamingcheng;
    private String mima;
    private String lianxiren;
    private String lianxidianhua;
    private String dizhi;
    private String yingyezhizhao;
    private String shenhezt;
    private Double money;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getShangjiabianhao() { return shangjiabianhao; }
    public void setShangjiabianhao(String shangjiabianhao) { this.shangjiabianhao = shangjiabianhao; }
    public String getShangjiamingcheng() { return shangjiamingcheng; }
    public void setShangjiamingcheng(String shangjiamingcheng) { this.shangjiamingcheng = shangjiamingcheng; }
    public String getMima() { return mima; }
    public void setMima(String mima) { this.mima = mima; }
    public String getLianxiren() { return lianxiren; }
    public void setLianxiren(String lianxiren) { this.lianxiren = lianxiren; }
    public String getLianxidianhua() { return lianxidianhua; }
    public void setLianxidianhua(String lianxidianhua) { this.lianxidianhua = lianxidianhua; }
    public String getDizhi() { return dizhi; }
    public void setDizhi(String dizhi) { this.dizhi = dizhi; }
    public String getYingyezhizhao() { return yingyezhizhao; }
    public void setYingyezhizhao(String yingyezhizhao) { this.yingyezhizhao = yingyezhizhao; }
    public String getShenhezt() { return shenhezt; }
    public void setShenhezt(String shenhezt) { this.shenhezt = shenhezt; }
    public Double getMoney() { return money; }
    public void setMoney(Double money) { this.money = money; }
    public Date getAddtime() { return addtime; }
    public void setAddtime(Date addtime) { this.addtime = addtime; }
}
