package com.hzc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * </p>
 *
 * @author hzc
 * @since 2023-01-17 22:53
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/home")
    public String productInfo() {
        return "admin home page";
    }
}
