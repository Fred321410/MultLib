package com.fred.MultLib.services;

import com.fred.MultLib.models.Library;

import java.util.List;

public interface LibraryService {

    Library getTagByName(String name);

    List<Library> getAll();

    Library add(Library library);

}
