package com.hamster.ak.api;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.codec.json.Jackson2JsonDecoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@ApiModel(value = "还款/出账提醒")
@Slf4j
public class RemindersVO {
    @ApiModelProperty(value = "账户id", required = true)
    @NotNull
    private Integer accountId;

    @ApiModelProperty(value = "账户名称", required = true)
    @NotBlank
    private String accountName;

    @ApiModelProperty(value = "信用额度", required = true)
    @NotNull
    private Integer lineOfCredit;

    @ApiModelProperty(value = "是否是出账提醒", required = true)
    @NotNull
    private Boolean statement = false;

    @ApiModelProperty(value = "是否是还款提醒", required = true)
    @NotNull
    private Boolean repayment = false;

    @ApiModelProperty(value = "金额/需还款金额", required = true)
    @NotNull
    private Integer amount;

    public String toJson() {
        log.info("RemindersVO to json: " + JSON.toJSONString(this));
        return JSON.toJSONString(this);
    }
}
