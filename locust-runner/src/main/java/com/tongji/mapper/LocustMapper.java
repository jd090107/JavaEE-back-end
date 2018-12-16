package com.tongji.mapper;

import com.tongji.domain.HistoryTask;
import com.tongji.domain.LocustResult;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @author : rain
 * @date : 2018/11/20 5:08 PM
 */
@Mapper
public interface LocustMapper {

    @Insert("insert into locust_data values (#{scenarioId}," +
            "#{requests}," +
            "#{failures}," +
            "#{medianResponseTime}," +
            "#{averageResponseTime}," +
            "#{minResponseTime}," +
            "#{maxResponseTime}," +
            "#{averageContentSize}," +
            "#{requestPerSecond}," +
            "#{dateTime}," +
            "#{reportId})")
    void insert(LocustResult locustResult);

    @Results({
            @Result(column="scenario_id", property="scenarioId"),
            @Result(column="requests", property="requests"),
            @Result(column="failures", property="failures"),
            @Result(column="median_response_time", property="medianResponseTime"),
            @Result(column="average_response_time", property="averageResponseTime"),
            @Result(column="min_response_time", property="minResponseTime"),
            @Result(column="max_response_time", property="maxResponseTime"),
            @Result(column="average_content_size", property="averageContentSize"),
            @Result(column="request_per_second", property="requestPerSecond"),
            @Result(column="date_time", property="dateTime"),
            @Result(column="report_id", property="reportId")
    })
    @Select("select * from locust_data where date_time between #{from} and #{to}")
    List<LocustResult> getResult(@Param("from") String from, @Param("to") String to);

    @Select("select search_task_name.report_id, task_name " +
            "from search_task_name, owns " +
            "where search_task_name.report_id = owns.report_id and owns.account = #{userAccount}")
    List<HistoryTask> getHistoryTask(@Param("userAccount") String userAccount);

    @Results({
            @Result(column="scenario_id", property="scenarioId"),
            @Result(column="requests", property="requests"),
            @Result(column="failures", property="failures"),
            @Result(column="median_response_time", property="medianResponseTime"),
            @Result(column="average_response_time", property="averageResponseTime"),
            @Result(column="min_response_time", property="minResponseTime"),
            @Result(column="max_response_time", property="maxResponseTime"),
            @Result(column="average_content_size", property="averageContentSize"),
            @Result(column="request_per_second", property="requestPerSecond"),
            @Result(column="date_time", property="dateTime"),
            @Result(column="report_id", property="reportId")
    })
    @Select("select * from locust_data where report_id = #{reportId}")
    List<LocustResult> getTaskInformation(@Param("reportId") String reportId);

    @Insert("insert into owns values (#{account}, #{reportId})")
    void InsertOwns(@Param("account") String account, @Param("reportId") String reportId);

    @Insert("insert into search_task_name values (#{reportId}, #{taskName})")
    void InsertTaskName(@Param("reportId") String reportId, @Param("taskName") String taskName);
}
