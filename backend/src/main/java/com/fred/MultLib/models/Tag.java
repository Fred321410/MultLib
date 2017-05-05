package com.fred.MultLib.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tag", uniqueConstraints = @UniqueConstraint(columnNames = {"tag_name", "library_id"}))
public class Tag {
    public Tag(Library library, String tagName, String tagDescription) {
        this.library = library;
        this.tagName = tagName;
        this.tagDescription = tagDescription;
    }

    public Tag(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="tag_id")
    private int tagId;

    @ManyToOne(cascade= {CascadeType.REFRESH})
    @JoinColumn(name="library_id")
    @JsonBackReference(value="library-tags")
    private Library library;
    //TODO EQUALS AND HASH

    @NotNull
    @Column(name="tag_name")
    private String tagName;

    @Column(name="tag_description")
    private String tagDescription;

    @ManyToMany(cascade= {CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "tags")
    @JsonBackReference(value="elements-tags")
    private Set<Element> elements = new HashSet<>(0);

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Date creationDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modification_date")
    private Date modificationDate;


    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagDescription() {
        return tagDescription;
    }

    public void setTagDescription(String tagDescription) {
        this.tagDescription = tagDescription;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Set<Element> getElements() {
        return elements;
    }

    public void setElements(Set<Element> elements) {
        this.elements = elements;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        if( ! (obj instanceof Tag) ) return false;

        Tag other = (Tag) obj;

        if(this.tagName == null){
            if(other.tagName != null){
                return false;
            }
        } else {
            if(!other.tagName.equals(this.tagName)){
                return false;
            }
        }

        return this.library == other.library;

    }

}
