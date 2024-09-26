package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class MLBPlayoffs2022Crawler {
    public static void main(String[] args) {
        try {
            Map<String, Integer> teamWins = crawlMLBStandings();
            printPlayoffBracket(teamWins);
        } catch (IOException e) {
            System.out.println("Error crawling MLB standings: " + e.getMessage());
        }
    }

    private static Map<String, Integer> crawlMLBStandings() throws IOException {
        String url = "https://www.mlb.com/standings/2022?tableType=regularSeasonStandard";
        Document doc = Jsoup.connect(url).get();
        Map<String, Integer> teamWins = new HashMap<>();

        Elements tables = doc.select("table.standings-table");
        for (Element table : tables) {
            Elements rows = table.select("tbody tr");
            for (Element row : rows) {
                String teamName = row.select("td.standings-table__team-name").text();
                String teamAbbr = row.select("td.standings-table__team-name span.standings-table__team-name--abbrev").text();
                int wins = Integer.parseInt(row.select("td.standings-table__wins").text());
                teamWins.put(teamAbbr, wins);
            }
        }

        return teamWins;
    }

    private static void printPlayoffBracket(Map<String, Integer> teamWins) {
        String[] alTeams = {"NYY", "HOU", "CLE", "SEA", "TB"};
        String[] nlTeams = {"LAD", "ATL", "STL", "NYM", "PHI", "SD"};

        System.out.println("(AMERICAN LEAGUE)");
        printDivision(alTeams, teamWins);
        System.out.println("                               ---- Winner");
        printDivision(nlTeams, teamWins);
        System.out.println("(NATIONAL LEAGUE)");
    }

    private static void printDivision(String[] teams, Map<String, Integer> teamWins) {
        System.out.printf("%s %d -----\n", teams[3], teamWins.get(teams[3]));
        System.out.printf("%s %d ----- %s -----\n", teams[1], teamWins.get(teams[1]), teams[1]);
        System.out.printf("        %s %d ----- %s\n", teams[2], teamWins.get(teams[2]), teams[1]);
        System.out.printf("%s %d -----\n", teams[2], teamWins.get(teams[2]));
        System.out.printf("%s %d ----- %s -----\n", teams[4], teamWins.get(teams[4]), teams[2]);
        System.out.printf("        %s %d ----- %s ----- %s\n", teams[0], teamWins.get(teams[0]), teams[0], teams[1]);
    }
}