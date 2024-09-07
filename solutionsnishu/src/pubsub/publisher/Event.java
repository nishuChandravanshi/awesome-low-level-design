package pubsub.publisher;


import java.util.Objects;

public class Event {
    private String name;
    private String message;

    public Event(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(name, event.name) && Objects.equals(message, event.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, message);
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
