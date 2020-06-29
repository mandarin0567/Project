package com.example.lifemedicalinfo.domain.repository;


import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class AEDRepository {

    public interface AedCallback {
        void onSuccess(ArrayList<AED> aedList);

        void onFailure(Exception e);
    }

    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

    OkHttpClient client;

    private String serviceKey = "%2FEh%2BoDn0Ogv9Udmz%2Fj7ELdTQ72GpFUWFREIfXcofoCbHiF%2BW9f79XRAT2%2BeFt7jxVdxvMAXBcuO4AzhfFUcI1g%3D%3D";

    public AEDRepository() {
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client = new OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build();
    }

    public void findAEDList(int pageNo, int numOfRows, double latitude, double longitude, final AedCallback callback) {
        HttpUrl url = new HttpUrl.Builder()
            .scheme("http")
            .host("apis.data.go.kr")
            .encodedPath("/B552657/AEDInfoInqireService/getAedLcinfoInqire")
            .addQueryParameter("WGS84_LAT", String.valueOf(latitude))
            .addQueryParameter("WGS84_LON", String.valueOf(longitude))
            .addQueryParameter("pageNo", String.valueOf(pageNo))
            .addQueryParameter("numOfRows", String.valueOf(numOfRows))
            .addEncodedQueryParameter("ServiceKey", serviceKey)
            .build();

        Request request = new Request.Builder()
            .url(url)
            .get()
            .build();

        client.newCall(request)
            .enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    callback.onFailure(e);
                }

                @Override
                public void onResponse(Call call, Response response) {
                    parseXml(response, callback);
                }
            });
    }

    private void parseXml(Response response, final AedCallback callback) {
        try {
            AEDInfoXmlParser parser = new AEDInfoXmlParser();
            ArrayList<AED> aedList = parser.getXmlData(response.body().byteStream());
            callback.onSuccess(aedList);
        } catch (Exception e) {
            callback.onFailure(e);
        }
    }
}
