package com.fred.MultLib.services;

import com.fred.MultLib.models.Library;

import java.util.List;

public interface LibraryService {



    List<Library> getLibraryByLibraryId(int libraryId);

    List<Library> getAll();

    Library add(Library library);

    void delete(Library library);


}
