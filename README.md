Message Manager CORBA JSM
===================

##About
Implementing a management system using CORBA and JMS Message-Oriented Middleware (MOM). This system has the function of
manage message queues on a MOM server. The system have a client and server communication. This client send message by way of
CORBA, and server using CORBA and JMS. 

Client CORBA <-> [Server CORBA <-> Server JMS]


##Running
Initially is necessary run service name and openjms

To run service name
```
% tnameserv
```

To run openjms enter in diretory "3 Files - openjms\openjms-0.7.7-beta-1\bin" and run script startup
```
% startup
```

After run servece name and openjms start server communication
```
% java -jar server-corbajms.jar
```

The server communication communication no have graphic interface, all events are shown on the terminal
<p align="center"> <img src="2 Files - imagens/window-server.png"/> </p>

Now run client communication
```
% java -jar client-corbajms.jar
```

First user enter your name
<p align="center"> <img src="2 Files - imagens/window-client-2.png"/> </p>

Second input ip server
<p align="center"> <img src="2 Files - imagens/window-client-3.png"/> </p>

The refresh button update list user names logged in server. If user send message for other user and this no more logged
in server, when this user enter again in server, he receiver messages. For send message for other user is necessary 
selected a user.
<p align="center"> <img src="2 Files - imagens/window-client-5.png"/> </p>

##Download
You can download it in the .jar format:  
[client](https://raw.github.com/marcuspimenta/Message-Manager-CORBA-JSM/master/1 Files - builds/client-corbajms.jar) and
[server](https://raw.github.com/marcuspimenta/Message-Manager-CORBA-JSM/master/1 Files - builds/server-corbajms.jar)

##Author
Marcus Vinicius Pimenta  
email: [mvinicius.pimenta@gmail.com](mailto:mvinicius.pimenta@gmail.com)
