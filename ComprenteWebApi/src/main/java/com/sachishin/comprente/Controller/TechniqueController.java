package com.sachishin.comprente.Controller;

import com.sachishin.comprente.DTO.CreateTechniqueRequestDto;
import com.sachishin.comprente.DTO.FeedbackDto;
import com.sachishin.comprente.DTO.PagedItemsResponse;
import com.sachishin.comprente.DTO.UpdateTechniqueDto;
import com.sachishin.comprente.Repository.model.FeedBack;
import com.sachishin.comprente.Repository.model.Technique;
import com.sachishin.comprente.Service.FeedbackService;
import com.sachishin.comprente.Service.ImageService;
import com.sachishin.comprente.Service.TechniqueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("api/tech")
@CrossOrigin("**")
public class TechniqueController {

    @Autowired
    private TechniqueService techniqueService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping(value = "/getTechPaged", method = RequestMethod.GET)
    public PagedItemsResponse<Technique> GetTechniquePaged(int pageNum, int pageSize){
        var techniquePage = new PagedItemsResponse<Technique>();
        techniquePage.TotalCount = techniqueService.GetCount();
        techniquePage.Items = techniqueService.GetPaged(pageNum, pageSize);
        return techniquePage;
    }

    @RequestMapping(value = "/removeTechById", method = RequestMethod.DELETE)
    public ResponseEntity<?> RemoveTechById(@RequestParam long techId){
        log.info("Delete: " + techId);
        try{
            techniqueService.deleteTechniqueById(techId);
        }catch (Exception ex){
            log.info("Techniques not found");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/updateTech", method = RequestMethod.PUT)
    public ResponseEntity<?> UpdateTechnique(@RequestBody UpdateTechniqueDto updateDto){
        var techById = techniqueService.findById(updateDto.Id);
        if (techniqueService.isTechniqueExist(techById)){
                techniqueService.updateTechnique(updateDto);
                imageService.RemoveByTechId(techById.getId());
                imageService.AddImagesToTechnique(techById.getId(), updateDto.images);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/createTechnique", method = RequestMethod.POST)
    public ResponseEntity<?> CreateTechnique(@RequestBody CreateTechniqueRequestDto createDto){
        var newTech = new Technique();
        newTech.setDescription(createDto.description);
        newTech.setDatePublish(Date.valueOf(LocalDate.now()));
        newTech.setName(createDto.name);
        newTech.setRentPrice(createDto.rentPrice);
        techniqueService.saveTechnique(newTech);
        imageService.AddImages(newTech, createDto.images);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getTechniqueDescription", method = RequestMethod.GET)
    public ResponseEntity<?> GetTechniqueById(@RequestParam long id){
        var technique = techniqueService.GetTechniqueById(id);
        return technique!=null?new ResponseEntity<>(technique, HttpStatus.OK):new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/isRentable", method = RequestMethod.GET)
    public boolean TechIsRentable(@RequestParam long id){
        return techniqueService.TechIsRentable(id);
    }

    @RequestMapping(value = "/getTechniqueFeedbacksPaged", method = RequestMethod.GET)
    public PagedItemsResponse<FeedBack> GetFeedbacksPaged(@RequestParam int pageNum, @RequestParam int pageSize, @RequestParam int techId){
        var feedbackPage = new PagedItemsResponse<FeedBack>();
        feedbackPage.TotalCount = feedbackService.GetCountOfTechFeedbacks(techId);
        feedbackPage.Items = feedbackService.GetFeedbackPage(pageNum, pageSize, techId);
        return feedbackPage;
    }

    @RequestMapping(value = "/addFeedback", method = RequestMethod.POST)
    public ResponseEntity<?>AddFeedback(@RequestBody FeedbackDto feedback){
        System.out.println(feedback);
        feedbackService.AddFeedback(feedback);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}