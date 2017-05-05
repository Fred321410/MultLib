package com.fred.MultLib.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fred.MultLib.models.Library;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="element", uniqueConstraints = @UniqueConstraint(columnNames = {"element_name", "library_id"}))
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="element_id")
    private int elementId;

    @ManyToOne(cascade= {CascadeType.REFRESH})
    @JoinColumn(name="library_id")
    @JsonBackReference(value="library-elements")
    private Library library;

    @ManyToMany(cascade= {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "element_tag", joinColumns = { @JoinColumn(name = "element_id", referencedColumnName = "element_id") }, inverseJoinColumns = { @JoinColumn(name = "tag_id", referencedColumnName = "tag_id") })
    @JsonManagedReference(value="elements-tags")
    @JsonIgnore
    private Set<Tag> tags = new HashSet<>(0);


    @NotNull
    @Column(name="element_name")
    private String elementName;

    @Column(name="element_description")
    private String elementDescription;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Date creationDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modification_date")
    private Date modificationDate;


    public Element(Library library, String elementName, String elementDescription) {
        this.library = library;
        this.elementName = elementName;
        this.elementDescription = elementDescription;
    }

    public Element(){

    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementDescription() {
        return elementDescription;
    }

    public void setElementDescription(String elementDescription) {
        this.elementDescription = elementDescription;
    }

    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        if( ! (obj instanceof Element) ) return false;

        Element other = (Element) obj;

        if(this.elementName == null){
            if(other.elementName != null){
                return false;
            }
        } else {
            if(!other.elementName.equals(this.elementName)){
                return false;
            }
        }

        return this.library == other.library;

    }

}
