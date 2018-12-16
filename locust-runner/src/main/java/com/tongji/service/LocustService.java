package com.tongji.service;

import com.tongji.domain.LocustParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


/**
 * @author : rain
 * @date : 2018/11/8 10:14 PM
 */
public interface LocustService {

    void init(String host) throws IOException, InterruptedException;

    void runWorkLoad(LocustParam locustParam, String account, String reportId) throws Exception;

    void runWorkLoadWeb(LocustParam locustParam) throws Exception;

    void getLocustResult(String from, String to, HttpServletResponse response) throws Exception;

    String getLocustResultStream(String from, String to) throws Exception;
}
