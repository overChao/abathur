package com.crodi.abathur.service.impl;

import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author Crodi
 * @date 2025/4/9 16:24
 * @description: TODO
 */

@Service
public class BlockInteractionServiceImpl {


    public String checkRequestId(String requestId) throws InterruptedException {

        if (Objects.equals(requestId, "1")) {
            TimeUnit.MILLISECONDS.sleep(1000);
        }
        return requestId;

    }


}
