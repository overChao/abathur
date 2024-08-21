package com.crodi.abathur.common.response;

import com.crodi.abathur.common.constant.ResultCode;
import lombok.Data;

/**
 * @author: zkc
 * @date: 2022/2/28 15:43
 * @description: 通用响应模板
 * @version: 1.0
 */

@Data
public class  BaseResponse<T> {

	private int resultCode;

	private String resultMessage;

	private T data;

	/**
	 * 正常响应
	 * @param data 响应数据
	 */
	public BaseResponse(T data) {
		this.resultCode = ResultCode.SUCCESS;
		this.resultMessage = "";
		this.data = data;
	}





}
