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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="authority_id")
    private Long authorityId;

    @NotNull
    @Column(name="authority_name")
    @Enumerated(EnumType.STRING)
    private AuthorityName authorityName;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "authorities")
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
}
