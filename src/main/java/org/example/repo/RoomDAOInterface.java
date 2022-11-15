package org.example.repo;

import org.example.domain.Room;

import java.util.List;

public interface RoomDAOInterface {
    List<Room> findAll();

    void save(Room room);

    void update(Long id, Room updatedRoom);

    Room findById(Long id);
}
