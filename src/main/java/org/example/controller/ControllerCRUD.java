package org.example.controller;

import org.example.domain.Room;
import org.example.repo.RoomRepos;
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
public class ControllerCRUD {
//    private RoomRepos roomRepos;
//
//    public ControllerCRUD(RoomRepos roomRepos) {
//        this.roomRepos = roomRepos;
//
//    }
//
//    @GetMapping("/main")
//    public String showRooms(Model model){
//        Iterable<Room> rooms = roomRepos.findAll();
//        model.addAttribute("rooms", rooms);
//        return "main";
//    }
//
//    @PostMapping("/main")
//    public String addRoom(@RequestParam String name,
//                          @RequestParam String country,
//                          @RequestParam(required = false) boolean onOff,
//                          Model model){
//
//        Room room = new Room(name, country, onOff);
//        roomRepos.save(room);
//        Iterable<Room> rooms = roomRepos.findAll();
//        model.addAttribute("rooms", rooms);
//        return "main";
//    }
//
//    @GetMapping("/main/{id}")
//    public String getEdit(@PathVariable(value = "id") Long id,
//                          Model model){
//        Optional<Room> optionalRoomId = roomRepos.findById(id);
//        List<Room> roomList = new ArrayList<>();
//        optionalRoomId.ifPresent(roomList :: add);
//        model.addAttribute("rooms", roomList);
//        return "edit";
//    }
//
//    @PostMapping("/main/{id}")
//    public String editRoom(@PathVariable(value = "id") Long id,
//                           @RequestParam(required = false) boolean onOff,
//                           Model model){
//        Room room = roomRepos.findById(id).orElseThrow();
//        room.setOnOff(onOff);
//        model.addAttribute("onnOff", onOff);
//        roomRepos.save(room);
//        model.addAttribute("rooms", room);
//        return "edit";
//    }
//
//    @PostMapping("/main/{id}/delete")
//    public String delete(@PathVariable(value = "id") Long id,
//                         Model model){
//        Room room = roomRepos.findById(id).orElseThrow();
//        roomRepos.delete(room);
//        return "redirect:/main";
//    }

}
