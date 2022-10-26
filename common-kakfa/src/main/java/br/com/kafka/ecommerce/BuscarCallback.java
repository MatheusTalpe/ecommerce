package br.com.kafka.ecommerce;

import org.apache.kafka.clients.producer.Callback;

public class BuscarCallback  {

    static Callback getCallback() {
        return (data, exception) -> {
            if (exception != null) {
                exception.printStackTrace();
                return;
            }
            System.out.println("enviado= " + data.topic() + ":::partition " + data.partition() + "/ offset " + data.offset() + "/ timestamp " + data.timestamp());
        };
    }
}
