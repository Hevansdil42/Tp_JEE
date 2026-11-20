package org.sebsy.bestioles.service;

import java.util.List;

import org.sebsy.bestioles.notif.Notifier;
import org.springframework.stereotype.Service;

@Service
class AlerteService {

    private final List<Notifier> canaux;

    AlerteService(List<Notifier> canaux) {
        this.canaux = canaux;
    }

    void alerter(String destinataire, String message) {
        canaux.forEach(canal -> canal.send(destinataire, message));
    }
}