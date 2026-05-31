package com.dolormente.app.service;

import com.dolormente.app.entity.Robot;
import com.dolormente.app.repository.RobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RobotService {

    @Autowired
    private RobotRepository robotRepository;

    public List<Robot> getAll() {
        return robotRepository.findAll();
    }

    public Robot getById(Long id) {
        return robotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Robot not found"));
    }

    public Robot create(Robot robot) {
        return robotRepository.save(robot);
    }

    public Robot update(Long id, Robot updated) {
        Robot robot = getById(id);
        robot.setName(updated.getName());
        robot.setEmail(updated.getEmail());
        robot.setPhoneNumber(updated.getPhoneNumber());
        robot.setRegular(updated.isRegular());
        robot.setAdvancedRobot(updated.isAdvancedRobot());
        robot.setRank(updated.getRank());
        return robotRepository.save(robot);
    }

    public void delete(Long id) {
        robotRepository.deleteById(id);
    }
}
