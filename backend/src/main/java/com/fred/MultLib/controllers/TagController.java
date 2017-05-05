package com.fred.MultLib.controllers;

import com.fred.MultLib.models.Tag;
import com.fred.MultLib.services.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagServiceImpl tagService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody public List<Tag> get(@RequestParam(value = "libraryId", required = false) Integer libraryId,
                                       @RequestParam(value = "elementId", required = false) Integer elementId,
                                       HttpServletResponse response) {
        List<Tag> tags;
        try {
            if(libraryId == null && elementId == null){
                //response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Either libraryId or elementId should be entered as parameter.");
                //throw (new Exception("At least one parameter should be entered"));
                return null;
            } else if(elementId != null) {
                tags = tagService.getTagsByElementId(elementId);
            } else {
                tags = tagService.getTagsByLibraryId(libraryId);
            }
        } catch (Exception ex) {
            return null;
        }
        return tags;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    Tag add(@RequestBody Tag tag) {
        try {
            tag = tagService.add(tag);
        } catch (Exception ex) {
            throw (ex);
        }
        return tag;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Tag tag) {
        try {
            tagService.delete(tag);
        } catch (Exception ex) {
            throw (ex);
        }
    }


}
