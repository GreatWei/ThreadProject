package com.seven.akka;

import akka.actor.UntypedActor;

public class Greeter extends UntypedActor {

	@Override
	public void onReceive(Object message) throws Throwable {
		// TODO Auto-generated method stub
		if (message == Msg.GREET) {
			System.out.println("HELLO WORLD");
			///getSender().tell(Msg.DONE, getSelf());
			getSender().tell(Msg.DONE, getSelf());
			
		} else {
			unhandled(message);
		}
	}

	public static enum Msg {
		GREET, DONE;
	}

}
