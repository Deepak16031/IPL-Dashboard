package com.deepak.ipldashboard.controller;

import com.deepak.ipldashboard.Model.Team;
import com.deepak.ipldashboard.repository.MatchRepository;
import com.deepak.ipldashboard.repository.TeamRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

  private TeamRepository teamRepository;

  private MatchRepository matchRepository;
  
  public TeamController(TeamRepository teamRepository, MatchRepository matchRepository){
    this.teamRepository = teamRepository ;
    this.matchRepository= matchRepository;
  }

  @GetMapping("/team/{teamName}")
  public Team  getTeam(@PathVariable String teamName){
    Team team = this.teamRepository.findByTeamName(teamName);
    team.setMatches(this.matchRepository.findLatestMatchByTeam(teamName, 4));
    return team;
  }
  @Postmapping("/team/{teamName}/{id}")
  public Team postTema()
}
