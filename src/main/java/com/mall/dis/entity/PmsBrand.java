package com.mall.dis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 品牌表
 * </p>
 *
 * @author shujingping
 * @since 2022-09-15
 */

@Data
@TableName("pms_brand")
@ApiModel("品牌")
public class PmsBrand {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("first_letter")
    @ApiModelProperty(value = "首字母")
    private String firstLetter;

    @TableField("sort")
    private Integer sort;


    @TableField("factory_status")
    @ApiModelProperty(value = "是否为品牌制造商：0->不是；1->是")
    private Integer factoryStatus;
    @TableField("show_status")
    private Integer showStatus;

    @TableField("product_count")
    @ApiModelProperty(value = "产品数量")
    private Integer productCount;

    @TableField("product_comment_count")
    @ApiModelProperty(value = "产品评论数量")
    private Integer productCommentCount;

    @TableField("logo")
    @ApiModelProperty(value = "品牌logo")
    private String logo;


    @TableField("big_pic")
    @ApiModelProperty(value = "专区大图")
    private String bigPic;

    @TableField("brand_story")
    @ApiModelProperty(value = "品牌故事")
    private String brandStory;

    @Override
    public String toString() {
        return "PmsBrand{" +
        "id=" + id +
        ", name=" + name +
        ", firstLetter=" + firstLetter +
        ", sort=" + sort +
        ", factoryStatus=" + factoryStatus +
        ", showStatus=" + showStatus +
        ", productCount=" + productCount +
        ", productCommentCount=" + productCommentCount +
        ", logo=" + logo +
        ", bigPic=" + bigPic +
        ", brandStory=" + brandStory +
        "}";
    }
}
