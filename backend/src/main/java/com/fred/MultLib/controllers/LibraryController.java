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

    @RequestMapping(path = "/getByName", method = RequestMethod.GET)
    public Library getTagByName(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        Library t;
        try {
            t = libraryService.getTagByName(name);
        } catch (Exception ex) {
            return null;
        }
        return t;
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public List<Library> getAll() {
        List<Library> libraries;
        try {
            libraries = libraryService.getAll();
        } catch (Exception ex) {
            return null;
        }
        return libraries;
    }

    @RequestMapping(path = "/add",method = RequestMethod.POST)
    public Library add(@RequestParam(value = "name", required = true) String name, @RequestParam(value = "description", required = false) String description) {
        Library t;
        try {
            t = libraryService.add(name, description);
        } catch (Exception ex) {
            throw (ex);
        }
        return t;
    }



}
