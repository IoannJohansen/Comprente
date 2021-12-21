package com.sachishin.comprente.Service;

import com.sachishin.comprente.DTO.FeedbackDto;
import com.sachishin.comprente.Repository.model.FeedBack;

import java.util.List;

public interface FeedbackService {
    List<FeedBack> GetFeedbackPage(int pageNum, int pageSize, int techId);
    long GetCountOfTechFeedbacks(long techId);
    void AddFeedback(FeedbackDto feedbackDto);
}
