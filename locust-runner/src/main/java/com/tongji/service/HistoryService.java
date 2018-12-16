package com.tongji.service;


import com.tongji.domain.HistoryTask;
import com.tongji.domain.LocustResult;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface HistoryService {

    List<HistoryTask> getHistoryTask(String userAccount) throws Exception;

    List<LocustResult> getTaskInformation(String reportId, HttpServletResponse response) throws Exception;

    void downloadData(String reportId, HttpServletResponse response) throws Exception;

}
