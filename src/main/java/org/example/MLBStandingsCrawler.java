package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MLBStandingsCrawler {
    public static void main(String[] args) {
        String url = "https://www.mlb.com/standings/2022?tableType=regularSeasonStandard";
        try {
            Document doc = getDocument(url);
            if (doc != null) {
                List<TeamRecord> teamRecords = crawlMLBStandings(doc);
                printTeamRecords(teamRecords);
            }
        } catch (IOException e) {
            System.out.println("Error crawling MLB standings: " + e.getMessage());
        }
    }

    private static Document getDocument(String url) throws IOException {
        return Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
                .timeout(10000)
                .get();
    }

    private static List<TeamRecord> crawlMLBStandings(Document doc) {
        List<TeamRecord> teamRecords = new ArrayList<>();
        Elements rows = doc.select("table tbody tr");

        for (Element row : rows) {
            Elements cells = row.select("td");
            if (cells.size() >= 3) {
                String teamName = row.select("th").text().replaceAll("[yx]$", "").trim();
                String teamAbbr = row.select("th span.standings-table__team-name--abbrev").text();
                int wins = parseIntSafely(cells.get(0).text());
                int losses = parseIntSafely(cells.get(1).text());
                teamRecords.add(new TeamRecord(teamName, teamAbbr, wins, losses));
            }
        }

        return teamRecords;
    }

    private static int parseIntSafely(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0; // Return 0 for non-numeric values
        }
    }

    private static void printTeamRecords(List<TeamRecord> teamRecords) {
        System.out.println("MLB Team Records:");
        System.out.println("------------------");
        for (TeamRecord record : teamRecords) {
            System.out.printf("%-25s (%s): %3d wins, %3d losses%n",
                    record.teamName, record.teamAbbr, record.wins, record.losses);
        }
    }

    private static class TeamRecord {
        String teamName;
        String teamAbbr;
        int wins;
        int losses;

        TeamRecord(String teamName, String teamAbbr, int wins, int losses) {
            this.teamName = teamName;
            this.teamAbbr = teamAbbr;
            this.wins = wins;
            this.losses = losses;
        }
    }
}