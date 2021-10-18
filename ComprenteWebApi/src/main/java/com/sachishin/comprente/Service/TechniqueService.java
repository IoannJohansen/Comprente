package com.sachishin.comprente.Service;

import com.sachishin.comprente.Repository.model.Technique;
import com.sachishin.comprente.Repository.model.User;

import java.util.List;

public interface TechniqueService {
    Technique findById(Long id);
    Technique findByName(String name);
    void saveTechnique(Technique technique);
    void updateTechnique(Technique technique);
    void deleteTechniqueById(Long id);
    void deleteAllTechnique();
    List<Technique> findAllTechnique();
    boolean isTechniqueExist(Technique technique);
}
