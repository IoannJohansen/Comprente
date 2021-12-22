package com.sachishin.comprente.Service;

import com.sachishin.comprente.DTO.UpdateTechniqueDto;
import com.sachishin.comprente.Repository.model.Technique;

import java.util.List;

public interface TechniqueService {
    void saveTechnique(Technique technique);
    void deleteTechniqueById(Long id);
    List<Technique> findAllTechnique();
    Technique findById(Long id);
    Technique findByName(String name);
    void updateTechnique(UpdateTechniqueDto updateDto);
    void deleteAllTechnique();
    boolean isTechniqueExist(Technique technique);
    List<Technique> GetPaged(int pageNum, int pageSize);
    long GetCount();
    Technique GetTechniqueById(long id);
    boolean TechIsRentable(long id);
}
