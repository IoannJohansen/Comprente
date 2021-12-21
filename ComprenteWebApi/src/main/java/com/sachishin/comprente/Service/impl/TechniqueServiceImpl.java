package com.sachishin.comprente.Service.impl;

import com.sachishin.comprente.Repository.TechniqueRepository;
import com.sachishin.comprente.Repository.model.Technique;
import com.sachishin.comprente.Service.TechniqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TechniqueServiceImpl implements TechniqueService {

    @Autowired
    private TechniqueRepository techinqueRepository;

    @Override
    public Technique findById(Long id) {
        return techinqueRepository.getById(id);
    }

    @Override
    public Technique findByName(String name) {
        return techinqueRepository.findByName(name);
    }

    @Override
    public void saveTechnique(Technique technique) {
        techinqueRepository.save(technique);
    }

    @Override
    public void updateTechnique(Technique technique) {
        techinqueRepository.save(technique);
    }

    @Override
    public void deleteTechniqueById(Long id) {
        try {
            techinqueRepository.deleteById(id);
        }catch (Exception ex){
        }
    }

    @Override
    public void deleteAllTechnique() {
        techinqueRepository.deleteAll();
    }

    @Override
    public List<Technique> findAllTechnique() {
        return techinqueRepository.findAll();
    }

    @Override
    public boolean isTechniqueExist(Technique technique) {
        return techinqueRepository.existsById(technique.getId());
    }

    @Override
    public List<Technique> GetPaged(int pageNum, int pageSize) {
        Pageable pageOfTechnique = PageRequest.of(pageNum, pageSize);
        return techinqueRepository.findAll(pageOfTechnique).toList();
    }

    @Override
    public long GetCount() {
        return techinqueRepository.count();
    }

    @Override
    public Technique GetTechniqueById(long id) {
        return techinqueRepository.findById(id);
    }

    @Override
    public boolean TechIsRentable(long id) {
        return techinqueRepository.checkForRentAvailability(id)==0;
    }
}
