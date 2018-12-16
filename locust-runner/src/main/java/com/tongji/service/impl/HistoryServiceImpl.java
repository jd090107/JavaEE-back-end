package com.tongji.service.impl;

import com.csvreader.CsvWriter;
import com.tongji.domain.HistoryTask;
import com.tongji.domain.LocustResult;
import com.tongji.mapper.LocustMapper;
import com.tongji.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Date;


@Service
public class HistoryServiceImpl implements HistoryService {

    @Value("${listener.path}")
    private String resultFileDir;

    @Value("${locust.scenario.path}")
    private String locustFileDir;

    @Autowired
    private LocustMapper locustMapper;

    private final String fileName = "Result.csv";
    private final List<String> titles = Arrays.asList("scenarioId", "requests", "failures", "medianResponseTime", "averageResponseTime",
            "minResponseTime", "maxResponseTime", "averageContentSize", "requestPerSecond", "dateTime", "reportId");
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public List<HistoryTask> getHistoryTask(String userAccount)
    {

        return locustMapper.getHistoryTask(userAccount);
    }

    @Override
    public List<LocustResult> getTaskInformation(String reportId, HttpServletResponse response) {

        return locustMapper.getTaskInformation(reportId);
    }

    @Override
    public void downloadData(String reportId, HttpServletResponse response) {
        List<LocustResult> locustResultList = locustMapper.getTaskInformation(reportId);

        try {
            File file = File.createTempFile("Result", ".csv");
            CsvWriter csvWriter = new CsvWriter(file.getCanonicalPath(),',', Charset.forName("UTF-8"));
            csvWriter.writeRecord((String[]) titles.toArray());
            for (LocustResult result : locustResultList) {
                csvWriter.writeRecord(new String[] {result.getScenarioId(),
                        result.getRequests(),
                        result.getFailures(),
                        result.getMedianResponseTime(),
                        result.getAverageResponseTime(),
                        result.getMinResponseTime(),
                        result.getMaxResponseTime(),
                        result.getAverageContentSize(),
                        result.getRequestPerSecond(),
                        simpleDateFormat.format(result.getDateTime()),
                        result.getReportId()
                });
            }
            csvWriter.close();

            response.setContentType("application/csv; charset=utf-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + reportId + "-" + fileName);
            InputStream in = new FileInputStream(file);
            OutputStream out = response.getOutputStream();
            int len;
            byte[] buffer = new byte[1024];
            while((len = in.read(buffer)) > 0) {
                out.write(buffer,0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}