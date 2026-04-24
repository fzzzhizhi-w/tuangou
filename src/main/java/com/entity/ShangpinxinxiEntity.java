package com.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

@TableName("shangpinxinxi")
public class ShangpinxinxiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;
    private String shangpinmingcheng;
    private String shangpinfenlei;
    private String pinpai;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat
    private Date shangjiariqi;
    private String shangpinjieshao;
    private String shangpintupian;
    private String shangpubianhao;
    private String shangpumingcheng;
    private Integer onelimittimes;
    private Integer alllimittimes;
    private Integer thumbsupnum;
    private Integer crazilynum;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date clicktime;
    private Integer clicknum;
    private Double price;
    private Double groupprice;
    private Integer grouppeople;
    private Integer curpeople;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getShangpinmingcheng() { return shangpinmingcheng; }
    public void setShangpinmingcheng(String shangpinmingcheng) { this.shangpinmingcheng = shangpinmingcheng; }
    public String getShangpinfenlei() { return shangpinfenlei; }
    public void setShangpinfenlei(String shangpinfenlei) { this.shangpinfenlei = shangpinfenlei; }
    public String getPinpai() { return pinpai; }
    public void setPinpai(String pinpai) { this.pinpai = pinpai; }
    public Date getShangjiariqi() { return shangjiariqi; }
    public void setShangjiariqi(Date shangjiariqi) { this.shangjiariqi = shangjiariqi; }
    public String getShangpinjieshao() { return shangpinjieshao; }
    public void setShangpinjieshao(String shangpinjieshao) { this.shangpinjieshao = shangpinjieshao; }
    public String getShangpintupian() { return shangpintupian; }
    public void setShangpintupian(String shangpintupian) { this.shangpintupian = shangpintupian; }
    public String getShangpubianhao() { return shangpubianhao; }
    public void setShangpubianhao(String shangpubianhao) { this.shangpubianhao = shangpubianhao; }
    public String getShangpumingcheng() { return shangpumingcheng; }
    public void setShangpumingcheng(String shangpumingcheng) { this.shangpumingcheng = shangpumingcheng; }
    public Integer getOnelimittimes() { return onelimittimes; }
    public void setOnelimittimes(Integer onelimittimes) { this.onelimittimes = onelimittimes; }
    public Integer getAlllimittimes() { return alllimittimes; }
    public void setAlllimittimes(Integer alllimittimes) { this.alllimittimes = alllimittimes; }
    public Integer getThumbsupnum() { return thumbsupnum; }
    public void setThumbsupnum(Integer thumbsupnum) { this.thumbsupnum = thumbsupnum; }
    public Integer getCrazilynum() { return crazilynum; }
    public void setCrazilynum(Integer crazilynum) { this.crazilynum = crazilynum; }
    public Date getClicktime() { return clicktime; }
    public void setClicktime(Date clicktime) { this.clicktime = clicktime; }
    public Integer getClicknum() { return clicknum; }
    public void setClicknum(Integer clicknum) { this.clicknum = clicknum; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Double getGroupprice() { return groupprice; }
    public void setGroupprice(Double groupprice) { this.groupprice = groupprice; }
    public Integer getGrouppeople() { return grouppeople; }
    public void setGrouppeople(Integer grouppeople) { this.grouppeople = grouppeople; }
    public Integer getCurpeople() { return curpeople; }
    public void setCurpeople(Integer curpeople) { this.curpeople = curpeople; }
    public Date getAddtime() { return addtime; }
    public void setAddtime(Date addtime) { this.addtime = addtime; }
}
