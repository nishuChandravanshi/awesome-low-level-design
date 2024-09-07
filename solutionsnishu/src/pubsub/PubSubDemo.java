package pubsub;

import pubsub.publisher.Event;
import pubsub.publisher.Publisher;
import pubsub.subscriber.Subscriber;
import pubsub.subscriber.Subscriber1;
import pubsub.subscriber.Subscriber2;

public class PubSubDemo {
    /*
    Publisher
        -> listOfSubscribers[]
        -> onEvent() -> when event is triggered notify subscriber
        -> subscribe();
        -> unsubscribe();

    Subscriber
        -> status
        -> notify() -> on receiving notification subscriber updates its status
     */

    public static void main(String[] args) {
        Publisher publisher = Publisher.getPublisherInstance();
        Event event1 = new Event("Event1", "Hello From Event1");
        Event event2 = new Event("Event2", "Hello From Event2");
        Subscriber subscriber1 = new Subscriber1();
        Subscriber subscriber2 = new Subscriber2();

        publisher.subscribe(event1, subscriber1);
        publisher.subscribe(event2, subscriber1);

        publisher.subscribe(event2, subscriber2);

        publisher.publishEvent(event1);
        publisher.publishEvent(event2);

    }
}
