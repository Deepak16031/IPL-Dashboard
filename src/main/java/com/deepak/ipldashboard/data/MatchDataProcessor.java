package com.deepak.ipldashboard.data;

import java.time.LocalDate;

import com.deepak.ipldashboard.Model.Match;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;


public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

  private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

  @Override
  public Match process(final MatchInput matchInput) throws Exception {
    Match match = new Match();
    match.setId(Long.parseLong(matchInput.getId()));
    match.setCity(matchInput.getCity());
    match.setDate(LocalDate.parse(matchInput.getDate()));

    String firstInningsTeam;
    String secondInningsTeam;

    if(matchInput.getToss_winner().equals(matchInput.getTeam1())){
        if(matchInput.getToss_decision().equals("bat")){
            firstInningsTeam=matchInput.getTeam1();
            secondInningsTeam= matchInput.getTeam2();
        }
        else{
            firstInningsTeam=matchInput.getTeam2();
            secondInningsTeam=matchInput.getTeam1();
        }
    }
    else{
        if(matchInput.getToss_decision().equals("bat")){
            firstInningsTeam=matchInput.getTeam2();
            secondInningsTeam=matchInput.getTeam1();
        }
        else{
            firstInningsTeam=matchInput.getTeam1();
            secondInningsTeam= matchInput.getTeam2();
        }
    }
    match.setTeam1(firstInningsTeam);
    match.setTeam2(secondInningsTeam);
    match.setTossWinner(matchInput.getToss_winner());
    match.setTossDecision(matchInput.getToss_decision());
    match.setResult(matchInput.getResult());
    match.setMatchWinner(matchInput.getWinner());
    match.setResultMargin(matchInput.getResult_margin());
    match.setUmpire1(matchInput.getUmpire1());
    match.setUmpire2(matchInput.getUmpire2());
    return match;
  }

}