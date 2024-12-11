package com.app.springSecurityApp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@PreAuthorize("denyAll()")
public class TestAuthController {

    @GetMapping("/get")
    @PreAuthorize("hasAuthority('READ')")
    public String helloGet(){
        return "Hello GET ^^";
    }
    @PostMapping("/post")
    @PreAuthorize("hasAuthority('CREATE') and hasAnyRole('ADMIN', 'DEVELOPER')")
    public String helloPost(){
        return "Hello POST ^^";
    }
    @PutMapping("/put")
    @PreAuthorize("hasAuthority('UPDATE')")
    public String helloPut(){
        return "Hello put ^^";
    }
    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('CREATE') or hasAuthority('UPDATE')")
    public String helloDelete(){
        return "Hello delete ^^";
    }
    @PatchMapping("/patch")
    @PreAuthorize("hasAuthority('REFACTOR') and hasRole('DEVELOPER')")
    public String helloPatch(){
        return "Hello patch ^^";
    }

}
