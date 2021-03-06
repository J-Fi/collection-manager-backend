package com.kodilla.collectionmanagerbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Mail {
    private MailGeneratorType mailGeneratorType;
    private String mailTo;
    private String subject;
    private String message;
}
