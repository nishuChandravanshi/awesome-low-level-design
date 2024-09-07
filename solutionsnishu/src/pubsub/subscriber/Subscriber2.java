package pubsub.subscriber;

import pubsub.publisher.Event;

public class Subscriber2 implements Subscriber {


    @Override
    public void update(Event event) {
        System.out.println("received update notification on Subscriber 2 for event " + event);
    }
}
