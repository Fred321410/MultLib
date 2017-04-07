package com.fred.MultLib.models.dao;

import com.fred.MultLib.models.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElementDao extends JpaRepository<Element, Long> {

    List<Element> findAll();

    List<Element> findByLibrary_LibraryId(int libraryId);
}
