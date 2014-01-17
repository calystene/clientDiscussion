Exercice 2

Question 1 :
Pour émettre un paquet UDP en multicast, la méthode n'est pas différente de celle pour envoyer un message à un autre poste. Ce qui change c'est uniquement le type de socket(MulticastSocket) et l'adresse 
d'envoie,une adresse IP de groupe est nécessaire.

En revanche pour la réception d'un paquet en multicast, il est nécessaire de rejoindre le groupe de l'adresse ip multicast, avec un socket MulticastSocket.

Ce qui change principalement pour la réception et l'émission de paquet en multicast, ce sont les données réseaux que l'on va fournir au logiciel.

Question 2 :
La première exception à gérer est celle de la création du socket... Elle peut être levée si un port non valide lui est fourni par exemple.
La dexième exception à gérer est celle de la création du paquet... Elle peut être levée si un mauvais destinataire, ou un mauvais port lui est fourni.




Exercice 3

Question 1 :
Il faut 2 processus : un qui écoute le réseau, l'autre qui se tient prêt à l'envoie d'un message. On fait donc hériter nos classes ReceiveUDP et SendUDP avec la classe
Thread (par abus de langage on parle de processus, mais il faut savoir qu'en Java Thread n'est pas réellement un processus).

Question 2 :
