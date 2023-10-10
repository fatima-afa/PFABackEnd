package adria.intership.subscribers.repositories;

import adria.intership.subscribers.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {
}
