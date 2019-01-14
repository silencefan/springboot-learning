package com.felixfan.learn.entity.po;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description: 充值配置表</br>
 * proxy这个注释是为了解决hibernate延迟加载的问题
 * @author: felix.fan
 * @date: 2019/1/14 11:23
 * @version: 1.0
 */
@Data
@Entity
@Table(name = "recharge_config")
@Proxy(lazy = false)
public class RechargeConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 充值金额
     */
    @Column(name = "recharge_amount")
    private Integer rechargeAmount;

    /**
     * 赠送金额
     */
    @Column(name = "donation_amount")
    private Integer donationAmount;

    /**
     * 记录创建时间
     */
    @Column(name = "create_time")
    private Integer createTime;

    /**
     * 记录修改时间
     */
    @Column(name = "update_time")
    private Integer updateTime;

    public RechargeConfig() {
    }

    public RechargeConfig(Integer rechargeAmount, Integer donationAmount, Integer createTime, Integer updateTime) {
        this.rechargeAmount = rechargeAmount;
        this.donationAmount = donationAmount;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}