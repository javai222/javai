package com.mance.app.service;

import com.mance.app.entity.Player;
import com.mance.app.exception.ResourceNotFoundException;
import com.mance.app.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    /**
     * C - Create
     * R - Read
     * U - Update
     * D - Delete
     */
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long Id) {
        return playerRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Player with id: " + Id + " not found"));
    }

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long id, Player player) {
        Player existing = getPlayerById(id);

        existing.setName(player.getName());
        existing.setEmail(player.getEmail());
        existing.setPhoneNumber(player.getPhoneNumber());
        existing.setIsAcePlayer(player.getIsAcePlayer());
        existing.setRank(player.getRank());
        return playerRepository.save(existing);
    }

    public void deletePlayer(Long id) {
        getPlayerById(id);
        playerRepository.deleteById(id);
    }
}
