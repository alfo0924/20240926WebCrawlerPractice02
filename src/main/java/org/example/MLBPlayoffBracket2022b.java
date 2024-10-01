package org.example;

import java.util.*;

public class MLBPlayoffBracket2022b {
    public static void main(String[] args) {
        Map<String, String> teamNames = new HashMap<>();
        teamNames.put("HOU", "休斯頓太空人");
        teamNames.put("NYY", "紐約洋基");
        teamNames.put("CLE", "克里夫蘭守護者");
        teamNames.put("SEA", "西雅圖水手");
        teamNames.put("TB", "坦帕灣光芒");
        teamNames.put("TOR", "多倫多藍鳥");
        teamNames.put("LAD", "洛杉磯道奇");
        teamNames.put("ATL", "亞特蘭大勇士");
        teamNames.put("STL", "聖路易紅雀");
        teamNames.put("NYM", "紐約大都會");
        teamNames.put("SD", "聖地亞哥教士");
        teamNames.put("PHI", "費城費城人");

        Map<String, Integer> seeds = new HashMap<>();
        seeds.put("HOU", 1);
        seeds.put("NYY", 2);
        seeds.put("CLE", 3);
        seeds.put("TOR", 4);
        seeds.put("SEA", 5);
        seeds.put("TB", 6);
        seeds.put("LAD", 1);
        seeds.put("ATL", 2);
        seeds.put("STL", 3);
        seeds.put("NYM", 4);
        seeds.put("SD", 5);
        seeds.put("PHI", 6);

        printBracket("AMERICAN LEAGUE",
                new String[]{"HOU", "NYY", "CLE", "TOR", "SEA", "TB"},
                new String[]{"SEA", "CLE", "HOU", "NYY", "HOU", "HOU"},
                teamNames, seeds);

        System.out.println("                               ---- HOU " + teamNames.get("HOU"));

        printBracket("NATIONAL LEAGUE",
                new String[]{"LAD", "ATL", "STL", "NYM", "SD", "PHI"},
                new String[]{"SD", "PHI", "PHI", "SD", "PHI", "PHI"},
                teamNames, seeds);
    }

    private static void printBracket(String league, String[] teams, String[] winners,
                                     Map<String, String> teamNames, Map<String, Integer> seeds) {
        System.out.println("(" + league + ")");
        for (int i = 0; i < teams.length; i++) {
            String team = teams[i];
            System.out.printf("%-3s %d %s -----\n", team, seeds.get(team), teamNames.get(team));
            if (i == 1) {
                System.out.printf("%-3s ----- %-3s -----\n", winners[0], winners[2]);
            } else if (i == 2) {
                System.out.printf("        %-3s ----- %-3s\n", team, winners[2]);
            } else if (i == 4) {
                System.out.printf("%-3s ----- %-3s -----\n", winners[1], winners[3]);
                System.out.printf("        %-3s ----- %-3s ----- %-3s\n", teams[0], winners[3], winners[4]);
            }
        }
    }
}