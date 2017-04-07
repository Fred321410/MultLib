package com.fred.MultLib.services;

import com.fred.MultLib.models.Element;

import java.util.List;

public interface ElementService {

    List<Element> getAll();

    List<Element> getElementByLibraryId(int libraryId);

    Element add(Element element);

    void delete(Element element);


}
