package utils;

import com.thoughtworks.gauge.Step;
import okhttp3.*;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Calliope {

    public void setRequest() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("multipart/form-data");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file[]", "C:/ProgramData/Jenkins/.jenkins/workspace/SpriteCloud/reports/xml-report/result.xml",
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File("C:/ProgramData/Jenkins/.jenkins/workspace/SpriteCloud/reports/xml-report/result.xml")))
                .addFormDataPart("attachment[]", "C:\\Users\\onur.tarar\\Desktop\\zip\\ScreenShots.zip",
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File("C:\\Users\\onur.tarar\\Desktop\\zip\\ScreenShots.zip")))
                .build();
        Request request = new Request.Builder()
                .url("https://app.calliope.pro/api/v2/profile/4508/import/")
                .method("POST", body)
                .addHeader("x-api-key", "MmU3MjM4YmJiZTdiOTRlMjQwOTlkZWMwYTJmNzExNDA5ZjQyYzA5MjRiNGRkNzY0NDU1MGRlYmJiYTkxZDljY2Jj")
                .addHeader("Content-Type", "multipart/form-data")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body());
    }

    public void zipSS() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Test String");

        File f = new File("C:\\Users\\onur.tarar\\Desktop\\zip\\ScreenShots.zip");
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
        ZipEntry e = new ZipEntry(".gauge/screenshots");
        out.putNextEntry(e);

        byte[] data = sb.toString().getBytes();
        out.write(data, 0, data.length);
        out.closeEntry();

        out.close();

    }
}

