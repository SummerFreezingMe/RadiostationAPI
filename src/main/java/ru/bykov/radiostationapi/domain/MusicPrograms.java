package ru.bykov.radiostationapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.bykov.radiostationapi.domain.id.MusicProgramPK;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "music_program")
@IdClass(MusicProgramPK.class)
public class MusicPrograms {
    @Id
    @Column(name = "radio_program_id")
    private Long radioProgramId;

    @Id
    @Column(name = "music_piece_id")
    private Long musicPieceId;
}
