package com.dolormente.app.controller;

import com.dolormente.app.entity.Robot;
import com.dolormente.app.service.RobotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/robots")
public class RobotController {

    private final RobotService robotService;

    public RobotController(RobotService robotService) {
        this.robotService = robotService;
    }

    // READ ALL
    @GetMapping
    public List<Robot> getAll() {
        return robotService.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Robot getById(@PathVariable Long id) {
        return robotService.getById(id);
    }

    // CREATE
    @PostMapping
    public Robot create(@RequestBody Robot robot) {
        return robotService.create(robot);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Robot update(@PathVariable Long id, @RequestBody Robot robot) {
        return robotService.update(id, robot);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        robotService.delete(id);
    }
}