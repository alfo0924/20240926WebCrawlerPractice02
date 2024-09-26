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
            return 0; // 返回0或其他默認值
        }
    }

    private static void printPlayoffBracket(List<Team> teams) {
        Map<String, Team> teamMap = new HashMap<>();
        for (Team team : teams) {
            teamMap.put(team.abbr, team);
        }

        System.out.println("(AMERICAN LEAGUE)");
        printBracketPart(teamMap, new String[]{"SEA", "HOU", "CLE", "TB", "NYY"}, new String[]{"HOU", "HOU", "CLE", "NYY", "HOU"});
        System.out.println("                               ---- HOU");
        printBracketPart(teamMap, new String[]{"SD", "STL", "PHI", "NYM", "LAD"}, new String[]{"SD", "PHI", "PHI", "LAD", "PHI"});
        System.out.println("(NATIONAL LEAGUE)");
    }

    private static void printBracketPart(Map<String, Team> teamMap, String[] teamOrder, String[] winners) {
        for (int i = 0; i < teamOrder.length; i++) {
            Team team = teamMap.get(teamOrder[i]);
            if (team == null) {
                System.out.printf("%s N/A -----\n", teamOrder[i]);
            } else {
                System.out.printf("%s %d -----\n", team.abbr, team.wins);
            }
            if (i < winners.length) {
                System.out.printf("%s -----\n", winners[i]);
            }
            if (i == 1) {
                System.out.print("        ");
            }
        }
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


