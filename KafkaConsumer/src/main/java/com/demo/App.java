package com.demo;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.util.Properties;
import java.util.Collections;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.CommitFailedException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
	Properties props = new Properties();
	props.put("bootstrap.servers", "localhost:9092");
	props.put("group.id", "testGroup");
	props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

	KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
	
	consumer.subscribe(Collections.singletonList("testTopic3"));

	try {
		while (true) {
			ConsumerRecords<String, String> records =  consumer.poll(100);
			for (ConsumerRecord<String, String> record: records)
			{
				System.out.println(record.key() +", "+ record.value());
			}
			try {
				consumer.commitSync();
			} catch (CommitFailedException e) {
				System.err.println("commit failed " + e.toString());
			}
		}
	} finally {
		consumer.close();
	}
    }
}
