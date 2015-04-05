package com.yuri.archjava.utils;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by yuri on 22.03.2015.
 */
public class JsonJTableResponse {
    private String DisplayText;

    private String Value;

    public JsonJTableResponse(String DisplayText, String Value) {
        this.DisplayText = DisplayText;
        this.Value = Value;
    }

    @JsonProperty("DisplayText")
    public String getDisplayText() {
        return DisplayText;
    }

    public void setDisplayText(String DisplayText) {
        this.DisplayText = DisplayText;
    }

    @JsonProperty("Value")
    public String getValue() {
        return Value;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }
}
