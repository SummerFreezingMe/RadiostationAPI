package ru.bykov.radiostationapi.domain.id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class MusicProgramPK implements Serializable{
    protected Long radioProgramId;

    protected Long musicPieceId;

    //todo: override equals() and hashCode()
}
