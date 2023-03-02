package ru.bykov.radiostationapi.domain;

import java.time.LocalDate;
import java.util.List;

public class RadioProgram {
    private Long programId;

    private List<MusicPiece> setOfSongs;

    private String programType;

    private Integer length;

    private LocalDate startingDate;
}
