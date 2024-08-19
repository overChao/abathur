package com.crodi.abathur.controller;

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
	public void syncUserAuthentic(@RequestBody BaseQo qo) {

	}

}
