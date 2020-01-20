package com.kodilla.collectionmanagerbackend.scheduler;

import com.kodilla.collectionmanagerbackend.controller.IsbndbController;
import com.kodilla.collectionmanagerbackend.domain.Mail;
import com.kodilla.collectionmanagerbackend.domain.MailGeneratorType;
import com.kodilla.collectionmanagerbackend.repository.BookRepository;
import com.kodilla.collectionmanagerbackend.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Books: once a day email";

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private IsbndbController isbndbController;

    @Scheduled(fixedDelay = 10000000) //@Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        float size = IsbndbController.numberOfCalls;
        String t = " request";
        if (size != 1) t += "s";
        simpleEmailService.send(new Mail(
                MailGeneratorType.EMAIL_FROM_EMAIL_SCHEDULER,
                "y.neczek@gmail.com",
                SUBJECT,
                "Currently you have reached " + String.format("%.0f%%", size/50*100) + " of " + t
        ));
    }
}
