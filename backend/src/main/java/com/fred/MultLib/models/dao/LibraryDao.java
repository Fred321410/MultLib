package com.fred.MultLib.models.dao;

import com.fred.MultLib.models.Library;
import com.fred.MultLib.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryDao extends JpaRepository<Library, Long> {

    Library findByLibraryIdAndUser(int libraryId, User user);

    List<Library> findByUser(User user);

    List<Library> findAll();

}
