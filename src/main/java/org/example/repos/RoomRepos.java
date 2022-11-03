package org.example.repos;

import org.example.domain.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepos extends CrudRepository<Room, Long> {

    Iterable<Room> findByName(String name);
}
