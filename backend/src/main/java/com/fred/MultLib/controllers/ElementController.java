package com.fred.MultLib.controllers;

import com.fred.MultLib.models.Element;
import com.fred.MultLib.services.ElementService;
import com.fred.MultLib.services.ElementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/element")
public class ElementController {

    @Autowired
    private ElementServiceImpl elementService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody public List<Element> get(@RequestParam(value = "libraryId") Integer libraryId) {
        List<Element> elements;
        try {
            if(libraryId == null){
                elements = elementService.getAll();
            } else {
                elements = elementService.getElementByLibraryId(libraryId);
            }
        } catch (Exception ex) {
            return null;
        }
        return elements;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    Element add(@RequestBody Element element) {
        try {
            element = elementService.add(element);
        } catch (Exception ex) {
            throw (ex);
        }
        return element;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Element element) {
        try {
            elementService.delete(element);
        } catch (Exception ex) {
            throw (ex);
        }
    }


}
