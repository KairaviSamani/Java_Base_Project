package com.example.javabaseproject.utils;

import android.content.Context;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.javabaseproject.R;
import com.example.javabaseproject.listener.ResponseListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * This class is used to call API
 */
public class CallApi {
    private static final String TAG = CallApi.class.getSimpleName();

    /**
     * This method is used to call post API
     *
     * @param context          the context is used to show progressbar and alert dialog
     * @param url              the url string of API endpoint
     * @param params           the params for post API call
     * @param showProgressBar  the boolean to show progressbar or not
     * @param responseListener the response listener to notify API response
     */
    public static void callPostApi(
            Context context,
            String url,
            HashMap<String, String> params,
            Boolean showProgressBar,
            ResponseListener responseListener
    ) {
        if (showProgressBar) {
            Utils.showProgressBar(context);
        }
        AndroidNetworking.post(Endpoints.BASE_URL + url)
                .addBodyParameter(params)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (showProgressBar) {
                            Utils.dismissProgressBar();
                        }
                        if (response.optString("status").equalsIgnoreCase("success")
                                && response.optInt("status_code") == 200) {
                            responseListener.onSuccessResponse(response);
                        } else {
                            AlertDialogView.showAlert(
                                    context,
                                    context.getString(R.string.app_name),
                                    context.getString(R.string.error_api_msg)
                                    , context.getString(R.string.ok)
                            ).show();
                            responseListener.onErrorResponse(context.getString(R.string.error_api_msg));
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        if (showProgressBar) {
                            Utils.dismissProgressBar();
                        }
                        String message = context.getString(R.string.error_api_msg);
                        if (anError.getErrorCode() == 0) {
                            message = anError.getErrorDetail();
                        } else {
                            JSONObject jsonObject = null;
                            try {
                                jsonObject = new JSONObject(anError.getErrorBody());
                                JSONObject errorObj = jsonObject.optJSONObject("error");
                                if (errorObj != null) {
                                    JSONArray stringArray = errorObj.optJSONArray("application_id");
                                    if (stringArray != null && stringArray.length() > 0) {
                                        message = stringArray.getString(0);
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        AlertDialogView.showAlert(
                                context,
                                context.getString(R.string.app_name),
                                message,
                                context.getString(R.string.ok)
                        ).show();
                        responseListener.onErrorResponse(anError);
                    }
                });
    }
}
