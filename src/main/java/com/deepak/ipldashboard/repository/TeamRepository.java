package com.deepak.ipldashboard.repository;

import com.deepak.ipldashboard.Model.Team;

import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team,Long> {
  
  Team findByTeamName(String teamName);
  
}
