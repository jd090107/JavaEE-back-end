package com.tongji.service.impl;

import com.tongji.domain.LocustResult;
import com.tongji.domain.LocustResultFactory;
import com.tongji.mapper.LocustMapper;
import com.tongji.service.ListenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * @author : rain
 * @date : 2018/11/11 2:18 PM
 */
@Service
public class ListenerServiceImpl implements ListenerService {

    @Autowired
    private LocustMapper locustMapper;

    @Override
    public void analyzeLocustResult(File file) {
        String scenarioId = file.getName().split("_")[0];
        try (InputStreamReader inputStreamReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String lineTxt;
            while ((lineTxt = bufferedReader.readLine()) != null)
            {
                if (lineTxt.contains("Total")) {
                    LocustResult locustResult = LocustResultFactory.getLocustResult(scenarioId, lineTxt);
                    locustMapper.insert(locustResult);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
