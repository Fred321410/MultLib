package com.fred.MultLib.services;

import com.fred.MultLib.models.Tag;
import com.fred.MultLib.models.dao.TagDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TagServiceImpl implements TagService{

    @Autowired
    private TagDao tagDao;

    public Tag getTagByName(String name) {
        System.out.println(name);
        Tag t = new Tag();
        try {
            t = tagDao.findByName(name);
        }
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return t;
    }

}
