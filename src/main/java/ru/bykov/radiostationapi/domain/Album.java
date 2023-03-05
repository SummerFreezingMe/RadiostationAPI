package ru.bykov.radiostationapi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long albumId;

    private String albumTitle;

    private Integer albumYear;

    private Long artistId;

    public Album(String albumTitle, Integer albumYear, Long artistId) {
        this.albumTitle = albumTitle;
        this.albumYear = albumYear;
        this.artistId = artistId;
    }
}
