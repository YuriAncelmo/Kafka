import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Configuration
@EnableScheduling
public class Producer {
    private final KafkaTemplate<String,String> kafkaTemplate;

    public Producer(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
    // TODO: Não está executando automáticamente a produção de mensagem
    //Utilizando fixed delay, espera a ultima execução para executar o método novamente
    // Fixed rate as execuções são independentes
    @Scheduled(fixedRate = 2000)
    public void send(){
        final String variable = UUID.randomUUID().toString();
        //Não colocar o nome do topic com caracter especial
        this.kafkaTemplate.send("TesteTopic2",variable, "Mensagem totalmente aleatoria ");
    }
}
