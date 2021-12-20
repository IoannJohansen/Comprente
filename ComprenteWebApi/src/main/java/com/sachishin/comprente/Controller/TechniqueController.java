package com.sachishin.comprente.Controller;

import com.sachishin.comprente.DTO.CreateTechniqueRequestDto;
import com.sachishin.comprente.DTO.PagedItemsResponse;
import com.sachishin.comprente.DTO.UpdateTechniqueDto;
import com.sachishin.comprente.Repository.model.Technique;
import com.sachishin.comprente.Service.ImageService;
import com.sachishin.comprente.Service.TechniqueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Objects;


@Slf4j
@RestController
@RequestMapping("api/tech")
public class TechniqueController {

    @Autowired
    private TechniqueService techniqueService;

    @Autowired
    private ImageService imageService;


    @RequestMapping(value = "/getTechPaged", method = RequestMethod.GET)
    public PagedItemsResponse<Technique> GetTechniquePaged(int pageNum, int pageSize){
        var techniquePage = new PagedItemsResponse<Technique>();
        techniquePage.TotalCount = techniqueService.findAllTechnique().size();
        Technique[] items = Arrays.copyOfRange(techniqueService.findAllTechnique().toArray(Technique[]::new), pageNum*pageSize, (pageNum*pageSize)+pageSize);
        techniquePage.Items = Arrays.stream(items).filter(Objects::nonNull).toArray(Technique[]::new);
        return techniquePage;
    }

    @RequestMapping(value = "/removeTechById", method = RequestMethod.DELETE)
    public ResponseEntity<?> RemoveTechById(@RequestParam long techId){
        techniqueService.deleteTechniqueById(techId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/updateTech", method = RequestMethod.PUT)
    public ResponseEntity<?> UpdateTechnique(@RequestBody UpdateTechniqueDto updateDto){
        var techById = techniqueService.findById(updateDto.Id);
        if (techniqueService.isTechniqueExist(techById)){
            techniqueService.deleteTechniqueById(updateDto.Id);
            var newTech = new Technique();
            newTech.setDescription(updateDto.description);
            newTech.setDatePublish(updateDto.datePublish);
            newTech.setName(updateDto.name);
            newTech.setRentPrice(updateDto.rentPrice);
            techniqueService.saveTechnique(newTech);
            imageService.AddImages(newTech, updateDto.images);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/createTechnique", method = RequestMethod.POST)
    public ResponseEntity<?> CreateTechnique(@RequestBody CreateTechniqueRequestDto createDto){
        var newTech = new Technique();
        newTech.setDescription(createDto.description);
        newTech.setDatePublish(createDto.datePublish);
        newTech.setName(createDto.name);
        newTech.setRentPrice(createDto.rentPrice);
        techniqueService.saveTechnique(newTech);
        imageService.AddImages(newTech, createDto.images);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
