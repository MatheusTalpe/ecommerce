package br.com.kafka.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;

import static org.apache.kafka.clients.consumer.ConsumerConfig.MAX_POLL_RECORDS_CONFIG;

public class Propriedades {

    Properties propriedades = new Properties();

    public Propriedades(String endereco, String tipo, String key, String value, String groupID){

        switch (tipo) {
            case "PRODUCER":
                propriedades.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, endereco);
                propriedades.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, key);
                propriedades.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, value);
                break;
            case "CONSUMER":
                propriedades.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, endereco);
                propriedades.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getSimpleName());
                propriedades.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getSimpleName());
                propriedades.setProperty(ConsumerConfig.GROUP_ID_CONFIG, Propriedades.class.getSimpleName());
                propriedades.setProperty(MAX_POLL_RECORDS_CONFIG, "1");
                break;
            default:
                throw new IllegalArgumentException("Tipo Invalido");
        }
    }

    public Propriedades(String endereco, String tipo, String key, String value){
        this(endereco, tipo, key, value, key);
    }

    public Properties getPropriedades() {
        return propriedades;
    }
}
