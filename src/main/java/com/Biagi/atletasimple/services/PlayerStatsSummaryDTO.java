package com.Biagi.atletasimple.services;

public class PlayerStatsSummaryDTO {
    private Long playerId;
    private String playerName;
    private String teamName;
    private int totalGoals;
    private int totalAssists;
    private int totalYellowCards;
    private int totalRedCards;
    private int totalShotsOnTarget;
    private int totalShotsOffTarget;
    private int totalPassesCompleted;
    private int totalPassesAttempted;
    private int totalFoulsCommitted;
    private int totalFoulsSuffered;

    // Getters e Setters
    public Long getPlayerId() { return playerId; }
    public void setPlayerId(Long playerId) { this.playerId = playerId; }
    public String getPlayerName() { return playerName; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }
    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }
    public int getTotalGoals() { return totalGoals; }
    public void setTotalGoals(int totalGoals) { this.totalGoals = totalGoals; }
    public int getTotalAssists() { return totalAssists; }
    public void setTotalAssists(int totalAssists) { this.totalAssists = totalAssists; }
    public int getTotalYellowCards() { return totalYellowCards; }
    public void setTotalYellowCards(int totalYellowCards) { this.totalYellowCards = totalYellowCards; }
    public int getTotalRedCards() { return totalRedCards; }
    public void setTotalRedCards(int totalRedCards) { this.totalRedCards = totalRedCards; }
    public int getTotalShotsOnTarget() { return totalShotsOnTarget; }
    public void setTotalShotsOnTarget(int totalShotsOnTarget) { this.totalShotsOnTarget = totalShotsOnTarget; }
    public int getTotalShotsOffTarget() { return totalShotsOffTarget; }
    public void setTotalShotsOffTarget(int totalShotsOffTarget) { this.totalShotsOffTarget = totalShotsOffTarget; }
    public int getTotalPassesCompleted() { return totalPassesCompleted; }
    public void setTotalPassesCompleted(int totalPassesCompleted) { this.totalPassesCompleted = totalPassesCompleted; }
    public int getTotalPassesAttempted() { return totalPassesAttempted; }
    public void setTotalPassesAttempted(int totalPassesAttempted) { this.totalPassesAttempted = totalPassesAttempted; }
    public int getTotalFoulsCommitted() { return totalFoulsCommitted; }
    public void setTotalFoulsCommitted(int totalFoulsCommitted) { this.totalFoulsCommitted = totalFoulsCommitted; }
    public int getTotalFoulsSuffered() { return totalFoulsSuffered; }
    public void setTotalFoulsSuffered(int totalFoulsSuffered) { this.totalFoulsSuffered = totalFoulsSuffered; }
} 