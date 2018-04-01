package com.example.kamran.loginsignupmix.rest;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * Created by SHIV on 15-Mar-18.
 */

public class RestUtil {

    public static void select(String url, String body, RequestQueue queue, Response.Listener responseListener, Response.ErrorListener errorListener) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, body, responseListener, errorListener);
        queue.add(request);
    }

    public static void insert(String url, String body, RequestQueue queue, Response.Listener responseListener, Response.ErrorListener errorListener) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, body, responseListener, errorListener);
        queue.add(request);
    }

    public static void update(String url, String body, RequestQueue queue, Response.Listener responseListener, Response.ErrorListener errorListener) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.PUT, url, body, responseListener, errorListener);
        queue.add(request);
    }

    public static void delete(String url, String body, RequestQueue queue, Response.Listener responseListener, Response.ErrorListener errorListener) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.DELETE, url, body, responseListener, errorListener);
        queue.add(request);
    }
}