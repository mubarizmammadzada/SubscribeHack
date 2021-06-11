package com.example.subscribesystem.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subsciber {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @OneToOne
    private MyUser user;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "platform_subscriber",
    joinColumns = @JoinColumn(name = "subscriber_id"),
    inverseJoinColumns = @JoinColumn(name = "platform_id"))
    @JsonBackReference
    private List<Platform> platformList;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "remainder_id")
    @JsonBackReference
    private List<Reminder> reminderList;
}
