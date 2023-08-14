package com.sms.serviceimpl;
import java.util.ArrayList;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import com.sms.dto.PlayerDTO;
import com.sms.entity.Player;
import com.sms.repository.PlayerRepository;

import com.sms.service.PlayerService;
import com.sms.util.PlayerConverter;


@Service
public class PlayerServiceImpl  {
	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	PlayerConverter playerConverter;


	public List getAllPlayers() {
		List<Player> players=playerRepository.findAll();

		//list of DTO type
		List <PlayerDTO>DTOList=new ArrayList<>();
		for(Player p:players)
		{
			DTOList.add(playerConverter.convertToPlayerDTO(p));
		}
		return DTOList;
		}

	public PlayerDTO getPlayerById(int id) {
		Player player=playerRepository.findById(id).get();
		return playerConverter.convertToPlayerDTO(player);
	}

	public PlayerDTO updatePlayer(int id, Player player) {
		Player p=playerRepository.findById(id).get();
		p.setPlayername(player.getPlayername());
		p.setPlayerteam(player.getPlayerteam());
		
		Player play=playerRepository.save(p);
		return playerConverter.convertToPlayerDTO(play);
	}

	public String deletePlayer(int id) {
		playerRepository.deleteById(id);

		return "Player details got deleted successfuly";
	}
	public PlayerDTO addPlayer(PlayerDTO playerDTO) {
		Player p=playerRepository.save(playerDTO);
		return playerConverter.convertToPlayerDTO(p);
	
	}
	public java.util.List<PlayerDTO> getAllPlayer() {
		List<Player> players=playerRepository.findAll();

		//list of DTO type
		List <PlayerDTO>DTOList=new ArrayList<>();
		for(Player p:players)
		{
			DTOList.add(playerConverter.convertToPlayerDTO(p));
		}
		return DTOList;
		}	
		
	
	
		
	




}



