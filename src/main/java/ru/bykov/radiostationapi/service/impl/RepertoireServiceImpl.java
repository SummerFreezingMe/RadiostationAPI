package ru.bykov.radiostationapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bykov.radiostationapi.domain.MusicPiece;
import ru.bykov.radiostationapi.domain.dto.in.MusicPieceDto;
import ru.bykov.radiostationapi.domain.dto.out.GetMusicPieceDto;
import ru.bykov.radiostationapi.mapper.MusicPieceMapper;
import ru.bykov.radiostationapi.repositories.MusicPieceRepository;
import ru.bykov.radiostationapi.service.RepertoireService;

import java.util.*;


@Service
public class RepertoireServiceImpl implements RepertoireService {

    private final MusicPieceRepository mpr;
    private final MusicPieceMapper mpm;
@Autowired
    public RepertoireServiceImpl(MusicPieceRepository mpr, MusicPieceMapper mpm) {
        this.mpr = mpr;
        this.mpm = mpm;
    }

    public GetMusicPieceDto fetchIncomingCall(Map<String, String> payload) {
        MusicPiece requestSong;
        Random r = new Random();
        List<MusicPiece> requestOptions = new ArrayList<>();
        Optional<MusicPiece> request;
        switch (payload.keySet().toArray()[0].toString()) {
            case ("song") -> request = mpr.findById(Long.valueOf(payload.get("song")));
            case ("artist") -> request = mpr.findByAuthor(payload.get("artist"));
            case ("album") -> request = mpr.findByAlbumName(payload.get("album"));
            case ("genre") -> request = mpr.findByGenreId(
                    Long.valueOf(payload.get("genre")));
            default -> throw new IllegalStateException("Unexpected value: "
                    + payload.keySet().toArray()[0].toString());
        }
        request.ifPresent(requestOptions::add);
        requestSong = requestOptions.get(r.nextInt(requestOptions.size()));
        requestSong.setRating(requestSong.getRating() + 1.0f);
        mpr.save(requestSong);
        return mpm.toDto(requestSong);
    }

    public GetMusicPieceDto addMusicPiece(MusicPieceDto musicPiece) {
        MusicPiece addition = mpm.toEntity(musicPiece);
        mpr.save(addition);
        return mpm.toDto(addition);
    }

    public GetMusicPieceDto deleteMusicPiece(Long musicPieceId) {
        MusicPiece deleted = mpr.findByPieceId(musicPieceId);
        mpr.delete(deleted);
        return mpm.toDto(deleted);
    }
}