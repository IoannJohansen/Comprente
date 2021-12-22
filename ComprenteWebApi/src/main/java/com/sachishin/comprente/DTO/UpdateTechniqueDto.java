package com.sachishin.comprente.DTO;

import java.sql.Date;
import java.util.Collection;

public class UpdateTechniqueDto {
    public long Id;

    public String name;

    public String description;

    public Date datePublish;

    public long rentPrice;

    public Collection<String> images;
}
