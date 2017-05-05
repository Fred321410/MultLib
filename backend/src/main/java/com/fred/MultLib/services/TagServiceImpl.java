package com.fred.MultLib.services;

import com.fred.MultLib.models.Tag;
import com.fred.MultLib.models.dao.TagDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TagServiceImpl implements TagService{

    @Autowired
    private TagDao tagDao;

    public List<Tag> getAll(){
        return tagDao.findAll();
    }

    public List<Tag> getTagsByElementId(int elementId){
        List<Tag> tags = new ArrayList<>();
        try {
            tags = tagDao.findByElements_ElementId(elementId);
        }
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return tags;
    }

    public List<Tag> getTagsByLibraryId(int libraryId){
        List<Tag> tags = new ArrayList<>();
        try {
            tags = tagDao.findByLibrary_LibraryId(libraryId);
        }
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return tags;
    }

    public Tag add(Tag tag){
        try{
            tag = tagDao.save(tag);
        }catch (Exception ex){
            throw (ex);
        }
        return tag;
    }

    public void delete(Tag tag){
        try{
            tagDao.delete(tag);
        }catch (Exception ex){
            throw (ex);
        }
    }

}
