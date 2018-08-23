package com.star.springboot.bmp.activiti.web.action.api;

import com.star.springboot.bmp.activiti.bean.Demo;
import com.star.springboot.bmp.activiti.property.SpringbootBaseProperties;
import com.star.springboot.bmp.activiti.service.IDemoService;
import com.star.springboot.bmp.activiti.web.action.BaseAction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "原型管理",description = "<p style='font-weight:normal;font-size:15px'>" +
        "</br>返回码: " +
        "</br>code：0，message ：操作成功；代表请求成功，如果有返回数据则在data中 " +
        "</br>code：ARC100001，message ：（错误信息）；代表鉴权失败！" +
        "</br>code：-1，message ：（错误信息）；代表请求参数不合法" +
        "</br>code：-100，message ：（错误信息）；代表内部系统错误</p>")
@RestController
@RequestMapping("/api")
public class DemoApiAction extends BaseAction {


    @Autowired
    private SpringbootBaseProperties springbootBaseProperties;

    @Autowired
    private IDemoService demoService;

    @ApiOperation("测试属性")
    @PostMapping("/testDB")
    public Demo test(){
        return demoService.get(1l);
    }


}
