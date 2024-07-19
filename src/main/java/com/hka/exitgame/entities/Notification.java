package com.hka.exitgame.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    private UUID id;

    @JsonProperty("userName")
    private String userName;

    private String title;

    private String content;

    @JsonProperty("creationDate")
    private String creationDate;

    private Boolean viewed;

    private String type;
}
