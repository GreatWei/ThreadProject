package com.seven.akka;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class HelloWorld extends UntypedActor {

	ActorRef greeter;

	@Override
	public void preStart() throws Exception {
		// TODO Auto-generated method stub
		greeter = getContext().actorOf(Props.create(Greeter.class), "greeter");
		System.out.println("Greeter Actor Path:" + greeter.path());
		super.preStart();
	}

	@Override
	public void onReceive(Object message) throws Throwable {
		// TODO Auto-generated method stub
		if (message == Greeter.Msg.DONE) {
			greeter.tell(Greeter.Msg.GREET, getSelf());
			getContext().stop(getSelf());
		} else {
			unhandled(message);
		}
	}

}
