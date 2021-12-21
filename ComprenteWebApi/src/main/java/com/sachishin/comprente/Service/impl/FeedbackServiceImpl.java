package com.sachishin.comprente.Service.impl;

import com.sachishin.comprente.DTO.FeedbackDto;
import com.sachishin.comprente.Repository.FeedBackRepository;
import com.sachishin.comprente.Repository.model.FeedBack;
import com.sachishin.comprente.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedBackRepository feedBackRepository;

    @Override
    public List<FeedBack> GetFeedbackPage(int pageNum, int pageSize, int techId) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        var feedbackPage = feedBackRepository.findAllByTechniqueId(techId, pageable);
        return feedbackPage;
    }

    @Override
    public long GetCountOfTechFeedbacks(long techId) {
        var techFeedbacks = feedBackRepository.findFeedBacksByTechnique_Id(techId);
        return techFeedbacks.size();
    }

    @Override
    public void AddFeedback(FeedbackDto feedbackDto) {
        feedBackRepository.addFeedback(feedbackDto.getTechId(), feedbackDto.getUserId(), feedbackDto.getMessage());
    }
}
