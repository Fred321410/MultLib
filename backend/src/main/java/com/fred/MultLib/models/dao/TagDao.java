package com.fred.MultLib.models.dao;

import com.fred.MultLib.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by florentin.m on 04/04/2017.
 */
public interface TagDao extends JpaRepository<Tag, Long> {
    List<Tag> findAll();

    List<Tag> findByElements_ElementId(int elementId);

    List<Tag> findByLibrary_LibraryId(int libraryId);
}
