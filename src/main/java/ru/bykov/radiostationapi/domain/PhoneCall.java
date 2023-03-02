package ru.bykov.radiostationapi.domain;

import javax.persistence.Id;

public class PhoneCall {
    @Id
    private Long callId;

    private Long musicPieceId;

}
