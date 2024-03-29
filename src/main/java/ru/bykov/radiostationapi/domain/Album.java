package ru.bykov.radiostationapi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long albumId;

    private String albumTitle;

    private Integer albumYear;

    private Long artistId;

}
