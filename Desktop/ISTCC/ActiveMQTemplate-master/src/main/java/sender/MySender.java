package sender;

import javax.jms.Connection;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.jms.QueueConnectionFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySender {

	public static void main(String[] args) {
		
		try{
			
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
			QueueConnectionFactory factory = (QueueConnectionFactory) applicationContext.getBean("connectionFactory");
			
			Queue queue = (Queue) applicationContext.getBean("queue");
			QueueSession session;
			QueueConnection cnnx;
			QueueSender sender;
			TextMessage message;
			
			// Create a connection. See https://docs.oracle.com/javaee/7/api/javax/jms/package-summary.html	
			cnnx = (QueueConnection) factory.createConnection();
			System.out.println("Creation of the connexion.");	
			
			// Open a session without transaction and acknowledge automatic
			session = (QueueSession) cnnx.createSession(false, Session.AUTO_ACKNOWLEDGE);
			System.out.println("Creation of the session.");
			
			// Start the connection
			cnnx.start();
			System.out.println("Launching the connexion.");	
			
			// Create a sender
			sender = session.createSender(queue);
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
