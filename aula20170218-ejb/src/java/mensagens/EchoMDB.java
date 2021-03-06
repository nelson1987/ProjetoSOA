/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensagens;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author aluno
 */
@MessageDriven(mappedName = "jms/FilaEcho", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class EchoMDB implements MessageListener {
    
    public EchoMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        TextMessage t1 = (TextMessage) message;
        try {
            System.out.println(t1.getText());
        } catch (JMSException ex) {
            Logger.getLogger(EchoMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
