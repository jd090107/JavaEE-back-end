package com.tongji.controller;

import com.tongji.domain.HistoryTask;
import com.tongji.domain.LocustParam;
import com.tongji.domain.LocustResult;
import com.tongji.service.LocustService;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tongji.service.HistoryService;
import com.tongji.domain.args;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author : rain
 * @date : 2018/11/8 10:14 PM
 */
@RestController
@RequestMapping("/")
public class LocustController {

    @Autowired
    private LocustService locustService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private CookieController cookieController;

    @PostMapping("/init")
    @ApiOperation(value = "runWorkLoad")
    public void init(@RequestParam("host") String host) throws Exception {
        locustService.init(host);
    }

    @PostMapping("/workload")
    @ApiOperation(value = "runWorkLoad")
    public int runWorkLoad(@RequestParam("scenarioId") int scenarioId,
                           @RequestParam("clients") int clients,
                           @RequestParam("hatchRate") int hatchRate,
                           @RequestParam("runTime") int runTime,
                           @RequestParam("host") String host,
                           @RequestParam("taskName") String taskName,
                           HttpServletRequest request) throws Exception {
        args.REPORTID++;
        LocustParam locustParam = new LocustParam();
        locustParam.setScenarioId(scenarioId);
        locustParam.setClients(clients);
        locustParam.setHatchRate(hatchRate);
        locustParam.setRunTime(runTime);
        locustParam.setHost(host);
        String account = cookieController.getCookies(request);
        locustService.runWorkLoad(locustParam, account, taskName);
        return args.REPORTID;
    }

    @GetMapping("/result")
    @ApiOperation(value = "getResult")
    public void getResult(@RequestParam("from") String from, @RequestParam("to") String to, HttpServletResponse response) throws Exception {
        locustService.getLocustResult(from, to, response);
    }

    @GetMapping("/result/stream")
    @ApiOperation(value = "getResultStream")
    public String getResultStream(@RequestParam("from") String from, @RequestParam("to") String to) throws Exception {
        return locustService.getLocustResultStream(from, to);
    }

    @GetMapping("/test")
    @ApiOperation(value = "test")
    public String test() {
        return "success";
    }

    @GetMapping("/history")
    @ApiOperation(value = "getHistoryTask")
    public List<HistoryTask> getHistoryTask(HttpServletRequest request) throws Exception {
        String userAccount = cookieController.getCookies(request);
        return historyService.getHistoryTask(userAccount);
    }

    @GetMapping("/history/task_information")
    @ApiOperation(value = "getTaskInformation")
    public List<LocustResult> getTaskInformation(@RequestParam("reportId") String reportId, HttpServletResponse response) throws Exception {
        return historyService.getTaskInformation(reportId, response);
    }

    @GetMapping("/download")
    @ApiOperation(value = "downloadData")
    public void getResult(@RequestParam("reportId") String reportId, HttpServletResponse response) throws Exception {
        historyService.downloadData(reportId, response);
    }
}
