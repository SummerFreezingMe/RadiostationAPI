package ru.bykov.radiostationapi.service.impl;

import org.springframework.stereotype.Service;
import ru.bykov.radiostationapi.domain.MusicPiece;
import ru.bykov.radiostationapi.domain.dto.MusicPieceDto;
import ru.bykov.radiostationapi.repositories.MusicPieceRepository;
import ru.bykov.radiostationapi.service.RepertoireService;

import java.util.*;


@Service
public class RepertoireServiceImpl implements RepertoireService {

    private final MusicPieceRepository mpr;


    public RepertoireServiceImpl(MusicPieceRepository mpr) {
        this.mpr = mpr;
    }

    public String fetchIncomingCall(Map<String, String> payload) {
        MusicPiece requestSong;
        Random r = new Random();
        List<MusicPiece> request;
        switch (payload.keySet().toArray()[0].toString()) {
            case ("song") -> request = Collections.singletonList(mpr.findByPieceId(Long.valueOf(payload.get("song"))));
            case ("artist") -> request = mpr.findByAuthor(Long.valueOf(payload.get("artist")));
            case ("album") -> request = mpr.findByAlbumName(Long.valueOf(payload.get("album")));
            case ("genre") -> request = mpr.findByGenreId(Long.valueOf(payload.get("genre")));
            default -> throw new IllegalStateException("Unexpected value: " + payload.keySet().toArray()[0].toString());
        }
        requestSong = request.get(r.nextInt(request.size()));
        requestSong.setRating(requestSong.getRating() + 1.0f);
        mpr.save(requestSong);

        return "You requested: " + requestSong.getTitle() + " by " + requestSong.getAuthorId();
    }

    public Map<String, String> addMusicPiece(MusicPieceDto payload) {
        Map<String, String> data = new HashMap<>();

        MusicPiece addition = new MusicPiece(
                    payload.getTitle(), payload.getAuthorId(), payload.getPerformerId(),
                payload.getAlbumId(), payload.getGenreId(),
                payload.getPieceLength(), 0f);
        mpr.save(addition);
        data.put("status", "200");
        return data;
    }

    public Map<String, String> deleteMusicPiece(Long musicPieceId) {
        Map<String, String> data = new HashMap<>();
        mpr.deleteById(musicPieceId);
        data.put("status", "200");
        return data;
    }
}