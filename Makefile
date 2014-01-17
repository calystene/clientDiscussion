compile:
	javac -classpath src/ src/exercice1/ReceiveUDP.java
	javac -classpath src/ src/exercice1/SendUDP.java

exec_listener:
	java -classpath bin/ exercice1.ReceiveUDP 1500

exec_sender: 
	java -classpath bin/ exercice1.SendUDP a10p1 1500 "you are welcome" 