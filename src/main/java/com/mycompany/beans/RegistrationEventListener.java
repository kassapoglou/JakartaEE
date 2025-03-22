package com.mycompany.beans;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.event.Observes;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSProducer;
import jakarta.jms.Queue;
import java.io.Serializable;


@SessionScoped
public class RegistrationEventListener implements Serializable {
    
        @Resource(lookup = "java:/jms/queue/QueueA")
        private Queue queue;
        
        @Resource(lookup = "java:/JmsXA")
        private ConnectionFactory connectionFactory;

    public void handleNavigationEvent(@Observes RegistrationInfo registrationInfo) throws JsonProcessingException {
        
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(registrationInfo);
        
        try (JMSContext context = connectionFactory.createContext()) {
            JMSProducer producer = context.createProducer();
            producer.send(queue, jsonString);
        
    }
    }
}
