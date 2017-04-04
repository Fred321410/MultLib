package com.fred.MultLib.models.dao;

import com.fred.MultLib.models.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryDao extends JpaRepository<Library, Long> {

    Library findByLibraryId(int libraryId);

    List<Library> findAll();

}
