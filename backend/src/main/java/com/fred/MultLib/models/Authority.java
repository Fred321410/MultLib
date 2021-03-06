package com.fred.MultLib.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="authority", uniqueConstraints = @UniqueConstraint(columnNames = {"authority_name"}))
public class Authority {

    public Authority(){

    }

    public Authority(Long id, AuthorityName authorityName){
        this.authorityId = id;
        this.authorityName = authorityName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="authority_id")
    private Long authorityId;

    @NotNull
    @Column(name="authority_name")
    @Enumerated(EnumType.STRING)
    private AuthorityName authorityName;

    @JsonIgnore
    @ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "authorities")
    private Set<User> users = new HashSet<>(0);

    public Authority(AuthorityName authorityName) {
        this.authorityName = authorityName;
    }

    public Long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
    }

    public AuthorityName getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(AuthorityName authorityName) {
        this.authorityName = authorityName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        if( ! (obj instanceof Authority) ) return false;

        Authority other = (Authority) obj;

        if(this.authorityName == null){
            if(other.authorityName != null){
                return false;
            }
        } else {
            if(!other.authorityName.equals(this.authorityName)){
                return false;
            }
        }

        return true;

    }

}
