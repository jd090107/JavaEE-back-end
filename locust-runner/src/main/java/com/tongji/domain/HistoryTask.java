package com.tongji.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class HistoryTask {
    private String report_id;

    private String task_name;

    public String getReport_id() {
        return report_id;
    }

    public void setReport_id(String report_id) {
        this.report_id = report_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    @Override
    @JsonIgnore
    public String toString() {
        return "HistoryTask{" +
                "reportId='" + report_id + '\'' +
                ", taskName='" + task_name +
                '}';
    }
}