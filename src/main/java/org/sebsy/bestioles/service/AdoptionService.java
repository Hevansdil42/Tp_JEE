package org.sebsy.bestioles.service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.sebsy.bestioles.notif.Notifier;
import org.springframework.stereotype.Service;

@Service
class AdoptionService {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final Notifier notifier;
    private final Clock clock;

    AdoptionService(Notifier notifier, Clock clock) {
        this.notifier = notifier;
        this.clock = clock;
    }

    LocalDate adopter(String animal, String email) {
        LocalDate date = LocalDate.now(clock);
        notifier.send(email, "Adoption de " + animal + " confirmée le " + date.format(FORMAT));
        return date;
    }
}