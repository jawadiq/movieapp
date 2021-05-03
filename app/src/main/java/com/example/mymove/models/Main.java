package com.example.mymove.models;

import com.google.gson.annotations.SerializedName;

public class Main {
    @SerializedName("response")
    public JSONResponse response;

    public Main(JSONResponse response) {
        this.response = response;
    }

    public JSONResponse getResponse() {
        return response;
    }

    public void setResponse(JSONResponse response) {
        this.response = response;
    }
}
