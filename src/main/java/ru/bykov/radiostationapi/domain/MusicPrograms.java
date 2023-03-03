package ru.bykov.radiostationapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.bykov.radiostationapi.domain.id.MusicProgramPK;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "music_programs")
@IdClass(MusicProgramPK.class)
public class MusicPrograms {
    @Id
    private Long radioProgramId;
    @Id
    private Long musicPieceId;
}
