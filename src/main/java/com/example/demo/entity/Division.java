package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "divisions")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 20)
    private String name;
    @Column(nullable = false,length = 50)
    private String street;
    @ManyToOne
    @JoinColumn(name = "association_id")
    private Association association;
    @OneToOne
    @JoinColumn(name = "president_id")
    private Member president;
    @OneToMany(mappedBy = "division")
    private List<Member>members;

    public Division(){}

    public Division(Long id, String name, String street, Association association, Member president, List<Member> members) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.association = association;
        this.president = president;
        this.members = members;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }

    public Member getPresident() {
        return president;
    }

    public void setPresident(Member president) {
        this.president = president;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
