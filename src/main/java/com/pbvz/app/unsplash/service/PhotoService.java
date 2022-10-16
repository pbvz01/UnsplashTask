package com.pbvz.app.unsplash.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pbvz.app.unsplash.model.Photo;
import com.pbvz.app.unsplash.api.UnsplashAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public class PhotoService {
    @Autowired
    private UnsplashAPI api;

    public PhotoService() {}

    public List<Photo> getPhotos() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            List<Photo> list = mapper.readValue(api.getJsonPhotos(), new TypeReference<>(){});
            return list;
        } catch (IOException e) {
            System.out.println("File was not found");
        }

        return null;
    }


}
