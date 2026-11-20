package org.sebsy.bestioles.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.sebsy.bestioles.notif.Notifier;

class AdoptionServiceTest {

    @Test
    void adopterEnvoieLaDateDuJourAParis() {
        List<String> recus = new ArrayList<>();
        Notifier notifier = (to, message) -> recus.add(to + " <- " + message);
        Clock clock = Clock.fixed(Instant.parse("2026-12-31T23:30:00Z"), ZoneId.of("Europe/Paris"));

        AdoptionService service = new AdoptionService(notifier, clock);
        LocalDate date = service.adopter("Rex", "lea@exemple.fr");

        assertEquals(LocalDate.of(2027, 1, 1), date);
        assertEquals(List.of("lea@exemple.fr <- Adoption de Rex confirmée le 01/01/2027"), recus);
    }
}