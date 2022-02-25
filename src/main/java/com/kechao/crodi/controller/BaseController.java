package com.kechao.crodi.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * author: zkc
 * date: 2022/2/25 18:32
 * description: BaseController
 * version: 1.0
 */


@RestController
@RequestMapping("/api")
public class BaseController {

	private Map<String, String> context = new HashMap<>(16);

	@RequestMapping(value = "/auth", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	private void syncAuthentic() {

	}


}
