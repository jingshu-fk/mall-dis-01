package com.mall.dis.controller;

import com.mall.dis.common.api.CommonResult;
import com.mall.dis.entity.PmsBrand;
import com.mall.dis.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author shujingping
 * @since 2022-09-15
 */
@RestController
@RequestMapping("/brand")
@Api(tags = "商品品牌管理")
public class PmsBrandController {
    private static final Logger logger = LoggerFactory.getLogger(PmsBrandController.class);

    @Autowired
    private PmsBrandService demoService;

    @GetMapping("/listAll")
    @ApiOperation("获取所有品牌列表")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult getBrandList() {
        return CommonResult.success(demoService.listAllBrand());
    }

    @PostMapping("/create")
    @ApiOperation("添加品牌")
    @PreAuthorize("hasAnyAuthority('pms:brand:create')")
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand) {
        int count = demoService.createBrand(pmsBrand);
        if (count > 0) {
            logger.info("createBrand success:{}", pmsBrand);
            return CommonResult.success(pmsBrand);
        } else {
            logger.info("createBrand failed:{}", pmsBrand);
            return CommonResult.failed("操作失败");
        }
    }

    @PutMapping("/update/{id}")
    @ApiOperation("更新指定id品牌信息")
    @PreAuthorize("hasAnyAuthority('pms:brand:update')")
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrand) {
        int count = demoService.updateBrand(id, pmsBrand);
        if (count == 1) {
            logger.info("updateBrand success:{}", pmsBrand);
            return CommonResult.success(pmsBrand);
        } else {
            logger.info("updateBrand failed:{}", pmsBrand);
            return CommonResult.failed("更新失败！");
        }
    }
}

