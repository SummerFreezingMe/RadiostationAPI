package ru.bykov.radiostationapi.service.impl;

import org.springframework.stereotype.Service;
import ru.bykov.radiostationapi.domain.MusicPiece;
import ru.bykov.radiostationapi.repositories.MusicPieceRepository;
import ru.bykov.radiostationapi.service.RepertoireService;

import java.util.HashMap;
import java.util.Map;


@Service
public class RepertoireServiceImpl implements RepertoireService {

    private final MusicPieceRepository mpr;

    public RepertoireServiceImpl(MusicPieceRepository mpr) {
        this.mpr = mpr;
    }

    public Map<String, String> fetchIncomingCall(String payload) {
        Map<String, String> data = new HashMap<>();
        return data;
    }

    public Map<String, String> addMusicPiece(Map<String, String> payload) {
        Map<String, String> data = new HashMap<>();

        MusicPiece addition = new MusicPiece(Long.valueOf(payload.get("pieceId")),
                payload.get("title"), payload.get("author"), payload.get("performer"),
                payload.get("albumName"), Integer.valueOf(payload.get("albumYear")), Long.valueOf(payload.get("genreId")),
                Integer.valueOf(payload.get("pieceLength")), 0f);
        mpr.save(addition);
        data.put("status", "200");
        return data;
    }
}