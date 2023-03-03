package ru.bykov.radiostationapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "music_pieces")
public class RadioProgram {
    @Id
    private Long programId;

    private String programName;

    private String programType;

    private Integer length;

    private LocalDate startingDate;
}
