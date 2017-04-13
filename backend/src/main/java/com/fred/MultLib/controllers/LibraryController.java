package com.fred.MultLib.controllers;

import com.fred.MultLib.models.Library;
import com.fred.MultLib.models.User;
import com.fred.MultLib.services.LibraryServiceImpl;
import com.fred.MultLib.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryServiceImpl libraryService;

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Library> get(@RequestParam(value = "libraryId", required = false) Integer libraryId, HttpServletRequest request) {
        List<Library> libraries;
        try {
            if(libraryId == null){
                libraries = libraryService.getLibraryByUser(request.getUserPrincipal().getName());
            } else {
                libraries = libraryService.getLibraryByLibraryIdAndUser(libraryId, request.getUserPrincipal().getName());
            }
        } catch (Exception ex) {
            throw (ex);
        }
        return libraries;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Library add(@RequestBody Library library, HttpServletRequest request) {
        try {
            User user = userService.getUserByUsername(request.getUserPrincipal().getName());
            library.setUser(user);
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

