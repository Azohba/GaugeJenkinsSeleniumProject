package utils;

import okhttp3.*;

import java.io.File;
import java.io.IOException;

public class Calliope {
    public void sendResultsToCalliope() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("multipart/form-data");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file","**/reports/xml-report/*.xml",
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File("**/reports/xml-report/*.xml")))
                .build();
        Request request = new Request.Builder()
                .url("https://app.calliope.pro/api/v2/profile/4508/import/junit")
                .method("POST", body)
                .addHeader("x-api-key", "MmU3MjM4YmJiZTdiOTRlMjQwOTlkZWMwYTJmNzExNDA5ZjQyYzA5MjRiNGRkNzY0NDU1MGRlYmJiYTkxZDljY2Jj")
                .addHeader("Content-Type", "multipart/form-data")
                .build();
        Response response = client.newCall(request).execute();
    }
}
