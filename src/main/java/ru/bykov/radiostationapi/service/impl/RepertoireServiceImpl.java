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

    public Map<String, String> fetchIncomingCall(Map<String, String> payload) {
        Map<String, String> data = new HashMap<>();
        MusicPiece requestSong;
        Random r = new Random();
        List<MusicPiece> requestOptions = new ArrayList<>();
        Optional<MusicPiece> request;
        switch (payload.keySet().toArray()[0].toString()) {
            case ("song") -> request = mpr.findById(Long.valueOf(payload.get("song")));
            case ("artist") -> request = mpr.findByAuthor(payload.get("artist"));
            case ("album") -> request = mpr.findByAlbumName(payload.get("album"));
            case ("genre") -> request = mpr.findByGenreId(Long.valueOf(payload.get("genre")));
            default -> throw new IllegalStateException("Unexpected value: " + payload.keySet().toArray()[0].toString());
        }
        request.ifPresent(requestOptions::add);
        requestSong = requestOptions.get(r.nextInt(requestOptions.size()));
        requestSong.setRating(requestSong.getRating() + 1.0f);
        mpr.save(requestSong);
        data.put("OK", "You requested: " + requestSong.getTitle() + " by " + requestSong.getAuthor());
        return data;
    }

    public Map<String, String> addMusicPiece(MusicPieceDto payload) {
        Map<String, String> data = new HashMap<>();

        MusicPiece addition = new MusicPiece(payload.getPieceId(),
                payload.getTitle(), payload.getAuthor(), payload.getPerformer(),
                payload.getAlbumName(), payload.getAlbumYear(), payload.getGenreId(),
                payload.getPieceLength(), 0f);
        mpr.save(addition);
        data.put("status", "200");
        return data;
    }

}