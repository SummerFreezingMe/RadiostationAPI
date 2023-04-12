package ru.bykov.radiostationapi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "radio_program")
public class RadioProgram {
    @Id
    @Column(name = "program_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long programId;

    @Column(name = "program_name")
    private String programName;

    @Column(name = "program_type")
    private String programType;

    @Column(name = "length")
    private Integer length;

    @Column(name = "starting_date")
    private LocalDateTime startingDate;

}
