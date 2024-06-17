package com.jose.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jose.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.jose.curso.springboot.webapp.springboot_web.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping; 


@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(defaultValue = "hola que tal" , required = false) String message) 
    {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
     }
    
     
    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text ,@RequestParam int code ) 
    {
        ParamMixDto param = new ParamMixDto();
        param.setMessage(text);
        param.setCode(code);
        return param;
     }
    
    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request) {
        ParamMixDto param = new ParamMixDto(); 
        Integer code = 0;
        try {
            code =  Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {
            // TODO: handle exception
        }
        param.setMessage(request.getParameter("message"));
        param.setCode(code);
        return param;
    }
    
}
