package com.dormbuddy.service;


import com.dormbuddy.entity.RoomPost;
import com.dormbuddy.repository.RoomPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomPostService {
    @Autowired
    private RoomPostRepository roomPostRepository;

    public RoomPost addRoomPost(RoomPost roomPost) {
        return roomPostRepository.save(roomPost);
    }

    public Optional<List<RoomPost>> getAllRoomPosts() {
        return roomPostRepository.findAllBy();
    }

    public RoomPost deleteRoomPost(Long id) {
        RoomPost toDelete = roomPostRepository.findById(id).get();
        roomPostRepository.delete(toDelete);
        return toDelete;
    }
}
