package com.smilehacker.exvolley.utils;

import com.smilehacker.exvolley.NetworkResponse;
import com.smilehacker.exvolley.Response;
import com.smilehacker.exvolley.toolbox.HttpHeaderParser;

import java.io.UnsupportedEncodingException;

/**
 * Created by kleist on 14-1-8.
 */
public class VolleyUtils {

    public static String parseResponse(NetworkResponse response) {
        try {
            return new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
