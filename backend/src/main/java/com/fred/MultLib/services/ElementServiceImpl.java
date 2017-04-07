package com.fred.MultLib.services;

import com.fred.MultLib.models.Element;
import com.fred.MultLib.models.dao.ElementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ElementServiceImpl implements ElementService{

    @Autowired
    private ElementDao elementDao;

    public List<Element> getAll(){
        return elementDao.findAll();
    }

    public List<Element> getElementByLibraryId(int libraryId){
        List<Element> elements = new ArrayList<>();
        try {
            elements = elementDao.findByLibrary_LibraryId(libraryId);
        }
        catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return elements;
    }

    public Element add(Element element){
        try{
            element = elementDao.save(element);
        }catch (Exception ex){
            throw (ex);
        }
        return element;
    }

    public void delete(Element element){
        try{
            elementDao.delete(element);
        }catch (Exception ex){
            throw (ex);
        }
    }

}
