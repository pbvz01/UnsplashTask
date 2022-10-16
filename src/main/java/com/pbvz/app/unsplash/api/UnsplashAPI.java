package com.pbvz.app.unsplash.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


@Component
public class UnsplashAPI {
    @Value("${unsplash.api}")
    private String url;
    @Value("${unsplash.token}")
    private String token;

    public String getJsonPhotos() {
        StringBuilder json = new StringBuilder();
        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(getConnection().getInputStream()))) {

            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                json.append(inputLine);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    private URLConnection getConnection() throws IOException {
        return new URL(url + "/photos?client_id=" + token).openConnection();
    }
}
