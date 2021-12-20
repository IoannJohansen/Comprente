package com.sachishin.comprente.Service;

import com.sachishin.comprente.DTO.UpdateTechniqueDto;
import com.sachishin.comprente.Repository.model.Images;
import com.sachishin.comprente.Repository.model.Technique;
import com.sachishin.comprente.Repository.model.User;

import java.util.Collection;
import java.util.List;

public interface TechniqueService {
    void saveTechnique(Technique technique);
    void deleteTechniqueById(Long id);
    List<Technique> findAllTechnique();
    Technique findById(Long id);
    Technique findByName(String name);
    void updateTechnique(Technique technique);
    void deleteAllTechnique();
    boolean isTechniqueExist(Technique technique);
}
