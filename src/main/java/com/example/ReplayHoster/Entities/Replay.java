package com.example.ReplayHoster.Entities;

import java.util.Arrays;
import java.util.Objects;

public class Replay {

    private String name;
    private String[] factions;
    private String[] players;
    private boolean competitive;
    private String description;

    public Replay(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getFactions() {
        return factions;
    }

    public void setFactions(String[] factions) {
        this.factions = factions;
    }

    public String[] getPlayers() {
        return players;
    }

    public void setPlayers(String[] players) {
        this.players = players;
    }

    public boolean isCompetitive() {
        return competitive;
    }

    public void setCompetitive(boolean competitive) {
        this.competitive = competitive;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Replay{" +
                "name='" + name + '\'' +
                ", factions=" + Arrays.toString(factions) +
                ", players=" + Arrays.toString(players) +
                ", competitive=" + competitive +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Replay replay = (Replay) o;
        return competitive == replay.competitive &&
                name.equals(replay.name) &&
                Arrays.equals(factions, replay.factions) &&
                Arrays.equals(players, replay.players) &&
                Objects.equals(description, replay.description);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, competitive, description);
        result = 31 * result + Arrays.hashCode(factions);
        result = 31 * result + Arrays.hashCode(players);
        return result;
    }
}
