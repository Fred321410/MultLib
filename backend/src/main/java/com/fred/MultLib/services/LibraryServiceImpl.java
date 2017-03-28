package com.fred.MultLib.services;

import com.fred.MultLib.models.Library;
import com.fred.MultLib.models.dao.LibraryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryDao libraryDao;

    public Library getTagByName(String name) {
        Library l = new Library();
        try {
            l = libraryDao.findByName(name);
        }
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return l;
    }

    public List<Library> getAll(){
        return libraryDao.findAll();
    }

    public Library add(String name, String description){
        Library l = new Library(name, description);
        try {
            l = libraryDao.save(l);
        }
        catch (Exception ex) {
            throw (ex);
        }
        return l;
    }

}
