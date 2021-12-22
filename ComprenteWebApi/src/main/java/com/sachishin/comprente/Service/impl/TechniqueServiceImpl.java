package com.sachishin.comprente.Service.impl;

import com.sachishin.comprente.DTO.UpdateTechniqueDto;
import com.sachishin.comprente.Repository.TechniqueRepository;
import com.sachishin.comprente.Repository.model.Technique;
import com.sachishin.comprente.Service.TechniqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TechniqueServiceImpl implements TechniqueService {

    @Autowired
    private TechniqueRepository techniqueRepository;

    @Override
    public Technique findById(Long id) {
        return techniqueRepository.getById(id);
    }

    @Override
    public Technique findByName(String name) {
        return techniqueRepository.findByName(name);
    }

    @Override
    public void saveTechnique(Technique technique) {
        techniqueRepository.save(technique);
    }

    @Override
    public void updateTechnique(UpdateTechniqueDto updateDto) {
        techniqueRepository.updateTechnique(updateDto.name, updateDto.description, updateDto.rentPrice, updateDto.Id);
    }

    @Override
    public void deleteTechniqueById(Long id) {
        try {
            techniqueRepository.deleteById(id);
        }catch (Exception ex){
        }
    }

    @Override
    public void deleteAllTechnique() {
        techniqueRepository.deleteAll();
    }

    @Override
    public List<Technique> findAllTechnique() {
        return techniqueRepository.findAll();
    }

    @Override
    public boolean isTechniqueExist(Technique technique) {
        return techniqueRepository.existsById(technique.getId());
    }

    @Override
    public List<Technique> GetPaged(int pageNum, int pageSize) {
        Pageable pageOfTechnique = PageRequest.of(pageNum, pageSize, Sort.by("Id").descending());
        return techniqueRepository.findAll(pageOfTechnique).toList();
    }

    @Override
    public long GetCount() {
        return techniqueRepository.count();
    }

    @Override
    public Technique GetTechniqueById(long id) {
        return techniqueRepository.findById(id);
    }

    @Override
    public boolean TechIsRentable(long id) {
        return techniqueRepository.checkForRentAvailability(id)==0;
    }
}
