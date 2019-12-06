package sender;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueSender;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySenderTopic {

	public static void main(String[] args) {

		try
		{
			
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
			TopicConnectionFactory factory = (TopicConnectionFactory) applicationContext.getBean("connectionFactory");
			
			Topic queue = (Topic) applicationContext.getBean("queue");
			TopicSession session;
			QueueConnection cnnx;
			QueueSender sender;
			TextMessage message;
			
			// Create a connection. See https://docs.oracle.com/javaee/7/api/javax/jms/package-summary.html	
			cnnx = (QueueConnection) factory.createConnection();
			System.out.println("Creation of the connexion.");	
			
			// Open a session without transaction and acknowledge automatic
			session = (TopicSession) cnnx.createSession(false, Session.AUTO_ACKNOWLEDGE);
			System.out.println("Creation of the session.");
			
			// Start the connection
			cnnx.start();
			System.out.println("Launching the connexion.");	
			
			// Create a sender
			sender = session.createSubscriber(Topic);
			System.out.println("Sender Created");
					
			// Create a message
			message = session.createTextMessage("This is the first message. Well done ! ");
			System.out.println("Messsage written.");	
			
			// Send the message
			sender.send(queue, message);
			System.out.println("Message sent.");		
			
			// Close the session
			session.close();
			System.out.println("Session expired.");	
			
			// Close the connection
			cnnx.close();
			System.out.println("Connexion closed.");	

		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
