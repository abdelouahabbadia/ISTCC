package receiver;

import javax.jms.Connection;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyReceiver {

	public static void main(String[] args) {
		try{
			
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
			QueueConnectionFactory factory = (QueueConnectionFactory) applicationContext.getBean("connectionFactory");
			
			Queue queue = (Queue) applicationContext.getBean("queue");
			QueueConnection cnnx;
			QueueReceiver receiver;
			QueueSession session;
			Message receivedMessage;
			
			// Create a connection. See https://docs.oracle.com/javaee/7/api/javax/jms/package-summary.html
			cnnx = (QueueConnection) factory.createConnection();
			System.out.println("Creation of the connexion.");	
			
			// Open a session
			session = (QueueSession) cnnx.createSession(false, Session.AUTO_ACKNOWLEDGE);
			System.out.println("Session opened.");
			
			// start the connection	
			cnnx.start();
			System.out.println("Connexion opened.");
			
			// Create a receive	
			receiver = session.createReceiver(queue);
			System.out.println("Receiver created.");
			
			// Receive the message
			receivedMessage = receiver.receive();
			System.out.println("The received message is: " + receivedMessage);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
