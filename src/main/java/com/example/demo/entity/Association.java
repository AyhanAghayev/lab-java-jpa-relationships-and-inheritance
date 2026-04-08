package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "associations")
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false,length = 20)
    private String name;
    @OneToMany(mappedBy = "association")
    private List<Division> divisions;

    public Association(){}

    public Association(UUID id, String name, List<Division> divisions) {
        this.id = id;
        this.name = name;
        this.divisions = divisions;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Division> getDivisions() {
        return divisions;
    }

    public void setDivisions(List<Division> divisions) {
        this.divisions = divisions;
    }
}
