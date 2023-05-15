package com.revnomix.revseed.model;




import java.io.Serializable;

import java.util.Date;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import com.revnomix.revseed.wrapper.ScheduledJobDto;


@NamedNativeQueries({
        @NamedNativeQuery(
                name = "ScheduledJob.getPropertyDetails",
                query = "SELECT sj.id,sj.client_id,c.property_name,sj.start_date_time,sj.end_date_time,sj.job_type,sj.response,sj.status\n" +
                        "FROM scheduled_job sj\n" +
                        "INNER JOIN clients c \n" +
                        "ON sj.client_id = c.id\n" +
                        "WHERE sj.start_date_time > :startDate AND sj.client_id = :clientId AND sj.status = :Status ORDER BY sj.start_date_time DESC",
                resultClass= ScheduledJobDto.class,
                resultSetMapping = "ScheduledJobDtoMapping"
        ),
        @NamedNativeQuery(
                name = "ScheduledJob.findByStatus",
                query = "SELECT client_id,status,COUNT(*) as counts\n" +
                        "FROM scheduled_job\n" +
                        "WHERE start_date_time > :startDate AND client_id = :clientId\n" +
                        "GROUP BY client_id,STATUS",
                resultClass = ScheduledJobDto.class,
                resultSetMapping = "ScheduledJobDtoMappings"
        )
})

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "ScheduledJobDtoMapping",
                classes = {
                        @ConstructorResult(
                                targetClass = ScheduledJobDto.class,
                                columns = {
                                        @ColumnResult(name = "id", type = Integer.class),
                                        @ColumnResult(name = "client_id", type = Integer.class),
                                        @ColumnResult(name = "property_name", type = String.class),
                                        @ColumnResult(name = "start_date_time", type = Date.class),
                                        @ColumnResult(name = "end_date_time", type = Date.class),
                                        @ColumnResult(name = "job_type", type = String.class),
                                        @ColumnResult(name = "response", type = String.class),
                                        @ColumnResult(name = "status", type = String.class),
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "ScheduledJobDtoMappings",
                classes = {
                        @ConstructorResult(
                                targetClass = ScheduledJobDto.class,
                                columns = {
                                        @ColumnResult(name = "client_id", type = Integer.class),
                                        @ColumnResult(name = "status", type = String.class),
                                        @ColumnResult(name = "counts", type = Integer.class),
                                }
                        )
                }
        )
})


@Entity
@Table(name = "scheduled_job")
public class ScheduledJob implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer clientId;
    @Enumerated(EnumType.STRING)
    private JobType jobType;
    private String taskName;
    private Date startDateTime;
    private Date endDateTime;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType2) {
        this.jobType = jobType2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}