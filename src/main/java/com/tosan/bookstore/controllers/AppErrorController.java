package com.tosan.bookstore.controllers;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

//@Controller
//public class AppErrorController implements ErrorController  {
////    @RequestMapping({"/error", "/{lang}/error"})
////    public String handleError(HttpServletRequest request, @PathVariable String lang) {
////        var status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
////        if (status == null)
////            return "errors/error";
////
////        HttpStatus httpStatus = HttpStatus.valueOf(Integer.parseInt(status.toString()));
////
////        return switch (httpStatus) {
////            case FORBIDDEN -> "errors/error-403";
////            case NOT_FOUND -> "errors/error-404";
////            case INTERNAL_SERVER_ERROR -> "errors/error-500";
////            default -> "errors/error";
////        };
////    }
//
////    @RequestMapping({"/error"})
////    public String handleError(HttpServletRequest request) {
////        var status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
////        if (status == null)
////            return "errors/error";
////
////        HttpStatus httpStatus = HttpStatus.valueOf(Integer.parseInt(status.toString()));
////
//////        var stringWriter = new StringWriter();
//////        var printWriter = new PrintWriter(stringWriter);
//////        e.printStackTrace(printWriter);
//////        String stackTrace = stringWriter.toString();
////
////        return switch (httpStatus) {
////            case FORBIDDEN -> "errors/error-403";
////            case NOT_FOUND -> "errors/error-404";
////            case INTERNAL_SERVER_ERROR -> "errors/error-500";
////            default -> "errors/error";
////        };
////    }
//
//
//    @GetMapping("/errors/error-403")
//    public String handleError403() {
//        return "/errors/error-403";
//    }
//
//    @GetMapping("/errors/error-404")
//    public String handleError404() {
//        return "/errors/error-404";
//    }
//
//    @GetMapping("/errors/error-500")
//    public String handleError500() {
//        return "/errors/error-500";
//    }
//}