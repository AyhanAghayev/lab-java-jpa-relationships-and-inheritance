package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "speakers")
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,length = 20)
    private String name;
    @Column(nullable = false)
    private Integer presentationDuration;
    @ManyToOne
    @JoinColumn(name = "conference_id")
    private Conference conference;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPresentationDuration() {
        return presentationDuration;
    }

    public void setPresentationDuration(Integer presentationDuration) {
        this.presentationDuration = presentationDuration;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public Speaker(){}

    public Speaker(long id, String name, Integer presentationDuration, Conference conference) {
        this.id = id;
        this.name = name;
        this.presentationDuration = presentationDuration;
        this.conference = conference;
    }
}
