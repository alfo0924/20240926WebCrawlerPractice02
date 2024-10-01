package org.example;

import java.util.*;

public class MLBPlayoffBracket2023b {
    public static void main(String[] args) {
        Map<String, String> teamNames = new HashMap<>();
        teamNames.put("TEX", "德克薩斯遊騎兵");
        teamNames.put("HOU", "休斯頓太空人");
        teamNames.put("MIN", "明尼蘇達雙城");
        teamNames.put("TB", "坦帕灣光芒");
        teamNames.put("TOR", "多倫多藍鳥");
        teamNames.put("BAL", "巴爾的摩金鶯");
        teamNames.put("AZ", "亞利桑那響尾蛇");
        teamNames.put("PHI", "費城費城人");
        teamNames.put("MIL", "密爾瓦基釀酒人");
        teamNames.put("MIA", "邁阿密馬林魚");
        teamNames.put("LAD", "洛杉磯道奇");
        teamNames.put("ATL", "亞特蘭大勇士");

        Map<String, Integer> seeds = new HashMap<>();
        seeds.put("BAL", 1);
        seeds.put("HOU", 2);
        seeds.put("MIN", 3);
        seeds.put("TB", 4);
        seeds.put("TEX", 5);
        seeds.put("TOR", 6);
        seeds.put("ATL", 1);
        seeds.put("LAD", 2);
        seeds.put("MIL", 3);
        seeds.put("PHI", 4);
        seeds.put("AZ", 5);
        seeds.put("MIA", 6);

        printBracket("AMERICAN LEAGUE",
                new String[]{"BAL", "HOU", "MIN", "TB", "TEX", "TOR"},
                new String[]{"TEX", "MIN", "TEX", "HOU", "TEX", "TEX"},
                teamNames, seeds);

        System.out.println("                               ---- TEX " + teamNames.get("TEX"));

        printBracket("NATIONAL LEAGUE",
                new String[]{"ATL", "LAD", "MIL", "PHI", "AZ", "MIA"},
                new String[]{"AZ", "PHI", "PHI", "AZ", "AZ", "AZ"},
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