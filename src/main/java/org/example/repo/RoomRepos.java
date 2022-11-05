package org.example.repo;

import org.example.domain.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepos extends CrudRepository<Room, Long> {

}
