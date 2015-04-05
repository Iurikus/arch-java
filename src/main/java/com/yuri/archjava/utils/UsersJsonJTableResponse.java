package com.yuri.archjava.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuri.archjava.dto.AdminListItemDto;
import com.yuri.archjava.model.User;

import java.util.List;

/**
 * Created by yuri on 28.03.2015.
 */
public class UsersJsonJTableResponse {

    private String Result;

    private List<AdminListItemDto> Records;

    private int TotalRecordCount;

    private String Message;

    public UsersJsonJTableResponse(String result, List<AdminListItemDto> records, int totalRecordCount) {
        Result = result;
        Records = records;
        TotalRecordCount = totalRecordCount;
    }

    public UsersJsonJTableResponse(String result, String message) {
        Result = result;
        Message = message;
    }

    @JsonProperty("Result")
    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    @JsonProperty("Records")
    public List<AdminListItemDto> getRecords() {
        return Records;
    }

    public void setRecords(List<AdminListItemDto> records) {
        Records = records;
    }

    @JsonProperty("TotalRecordCount")
    public int getTotalRecordCount() {
        return TotalRecordCount;
    }

    public void setTotalRecordCount(int totalRecordCount) {
        TotalRecordCount = totalRecordCount;
    }

    @JsonProperty("Message")
    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
