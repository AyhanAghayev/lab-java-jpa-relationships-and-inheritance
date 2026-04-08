package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "guests")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 20)
    private String name;
    @Enumerated(EnumType.STRING)
    private GuestStatus guestStatus;
    @ManyToMany(mappedBy = "guests")
    private List<Event> events;

    public Guest(){}

    public Guest(Long id, String name, GuestStatus guestStatus, List<Event> events) {
        this.id = id;
        this.name = name;
        this.guestStatus = guestStatus;
        this.events = events;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public GuestStatus getGuestStatus() {
        return guestStatus;
    }

    public void setGuestStatus(GuestStatus guestStatus) {
        this.guestStatus = guestStatus;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
