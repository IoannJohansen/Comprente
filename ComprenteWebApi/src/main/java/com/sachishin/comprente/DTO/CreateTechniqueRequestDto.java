package com.sachishin.comprente.DTO;

import com.sachishin.comprente.Repository.model.Images;
import com.sun.istack.NotNull;

import java.sql.Date;
import java.util.Collection;

public class CreateTechniqueRequestDto {
    public String name;

    public String description;

    public Date datePublish;

    public long rentPrice;

    public Collection<ImageDto> images;
}
