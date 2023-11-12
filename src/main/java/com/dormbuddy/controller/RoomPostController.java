package com.dormbuddy.controller;

import com.dormbuddy.entity.RoomPost;
import com.dormbuddy.service.RoomPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/roomPost")
public class RoomPostController {
    @Autowired
    private RoomPostService roomPostService;
    @CrossOrigin("http://localhost:3000")
    @PostMapping("add")
    public ResponseEntity<?> addRoomPost(
            @RequestBody RoomPost roomPost
            ) {
        RoomPost toRet = roomPostService.addRoomPost(roomPost);
        return ResponseEntity.ok(roomPostService.addRoomPost(toRet));
    }
    @CrossOrigin("http://localhost:3000")
    @GetMapping("getAll")
    public ResponseEntity<?> getAllRoomPosts() {
        return ResponseEntity.ok(roomPostService.getAllRoomPosts());
    }

    @CrossOrigin("http://localhost:3000")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteRoomPost(@PathVariable Long id) {
        return ResponseEntity.ok(roomPostService.deleteRoomPost(id));
    }

}
