package org.example.controllers;

import org.example.domain.Room;
import org.example.repos.RoomRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class MainController {
    @Autowired
    private RoomRepos roomRepos;

    @GetMapping("/main")
    public String showRooms(Model model){
        Iterable<Room> rooms = roomRepos.findAll();
        model.addAttribute("rooms", rooms);
        return "main";
    }

    @PostMapping("/main")
    public String addRoom(@RequestParam String name,
                          @RequestParam String country,
                          @RequestParam(required = false) boolean onOff,
                          Model model){

        Room room = new Room(name, country, onOff);
        roomRepos.save(room);
        Iterable<Room> rooms = roomRepos.findAll();
        model.addAttribute("rooms", rooms);
        return "main";
    }

    @GetMapping("/main/{id}")
    public String edit(@PathVariable(value = "id") Long id,
                       Model model){

        Optional<Room> optionalRoomId = roomRepos.findById(id);
        List<Room> roomList = new ArrayList<>();
        optionalRoomId.ifPresent(roomList :: add);
        model.addAttribute("rooms", roomList);
        return "edit";
    }

    @PostMapping("/main/{id}")
    public String editPost(@PathVariable(value = "id") Long id,
                           @RequestParam String name,
                           @RequestParam(required = false) boolean onOff,
                           Model model){
        Room room = roomRepos.findById(id).orElseThrow();

        System.out.printf(String.valueOf(onOff));
        System.out.println(room.getOnOff());

        room.setName(name);
        room.setOnOff(onOff);
        model.addAttribute("onnOff", onOff);
        roomRepos.save(room);
        return "redirect:/main";
    }

    @PostMapping("/main/{id}/delete")
    public String delete(@PathVariable(value = "id") Long id,
                         Model model){

        Room room = roomRepos.findById(id).orElseThrow();
        roomRepos.delete(room);
        return "redirect:/main";
    }
}
