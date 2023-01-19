package com.hzc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author hzc
 * @since 2023-01-17 22:52
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @GetMapping("/info")
    public String productInfo() {
        String currentUser = "";
        // 从 Security 上下文获取通过认证的标识
        Object principl = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principl instanceof UserDetails) {
            currentUser = ((UserDetails)principl).getUsername();
            // log.debug("in principl");
        }else {
            currentUser = principl.toString();
            // log.debug("not in principl" + currentUser);
        }
        return "some product info, currentUser is:" + currentUser;
    }
}
