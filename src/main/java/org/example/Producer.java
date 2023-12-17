package org.example;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;
public class Producer {
    public static void main(String[] args) {
        try {
            // Création d'une ConnectionFactory avec l'URL du broker ActiveMQ
            ConnectionFactory conx = new ActiveMQConnectionFactory("tcp://localhost:61617");
            // Création d'une connexion à partir de la ConnectionFactory
            Connection connection = conx.createConnection();
            // Démarrage de la connexion
            connection.start();
            // Création d'une session pour la transaction avec AUTO_ACKNOWLEDGE
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            // Création d'une destination (dans ce cas, un Topic nommé "MyTopic.topic")
            Destination destination = session.createTopic("MyTopic.topic");
            // Création d'un MessageProducer pour la destination
            MessageProducer producer = session.createProducer(destination);
            // Configuration du mode de livraison des messages (NON_PERSISTENT)
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            // Création d'un TextMessage
            TextMessage message = session.createTextMessage();
            message.setText("hello world !"); // Définition du contenu du message
            // Envoi du message au Topic associé au MessageProducer
            producer.send(message);
            // Validation de la transaction pour la session
            session.commit();
            // Fermeture de la session et de la connexion
            session.close();
            connection.close();
        }
       catch (Exception e){
            e.printStackTrace();
        }

    }}

















































/*package org.example;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
//producer ybaaath lilfile de attente ( mawjouda fi broker)
//mkch tstana fi chkoun ijwbha hiya asynchrone
//nconnecty ala broker (active)
public class Producer {
    public static void main(String[] args) {
        try {
            //nsna3 fi conx ala broker
            ConnectionFactory conx = new ActiveMQConnectionFactory("tcp://localhost:61617");// ili andha broker autrement serveur
            Connection connection = conx.createConnection();
            connection.start();// 3ibara ala thread nsthak ini nlancih
            //broker ynjm ykhdm ala plusierus session
            Session session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);//ki nbaath un message lil broker est ce que send khw wla nbaath b commit kne nhotou true
            // maanha mttbath kne bil commit ilmdhom lkol kne nhotha false ybaath kol send whdha
            //custoumer ybaath acuse de reception w auto tkrah les acuses
            //auto_A maanha par defaut ykrah bch yjwb cusmer
            // type topic laabed lkol cust lkol ili connecté alih  ybaathlhom nfs whda
            Destination destination = session.createTopic("MyTopic.topic");// type mtaa file d'attente hiya topic
            MessageProducer producer = session.createProducer(destination);// yktb fi mytopic
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            //bch nktb message
            TextMessage message = session.createTextMessage();
            message.setText("hello world !");
            producer.send(message);
            session.commit();
            session.close();
            connection.close();


        }
       catch (Exception e){
            e.printStackTrace();
        }

    }}*/