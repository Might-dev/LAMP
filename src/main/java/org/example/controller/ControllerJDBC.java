package org.example.controller;

import org.example.domain.Room;
import org.example.repo.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ControllerJDBC {
    private final RoomDAO roomDAO;

    @Autowired
    public ControllerJDBC(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    @GetMapping("/main")
    public String showRooms(Model model) {
        model.addAttribute("rooms", roomDAO.findAll());
        return "main";
    }

    @PostMapping("/main")
    public String addRoom(@RequestParam String name,
                          @RequestParam String country,
                          @RequestParam(required = false) boolean onOff,
                          Model model) {
        Room room = new Room(name, country, onOff);
        roomDAO.save(room);
        model.addAttribute("rooms", roomDAO.findAll());
        return "main";
    }

    @GetMapping("/main/{id}")
    public String getEdit(@PathVariable(value = "id") Long id,
                          Model model) {
        model.addAttribute("rooms", roomDAO.findById(id));
        return "edit";
    }

    @PostMapping("/main/{id}")
    public String editRoom(@PathVariable(value = "id") Long id,
                           @RequestParam(required = false) boolean onOff,
                           Model model) {
        Room room = roomDAO.findById(id);
        room.setOnOff(onOff);
        roomDAO.update(id, room);
        model.addAttribute("onnOff", onOff);
        model.addAttribute("rooms", room);
        return "edit";
    }

    @PostMapping("/main/{id}/delete")
    public String deleteRoom(@PathVariable(value = "id") Long id,
                             Model model) {
        roomDAO.delete(id);
        return "redirect:/main";
    }

    @GetMapping("/main/allRoomsJson")
    @ResponseBody
    public List<Room> getAllRoomsJson() {
        return roomDAO.findAll();
    }

}
