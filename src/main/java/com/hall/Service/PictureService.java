package com.hall.Service;

public interface PictureService {
    int insertImage(String path, String url, int uid, String role);

    int deleteImage(String url);
}
