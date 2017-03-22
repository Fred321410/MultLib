package com.fred.MultLib.models.dao;

import com.fred.MultLib.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagDao extends CrudRepository<Tag, Long> {

    Tag findByName(String name);
}
