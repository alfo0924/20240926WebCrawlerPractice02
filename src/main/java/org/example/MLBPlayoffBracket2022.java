package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class MLBPlayoffBracket2022 {
    public static void main(String[] args) {
        String url = "https://www.mlb.com/standings/2022?tableType=regularSeasonStandard";
        try {
            List<Team> teams = crawlMLBStandings(url);
            printPlayoffBracket(teams);
        } catch (IOException e) {
            System.out.println("Error crawling MLB standings: " + e.getMessage());
        }
    }

    private static List<Team> crawlMLBStandings(String url) throws IOException {
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
                .get();
        List<Team> teams = new ArrayList<>();

        Elements rows = doc.select("table tbody tr");
        for (Element row : rows) {
            String teamName = row.select("th[data-col='0']").text().replaceAll("[yx]$", "").trim();
            String teamAbbr = row.select("th[data-col='0'] span.standings-table__team-name--abbrev").text();
            String winsText = row.select("td[data-col='1']").text();
            int wins = parseIntSafely(winsText);
            if (!teamName.isEmpty() && !teamAbbr.isEmpty()) {
                teams.add(new Team(teamName, teamAbbr, wins));
            }
        }

        return teams;
    }

    private static int parseIntSafely(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static void printPlayoffBracket(List<Team> teams) {
        Map<String, Team> teamMap = new HashMap<>();
        for (Team team : teams) {
            teamMap.put(team.abbr, team);
        }

        System.out.println("(AMERICAN LEAGUE)");
        printBracketPart(teamMap,
                new String[]{"SEA", "HOU", "CLE", "TB", "NYY"},
                new String[]{"HOU", "HOU", "CLE", "NYY", "HOU", "HOU"});
        System.out.println("                               ---- HOU");
        printBracketPart(teamMap,
                new String[]{"SD", "LAD", "PHI", "ATL", "STL"},
                new String[]{"SD", "PHI", "PHI", "PHI", "PHI", "PHI"});
        System.out.println("(NATIONAL LEAGUE)");
    }

    private static void printBracketPart(Map<String, Team> teamMap, String[] teamOrder, String[] winners) {
        System.out.printf("%-3s %3d -----\n", teamOrder[0], teamMap.get(teamOrder[0]).wins);
        System.out.printf("%-3s %3d ----- %-3s -----\n", teamOrder[1], teamMap.get(teamOrder[1]).wins, winners[0]);
        System.out.printf("        %-3s %3d ----- %-3s\n", teamOrder[2], teamMap.get(teamOrder[2]).wins, winners[1]);
        System.out.printf("%-3s %3d -----\n", teamOrder[2], teamMap.get(teamOrder[2]).wins);
        System.out.printf("%-3s %3d ----- %-3s -----\n", teamOrder[3], teamMap.get(teamOrder[3]).wins, winners[2]);
        System.out.printf("        %-3s %3d ----- %-3s ----- %-3s\n", teamOrder[4], teamMap.get(teamOrder[4]).wins, winners[3], winners[4]);
        System.out.printf("                               ---- %-3s\n", winners[5]);
    }

    private static class Team {
        String name;
        String abbr;
        int wins;

        Team(String name, String abbr, int wins) {
            this.name = name;
            this.abbr = abbr;
            this.wins = wins;
        }
    }
}