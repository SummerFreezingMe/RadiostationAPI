package ru.bykov.radiostationapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "radio_programs")
public class RadioProgram {
    @Id
    @Column(name = "program_id")
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
