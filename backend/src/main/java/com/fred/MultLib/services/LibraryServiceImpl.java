package com.fred.MultLib.services;

import com.fred.MultLib.models.Library;
import com.fred.MultLib.models.dao.LibraryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryDao libraryDao;

    public List<Library> getLibraryByLibraryId(int libraryId) {
        List<Library> librairies = new ArrayList<>();
        try {
            Library l = libraryDao.findByLibraryId(libraryId);
            if (l != null){
                librairies.add(libraryDao.findByLibraryId(libraryId));
            } else {
                return null;
            }
        }
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return librairies;
    }

    public List<Library> getAll(){
        return libraryDao.findAll();
    }

    public Library add(Library library){
        try {
            library = libraryDao.save(library);
        }
        catch (Exception ex) {
            throw (ex);
        }
        return library;
    }

    public void delete(Library library){
        try{
            libraryDao.delete(library);
        }
        catch (Exception ex){
            throw (ex);
        }

    }



}
