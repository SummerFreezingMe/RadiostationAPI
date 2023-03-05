package ru.bykov.radiostationapi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long artistId;

    private String artistName;

    public Artist(String artistName) {
        this.artistName = artistName;
    }
}
