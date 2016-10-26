from kafka import KafkaProducer
producer = KafkaProducer(bootstrap_servers='localhost:9093')
for _ in range(10):
	producer.send('testTopic3', b'some_message_bytes')

