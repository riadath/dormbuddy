package com.dormbuddy.repository;

import com.dormbuddy.entity.RoomPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoomPostRepository extends JpaRepository<RoomPost, Long> {
    Optional<List<RoomPost>> findAllBy();

}
