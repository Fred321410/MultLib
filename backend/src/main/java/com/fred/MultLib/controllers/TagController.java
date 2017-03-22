package com.fred.MultLib.controllers;

import com.fred.MultLib.models.Tag;
import com.fred.MultLib.services.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagServiceImpl tagService;

    @RequestMapping(method= RequestMethod.GET)
    public Tag getTagByName(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        System.out.println(name);
        Tag t;
        try {
            t = tagService.getTagByName(name);
        }
        catch (Exception ex) {
            return null;
        }
        return t;
    }
}
