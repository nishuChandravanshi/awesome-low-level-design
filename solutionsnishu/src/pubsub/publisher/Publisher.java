package pubsub.publisher;

import pubsub.subscriber.Subscriber;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Publisher {

//    private final List<Subscriber> subscriberList;

    private final Map<Event, Set<Subscriber>> eventSubscripersMap;

    private Publisher() {
//        this.subscriberList = new ArrayList<>();
        this.eventSubscripersMap = new ConcurrentHashMap<>();
    }

    // Bill Pugh Singleton design pattern, //ide automatically suggested this on writing getInstance method for singleton lazy pattern
    private static final class PublisherInstanceHolder {
        private static final Publisher publisherInstance = new Publisher(); //Java language specification guarantees static initialization is thread safe
    }

    public static synchronized Publisher getPublisherInstance() {
        return PublisherInstanceHolder.publisherInstance;
    }


    public void publishEvent(Event event) {
        if (!eventSubscripersMap.containsKey(event)) {
            System.out.println("No subscriber for this event " + event.getName());
            return;
        }

        for (Subscriber subscriber : this.eventSubscripersMap.get(event)) {
            subscriber.update(event);
        }


//        synchronized (this) {
//            for (Subscriber subscriber : this.subscriberList) {
//                subscriber.update();
//            }
//        }
    }

    public synchronized void subscribe(Event event, Subscriber subscriber) {
//        subscriberList.add(subscriber);
        if (eventSubscripersMap.containsKey(event)) {
            eventSubscripersMap.get(event).add(subscriber);
        } else {
            Set<Subscriber> set = new HashSet<>();
            set.add(subscriber);
            eventSubscripersMap.put(event, set);
        }

    }

    public synchronized void unsubscribe(Event event, Subscriber subscriber) {
//        subscriberList.remove(subscriber);
        if (eventSubscripersMap.containsKey(event)) {
            eventSubscripersMap.get(event).remove(subscriber);
        }
        System.out.println("Unsubscribed | subscriber " + subscriber + " from Event " + event);
    }
}