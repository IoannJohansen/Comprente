package com.sachishin.comprente.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FeedbackDto {
    long UserId;
    long TechId;
    String Message;
}
