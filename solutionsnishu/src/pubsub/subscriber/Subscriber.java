package pubsub.subscriber;

import pubsub.publisher.Event;

public interface Subscriber {

    void update(Event event);

}
