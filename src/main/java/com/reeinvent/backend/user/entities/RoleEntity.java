package com.reeinvent.backend.user.entities;

import com.reeinvent.backend.entities.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column
    private RoleTypeEnum name;
    @Column
    private String description;

    public RoleTypeEnum getName() {
        return name;
    }

    public void setName(RoleTypeEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
