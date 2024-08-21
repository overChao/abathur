package com.crodi.abathur.controller;

import com.crodi.abathur.common.entity.qo.BaseQo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Crodi
 * @date 2024/8/21 17:04
 * @description: TODO
 */

@RestController
@RequestMapping("/api")
public class BaseController {

    private Map<String, String> context = new HashMap<>(16);

    @RequestMapping(value = "/auth", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void syncUserAuthentic(@RequestBody BaseQo qo) {

    }


}
