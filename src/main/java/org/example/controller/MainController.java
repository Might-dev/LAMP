package org.example.controller;

import org.example.domain.Room;
import org.example.repo.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

    /*private RoomRepos roomRepos;

    public MainController(RoomRepos roomRepos) {
        this.roomRepos = roomRepos;

    }

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
    public String getEdit(@PathVariable(value = "id") Long id,
                       Model model){
        Optional<Room> optionalRoomId = roomRepos.findById(id);
        List<Room> roomList = new ArrayList<>();
        optionalRoomId.ifPresent(roomList :: add);
        model.addAttribute("rooms", roomList);
        return "edit";
    }

    @PostMapping("/main/{id}")
    public String editRoom(@PathVariable(value = "id") Long id,
                           @RequestParam(required = false) boolean onOff,
                           Model model){
        Room room = roomRepos.findById(id).orElseThrow();
        room.setOnOff(onOff);
        model.addAttribute("onnOff", onOff);
        roomRepos.save(room);
        model.addAttribute("rooms", room);
        return "edit";
    }

    @PostMapping("/main/{id}/delete")
    public String delete(@PathVariable(value = "id") Long id,
                         Model model){
        Room room = roomRepos.findById(id).orElseThrow();
        roomRepos.delete(room);
        return "redirect:/main";
    }*/


    private final RoomDAO roomDAO;

    @Autowired
    public MainController(RoomDAO roomDAO) {
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
        model.addAttribute("onnOff", onOff);
        roomDAO.save(room);
        model.addAttribute("rooms", room);
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Room room,
                         @PathVariable("id") int id) {

//        roomDAO.update(id, room);
        return "redirect:/main";
    }

    @DeleteMapping("/main/{id}")
    public String delete(@PathVariable(value = "id") Long id,
                         Model model) {
        roomDAO.delete(id);
        return "redirect:/main";
    }
}
