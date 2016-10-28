from kafka import KafkaProducer

producer = KafkaProducer(bootstrap_servers='localhost:9092')

f = open('archivo.txt', 'r')

producer.send('prueba1',  str(f.read()))

# sudo apt-get install python-pip
# sudo pip install kafka-python



