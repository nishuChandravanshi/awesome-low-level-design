package pubsub.subscriber;

import pubsub.publisher.Event;

public class Subscriber1 implements Subscriber {

    @Override
    public void update(Event event) {
        System.out.println("received update notification on Subscriber 1 for event " + event);
    }
}
