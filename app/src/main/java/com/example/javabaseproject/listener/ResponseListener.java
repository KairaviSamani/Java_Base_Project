package com.example.javabaseproject.listener;

import org.json.JSONObject;

public interface ResponseListener {
    void onSuccessResponse(JSONObject response);

    void onErrorResponse(Object message);
}
