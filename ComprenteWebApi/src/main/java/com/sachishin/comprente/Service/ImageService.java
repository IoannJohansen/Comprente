package com.sachishin.comprente.Service;

import com.sachishin.comprente.DTO.ImageDto;
import com.sachishin.comprente.Repository.model.Images;
import com.sachishin.comprente.Repository.model.Technique;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Collection;


public interface ImageService {
    void AddImages(Technique tech, Collection<String> images);
    void RemoveByTechId(long techId);
    void AddImagesToTechnique(long techId, Collection<String> images);
}
