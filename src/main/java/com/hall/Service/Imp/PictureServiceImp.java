package com.hall.Service.Imp;

import com.hall.Bean.Images;
import com.hall.Bean.ImagesExample;
import com.hall.DAO.ImagesMapper;
import com.hall.Service.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PictureServiceImp implements PictureService {
    @Resource
    ImagesMapper imagesMapper;

    @Override
    public int insertImage(String path, String url, int uid, String role){
        Images images = new Images();
        images.setImagepath(path);
        images.setUrl(url);
        images.setUid(uid);
        images.setRole(role);

        return imagesMapper.insertSelective(images);
    }

    @Override
    public int deleteImage(String url){
        ImagesExample imagesExample = new ImagesExample();
        ImagesExample.Criteria criteria = imagesExample.createCriteria();
        criteria.andUrlEqualTo(url);
        return imagesMapper.deleteByExample(imagesExample);
    }
}
