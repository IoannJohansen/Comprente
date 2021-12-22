package com.sachishin.comprente.Service.impl;

import com.sachishin.comprente.Repository.ImageRepository;
import com.sachishin.comprente.Repository.model.Images;
import com.sachishin.comprente.Repository.model.Technique;
import com.sachishin.comprente.Service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public void AddImages(Technique tech, Collection<String> images) {
        for (String image:
             images) {
            var newImage = new Images();
            newImage.setPath(image);
            newImage.setTechnique(tech);
            imageRepository.save(newImage);
        }
    }

    @Override
    public void RemoveByTechId(long techId) {
        try{
            var resdel = imageRepository.deleteByTechniqueId(techId);
        }catch (Exception ex){
            log.error(ex.toString());
        }
    }

    @Override
    public void AddImagesToTechnique(long techId, Collection<String> images) {
        for (var image :
                images) {
            imageRepository.addImageToTech(image, techId);
        }
    }
}
