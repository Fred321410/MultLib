package com.fred.MultLib.services;

import com.fred.MultLib.models.Library;
import com.fred.MultLib.models.dao.LibraryDao;
import com.fred.MultLib.models.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryDao libraryDao;

    @Autowired
    UserDao userDao;

    public List<Library> getLibraryByLibraryIdAndUser(int libraryId, String username) {
        List<Library> libraries = new ArrayList<>();
        try {
            libraries = getLibraryByUser(username);
        }
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return libraries.stream().filter(library -> library.getLibraryId() == libraryId).collect(Collectors.toList());
    }

    public List<Library> getLibraryByUser(String username){
        List<Library> libraries = new ArrayList<>();
        libraries.addAll(userDao.findByUsername(username).getLibraries());
        return libraries;
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
