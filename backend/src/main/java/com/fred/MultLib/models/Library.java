package com.fred.MultLib.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="library", uniqueConstraints = {@UniqueConstraint(columnNames = {"library_name", "user_id"})})
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="library_id")
    private int libraryId;

    @NotNull
    @Column(name="library_name")
    private String libraryName;

    @Column(name="library_description")
    private String libraryDescription;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Date creationDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modification_date")
    private Date modificationDate;

    @OneToMany(mappedBy="library", cascade=CascadeType.ALL)
    @JsonManagedReference(value="library-elements")
    private Set<Element> elements;

    @OneToMany(mappedBy="library", cascade=CascadeType.ALL)
    @JsonManagedReference(value="library-tags")
    private Set<Tag> tags;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH} )
    @JoinColumn(name="user_id")
    private User user;



    public Library(){}

    public Library(int libraryId){
        this.libraryId = libraryId;
    }

    public Library(String libraryName) {
        this.libraryName = libraryName;
    }

    public Library(String libraryName, String libraryDescription) {
        this.libraryName = libraryName;
        this.libraryDescription = libraryDescription;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    public String getLibraryDescription() {
        return libraryDescription;
    }

    public void setLibraryDescription(String libraryDescription) {
        this.libraryDescription = libraryDescription;
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

    @Override
    public String toString(){
        return "Library => libraryId: " + this.libraryId
                + ";libraryName: " + this.libraryName
                + ";libraryDescription: " + this.libraryDescription
                + ";CreationDate: " + this.creationDate
                + ";ModificationDate: " + this.modificationDate;
    }

    public Set<Element> getElements() {
        return elements;
    }

    public void setElements(Set<Element> elements) {
        this.elements = elements;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        if( ! (obj instanceof Library) ) return false;

        Library other = (Library) obj;

        if(this.libraryName == null){
            if(other.libraryName != null){
                return false;
            }
        } else {
            if(!other.libraryName.equals(this.libraryName)){
                return false;
            }
        }

        return this.user == other.user;

    }
}
