package com.sachishin.comprente.Repository;
import com.sachishin.comprente.Repository.model.Images;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;

@Repository
public interface ImageRepository extends CrudRepository<Images, Long> {
}
