package com.fred.MultLib.services;

import com.fred.MultLib.models.Tag;

import java.util.List;

/**
 * Created by florentin.m on 04/04/2017.
 */
public interface TagService {

    List<Tag> getAll();

    List<Tag> getTagsByElementId(int elementId);

    List<Tag> getTagsByLibraryId(int libraryId);

    Tag add(Tag tag);

    void delete(Tag tag);


}
