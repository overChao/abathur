package com.crodi.abathur.controller;

import com.crodi.abathur.service.impl.BlockInteractionServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Crodi
 * @date 2024/8/21 17:04
 * @description: TODO
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BaseController {

    private final BlockInteractionServiceImpl blockInteractionService;

    @SneakyThrows
    @GetMapping("/checkRequest/{id}")
    public String checkRequest(@PathVariable String id) {
        return blockInteractionService.checkRequestId(id);
    }


}