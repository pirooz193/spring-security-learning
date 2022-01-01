package com.mycompany.onlineexam.web.mdel;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceResult {
    @JsonProperty("data")
    private Object data;
    @JsonProperty("message")
    private String message;
    @JsonProperty("status_code")
    private Integer statusCode;

    public ServiceResult() {
    }

    public ServiceResult(Object data,String message ,  Integer statusCode) {
        this.data = data;
        this.message = message;
        this.statusCode = statusCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceResult that = (ServiceResult) o;
        return data.equals(that.data) &&
                statusCode.equals(that.statusCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, statusCode);
    }

    @Override
    public String toString() {
        return "ServiceResult{" +
                "data=" + data +
                ", statusCode=" + statusCode +
                '}';
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
