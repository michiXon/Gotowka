package com.company;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class PushNotifictionHelper {
    public final static String AUTH_KEY_FCM = "AIzaSyB6C1RbQle0CeL-VQRE1XHbSsMl6k813dY";
    public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

    public static String sendPushNotification(String deviceToken)
            throws IOException {
        String result = "";
        URL url = new URL(API_URL_FCM);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "key=" + AUTH_KEY_FCM);
        conn.setRequestProperty("Content-Type", "application/json");

        JSONObject json = new JSONObject();

        json.put("to", deviceToken.trim());
        JSONObject info = new JSONObject();
        info.put("title", "notification title"); // Notification title
        info.put("body", "message body"); // Notification
        // body
        json.put("notification", info);
        try {
            OutputStreamWriter wr = new OutputStreamWriter(
                    conn.getOutputStream());
            wr.write(json.toString());
            wr.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
            result = "failure";
        }
        System.out.println("GCM Notification is sent successfully");

        return result;
    }
}