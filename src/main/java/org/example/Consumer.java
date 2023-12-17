package org.example;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;
public class Consumer {
    public static void main(String[] args) {
        try {
            // Initialisation de la ConnectionFactory pour se connecter au broker ActiveMQ
            ConnectionFactory conx = new ActiveMQConnectionFactory("tcp://localhost:61617");
            // Création d'une connexion vers le broker ActiveMQ
            Connection connection = conx.createConnection();
            // Démarrage de la connexion
            connection.start();
            // Création d'une session transactionnelle avec un accusé de réception automatique
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            // Création d'une destination de type Topic
            Destination destination = session.createTopic("MyTopic.topic");
            // Création d'un MessageConsumer associé à la destination
            MessageConsumer consumer = session.createConsumer(destination);
            // Configuration d'un MessageListener pour la réception asynchrone des messages
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    if (message instanceof TextMessage) {
                        TextMessage textMessage = (TextMessage) message;
                        try {
                            // Traitement du message reçu
                            System.out.println("Message reçu : " + textMessage.getText());
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
                    }
                }
            }








































    /*public class Consumer {
    public static void main(String[] args) {
        try {
            //nfs ili ykonecty alih consumer iconnecty aleh producer

            ConnectionFactory conx = new ActiveMQConnectionFactory("tcp://localhost:61617");// ili andha broker autrement serveur
            Connection connection = conx.createConnection();
            connection.start();
            Session session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);//ki nbaath un message lil broker est ce que send khw wla nbaath b commit kne nhotou true
            Destination destination = session.createTopic("MyTopic.topic");//kne lkat file d'attente b ism hetha tconnecty alih
            //create zeda kne mykahouch ynsn3ou //taaml verifi kbal creation
            MessageConsumer consumer = session.createConsumer(destination);
            consumer.setMessageListener(new MessageListener(){
                @Override
                public void onMessage(Message message) {
                    if (message instanceof TextMessage)
                    {
                        TextMessage textMessage =(TextMessage) message;
                        try{
                            System.out.println("Message reçu :"+textMessage);


                        }catch(Exception e){e.printStackTrace();}
                    }


        }


            });
        }catch (Exception e )
            {
                e.printStackTrace();
            }

}
    }*/