package com.Biagi.atletasimple.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "table_player_match_statistic")
public class PlayerMatchStatistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;


    @Column(name = "goals_scored", nullable = false)
    @Min(0)
    private int goalsScored;

    @Column(name = "assists", nullable = false)
    @Min(0)
    private int assists;

    @Column(name = "yellow_cards", nullable = false)
    @Min(0)
    private int yellowCards;

    @Column(name = "red_cards", nullable = false)
    @Min(0)
    private int redCards;

    @Column(name = "shots_on_target", nullable = false)
    @Min(0)
    private int shotsOnTarget;

    @Column(name = "shots_off_target", nullable = false)
    @Min(0)
    private int shotsOffTarget;

    @Column(name = "passes_completed", nullable = false)
    @Min(0)
    private int passesCompleted;

    @Column(name = "passes_attempted", nullable = false)
    @Min(0)
    private int passesAttempted;

    @Column(name = "fouls_committed", nullable = false)
    @Min(0)
    private int foulsCommitted;

    @Column(name = "fouls_suffered", nullable = false)
    @Min(0)
    private int foulsSuffered;

    @Column(name = "rating")
    @DecimalMin("0.0")
    @DecimalMax("10.0")
    private Double rating;

    //


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }

    public int getShotsOnTarget() {
        return shotsOnTarget;
    }

    public void setShotsOnTarget(int shotsOnTarget) {
        this.shotsOnTarget = shotsOnTarget;
    }

    public int getShotsOffTarget() {
        return shotsOffTarget;
    }

    public void setShotsOffTarget(int shotsOffTarget) {
        this.shotsOffTarget = shotsOffTarget;
    }

    public int getPassesCompleted() {
        return passesCompleted;
    }

    public void setPassesCompleted(int passesCompleted) {
        this.passesCompleted = passesCompleted;
    }

    public int getPassesAttempted() {
        return passesAttempted;
    }

    public void setPassesAttempted(int passesAttempted) {
        this.passesAttempted = passesAttempted;
    }

    public int getFoulsCommitted() {
        return foulsCommitted;
    }

    public void setFoulsCommitted(int foulsCommitted) {
        this.foulsCommitted = foulsCommitted;
    }

    public int getFoulsSuffered() {
        return foulsSuffered;
    }

    public void setFoulsSuffered(int foulsSuffered) {
        this.foulsSuffered = foulsSuffered;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}