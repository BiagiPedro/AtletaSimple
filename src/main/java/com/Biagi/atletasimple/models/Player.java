package com.Biagi.atletasimple.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "table_player")
public class Player{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "player_name", nullable = false, length = 100)
    private String name;

    @Column(name = "position", nullable = false, length = 50)
    private String position;

    @Min(0)
    @Column(name = "age", nullable = false)
    private int age;

    @Min(0)
    @Column(name = "goals", nullable = false)
    private int goals;

    @Min(0)
    @Column(name = "matches_played", nullable = false)
    private int matchesPlayed;

    @Min(0)
    @Column(name = "assists", nullable = false)
    private int assists;

    @Min(0)
    @Column(name = "market_value", nullable = false)
    private float marketValue;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlayerMatchStatistic> statistics = new ArrayList<>();

    // Getters e Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public float getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(float marketValue) {
        this.marketValue = marketValue;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<PlayerMatchStatistic> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<PlayerMatchStatistic> statistics) {
        this.statistics = statistics;
    }
}