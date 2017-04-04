package com.fred.MultLib.controllers;

import com.fred.MultLib.models.Library;
import com.fred.MultLib.services.LibraryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryServiceImpl libraryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Library> get(@RequestParam(value = "libraryId", required = false) Integer libraryId) {
        List<Library> libraries;
        try {
            if(libraryId == null){
                libraries = libraryService.getAll();
            } else {
                libraries = libraryService.getLibraryByLibraryId(libraryId);
            }
        } catch (Exception ex) {
            return null;
        }
        return libraries;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Library add(@RequestBody Library library) {
        try {
            library = libraryService.add(library);
        } catch (Exception ex) {
            throw (ex);
        }
        return library;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Library library) {
        try {
            libraryService.delete(library);
        } catch (Exception ex) {
            throw (ex);
        }
    }


}

