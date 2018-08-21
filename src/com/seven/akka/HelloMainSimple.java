package com.seven.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class HelloMainSimple {

	public static void main(String[] args) {
		ActorSystem system = ActorSystem.create("Hello");
		ActorRef a = system.actorOf(Props.create(HelloWorld.class), "helloWorld");
		System.out.println("Hello World Actor Path:" + a.path());
		// akka.Main.main(new String[] { HelloWorld.class.getName() });
	}

}
