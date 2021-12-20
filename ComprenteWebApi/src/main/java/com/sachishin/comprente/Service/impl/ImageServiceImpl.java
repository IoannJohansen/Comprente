package com.sachishin.comprente.Service.impl;

import com.sachishin.comprente.DTO.ImageDto;
import com.sachishin.comprente.Repository.ImageRepository;
import com.sachishin.comprente.Repository.model.Images;
import com.sachishin.comprente.Repository.model.Technique;
import com.sachishin.comprente.Service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public void AddImages(Technique tech, Collection<ImageDto> images) {
        for (ImageDto image:
             images) {
            var newImage = new Images();
            newImage.setPath(image.ImageLink);
            newImage.setTechnique(tech);
            imageRepository.save(newImage);
        }
    }

    @Override
    public void RemoveByTechId(long techId) {
        try{
            imageRepository.deleteByTechniqueId(techId);

        }catch (Exception ex){
            log.error(ex.toString());
        }
    }

    @Override
    public void AddImagesToTechnique(long techId, Collection<ImageDto> images) {
        for (var image :
                images) {
            imageRepository.addImageToTech(image.ImageLink, techId);
        }
    }
}
