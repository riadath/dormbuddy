package com.dormbuddy.controller;

import com.dormbuddy.entity.RoomPost;
import com.dormbuddy.entity.SearchEntity;
import com.dormbuddy.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class SearchController {

    @Autowired
    private SearchService searchService;
    @GetMapping("api/v1/search")
    public ResponseEntity<List<RoomPost>> search(
            @RequestBody SearchEntity searchEntity
            ) {
        System.out.println(searchEntity);
        return ResponseEntity.ok(searchService.search(searchEntity));
    }
}
