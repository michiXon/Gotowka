package main.java.com.company;

import java.net.*;
import java.io.*;

public class URLConnectionReader {
    public static String printApiData(String url) throws Exception {
        URL bank = new URL(url);
        URLConnection yc = bank.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine, result = "";

        while ((inputLine = in.readLine()) != null) {
            result += inputLine;

        }
        in.close();
        return result;
    }

}
