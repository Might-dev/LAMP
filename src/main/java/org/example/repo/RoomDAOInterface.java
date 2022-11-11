package org.example.repo;

import org.example.domain.Room;

import java.util.List;

public interface RoomDAOInterface {

    public void save(Room room);

    public List<Room> findAll();

    void update(Long id, Room updatedRoom);

    public Room findById(Long id);
}
