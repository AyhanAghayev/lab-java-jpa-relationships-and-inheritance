package com.example.demo.config;

import com.example.demo.entity.*;
import com.example.demo.repository.DivisionsRepository;
import com.example.demo.repository.GuestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(
            DivisionsRepository divisionRepo,
            GuestRepository guestRepo
    ) {
        return args -> {

            Association association = new Association();
            association.setName("Nurse Association");

            List<Division> divisions = new ArrayList<>();

            for (int i = 1; i <= 7; i++) {
                Division division = new Division();
                division.setName("Division " + i);
                division.setStreet("District " + i);
                division.setAssociation(association);

                List<Member> members = new ArrayList<>();

                Member m1 = new Member();
                m1.setName("Member " + i + "A");
                m1.setStatus(Status.ACTIVE);
                m1.setRenewalDate(LocalDate.now().plusDays(30));
                m1.setDivision(division);

                Member m2 = new Member();
                m2.setName("Member " + i + "B");
                m2.setStatus(Status.LAPSED);
                m2.setRenewalDate(LocalDate.now().minusDays(10));
                m2.setDivision(division);

                members.add(m1);
                members.add(m2);

                division.setMembers(members);
                division.setPresident(m1);

                divisions.add(division);
            }

            association.setDivisions(divisions);

            divisionRepo.saveAll(divisions);

            Guest g1 = new Guest();
            g1.setTitle("John");
            g1.setGuestStatus(GuestStatus.ATTENDING);

            Guest g2 = new Guest();
            g2.setTitle("Alice");
            g2.setGuestStatus(GuestStatus.NOT_ATTENDING);

            Guest g3 = new Guest();
            g3.setTitle("Bob");
            g3.setGuestStatus(GuestStatus.NO_RESPONSE);

            guestRepo.saveAll(List.of(g1, g2, g3));

            Conference conference = new Conference();
            conference.setTitle("Tech Conference");
            conference.setDate(LocalDate.now().plusDays(10));
            conference.setDuration(120);
            conference.setLocation("Baku");
            conference.setGuests(List.of(g1, g2));

            Exhibition exhibition = new Exhibition();
            exhibition.setTitle("Art Expo");
            exhibition.setDate(LocalDate.now().plusDays(20));
            exhibition.setDuration(90);
            exhibition.setLocation("Baku");
            exhibition.setGuests(List.of(g2, g3));
            Speaker s1 = new Speaker();
            s1.setName("Speaker 1");
            s1.setPresentationDuration(30);
            s1.setConference(conference);

            Speaker s2 = new Speaker();
            s2.setName("Speaker 2");
            s2.setPresentationDuration(45);
            s2.setConference(conference);

            conference.setSpeakers(List.of(s1, s2));

            System.out.println("sample data loaded!");
        };
    }
}