package org.example;

import org.apache.activemq.broker.BrokerService;

public class ActiveMQBroker {
    public static void main(String[] args)
    {
        try
        {
            // Création d'un nouvel objet BrokerService qui représente le broker ActiveMQ
            BrokerService brokerService = new BrokerService();
            // Ajout d'un connecteur TCP au broker pour écouter sur toutes les interfaces sur le port 61617
            brokerService.addConnector("tcp://0.0.0.0:61617");
            // Démarrage effectif du broker ActiveMQ
            brokerService.start();

        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
