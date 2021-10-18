package com.sachishin.comprente.Service.impl;

import com.sachishin.comprente.Repository.TechinqueRepository;
import com.sachishin.comprente.Repository.model.Technique;
import com.sachishin.comprente.Repository.model.User;
import com.sachishin.comprente.Service.TechniqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TechniqueServiceImpl implements TechniqueService {

    @Autowired
    private TechinqueRepository techinqueRepository;

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

    }

    @Override
    public void updateTechnique(Technique technique) {
        techinqueRepository.save(technique);
    }

    @Override
    public void deleteTechniqueById(Long id) {
        techinqueRepository.deleteById(id);
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
}
