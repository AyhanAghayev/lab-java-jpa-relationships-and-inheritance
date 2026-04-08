package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 20)
    private String company;
    @Column(nullable = false,length = 20)
    private String title;
    @AttributeOverrides({
            @AttributeOverride(name="salutation",column = @Column(name = "contact_salutation",nullable = false)),
            @AttributeOverride(name="firstName",column = @Column(name = "contact_firstName",nullable = false)),
            @AttributeOverride(name="middleName",column = @Column(name = "contact_middleName",nullable = false)),
            @AttributeOverride(name="lastName",column = @Column(name = "contact_lastName",nullable = false))
    })
    @Embedded
    private Name name;

    public Contact(){}

    public Contact(Long id, String company, Name name, String title) {
        this.id = id;
        this.company = company;
        this.name = name;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
