package com.zimaheka.merwan_walid.volley02;

import android.app.DownloadManager;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by Walid Djebbouri on 18/07/2018.
 */

public class Requete<T> extends Request<T> {


    private final Class<T> clazz ;
    private Gson gson = new Gson();
    private Response.Listener<T> responselistener ;

    public Requete(String  url , Class<T> clazz , Response.Listener<T> responselistener , Response.ErrorListener errorListener){

        super(  Method.GET , url  , errorListener );

        this.clazz = clazz ;
        this.responselistener = responselistener ;


    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {

        try {

            String json = new String(response.data , HttpHeaderParser.parseCharset(response.headers)) ;
            
            return Response.success(gson.fromJson(json , clazz) , HttpHeaderParser.parseCacheHeaders(response)) ;

        }
        catch (UnsupportedEncodingException u){

            u.printStackTrace();
        }
        catch (JsonSyntaxException js){

        }
        return null;
    }

    @Override
    protected void deliverResponse(T response) {
        responselistener.onResponse(response);
    }
}


