//package com.mycompany.onlineexam.aop.aspect;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.DispatcherServlet;
//import org.springframework.web.servlet.HandlerExecutionChain;
//import org.springframework.web.util.ContentCachingRequestWrapper;
//import org.springframework.web.util.ContentCachingResponseWrapper;
//import org.springframework.web.util.WebUtils;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//
///**
// * package org.sohagroup.pol.logging.LoggableDispatcherServlet
// *
// * @Author feynman
// * @create 8/25/21 4:39 PM project sap created by feynman at 8/25/21 4:39 PM
// * @since 1.0
// */
//@Component
//public class LoggableDispatcherServlet extends DispatcherServlet {
//
//    private final Logger logger = LogManager.getLogger(getClass());
//
//    @Override
//    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        if (!(request instanceof ContentCachingRequestWrapper)) {
//            request = new ContentCachingRequestWrapper(request);
//        }
//        if (!(response instanceof ContentCachingResponseWrapper)) {
//            response = new ContentCachingResponseWrapper(response);
//        }
//        HandlerExecutionChain handler = getHandler(request);
//
//        try {
//            super.doDispatch(request, response);
//        } finally {
//            log(request, response, handler);
//            updateResponse(response);
//        }
//    }
//
//    private void log(HttpServletRequest requestToCache, HttpServletResponse responseToCache, HandlerExecutionChain handler) {
//        StringBuilder reqrespContent = new StringBuilder();
//        String response = getResponsePayload(responseToCache);
//        String request = getResquestPayload(requestToCache);
//        reqrespContent.append("\n---------------------------------------\n").append("request: ")
//            .append(request).append("\n")
//            .append("response: ").append(response).append("\n for UUID")
//            .append("\n---------------------------------------");
//        logger.info("Request-Response Content " + reqrespContent.toString());
////        logger.info(log);
//    }
//
//    private String getResponsePayload(HttpServletResponse response) {
//        ContentCachingResponseWrapper wrapper = WebUtils.getNativeResponse(response, ContentCachingResponseWrapper.class);
//        if (wrapper != null) {
//
//            byte[] buf = wrapper.getContentAsByteArray();
//            if (buf.length > 0) {
//                int length = Math.min(buf.length, 5120);
//                try {
//                    return new String(buf, 0, length, "UTF-8");
//                } catch (UnsupportedEncodingException ex) {
//                    // NOOP
//                }
//            }
//        }
//        return "[unknown]";
//    }
//
//    private String getResquestPayload(HttpServletRequest request) {
//        ContentCachingRequestWrapper wrapper = WebUtils.getNativeRequest(request, ContentCachingRequestWrapper.class);
//        if (wrapper != null) {
//
//            byte[] buf = wrapper.getContentAsByteArray();
//            if (buf.length > 0) {
//                int length = Math.min(buf.length, 5120);
//                try {
//                    return new String(buf, 0, length, wrapper.getCharacterEncoding());
//                } catch (UnsupportedEncodingException ex) {
//                    // NOOP
//                }
//            }
//        }
//        return "[unknown]";
//    }
//
//    private void updateResponse(HttpServletResponse response) throws IOException {
//        ContentCachingResponseWrapper responseWrapper =
//            WebUtils.getNativeResponse(response, ContentCachingResponseWrapper.class);
//        responseWrapper.copyBodyToResponse();
//    }
//
//}
