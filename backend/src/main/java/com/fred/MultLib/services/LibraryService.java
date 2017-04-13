package com.fred.MultLib.services;

import com.fred.MultLib.models.Library;

import java.util.List;

public interface LibraryService {



    List<Library> getLibraryByLibraryIdAndUser(int libraryId, String username);

    List<Library> getAll();

    List<Library> getLibraryByUser(String username);

    Library add(Library library);

    void delete(Library library);


}
