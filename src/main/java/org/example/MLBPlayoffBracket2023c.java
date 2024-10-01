package org.example;

import java.util.*;
import java.util.logging.Logger;
import java.util.logging.Level;

public class MLBPlayoffBracket2023c {
    private static final Logger LOGGER = Logger.getLogger(MLBPlayoffBracket2023b.class.getName());

                public static void main(String[] args) {
                    try {
                        Map<String, String> teamNames = initializeTeamNames();
                        Map<String, Integer> seeds2022 = initializeSeeds2022();
                        Map<String, Integer> seeds2023 = initializeSeeds2023();

                        Map<String, Integer> seeds2019 = initializeSeeds2019();

                        // 2019 Playoff Data
                        String[] alTeams2019 = {"HOU", "NYY", "MIN", "OAK", "TB", "BOS"};
                        String[] alWinners2019 = {"TB", "MIN", "HOU", "NYY", "HOU", "HOU"};
                        String[] nlTeams2019 = {"LAD", "ATL", "STL", "WSH", "MIL", "NYM"};
                        String[] nlWinners2019 = {"WSH", "STL", "WSH", "LAD", "WSH", "WSH"};

                        // Validate and print 2019 bracket
                        validateTeamsAndWinners(alTeams2019, alWinners2019, teamNames, seeds2019);
                        validateTeamsAndWinners(nlTeams2019, nlWinners2019, teamNames, seeds2019);
                        System.out.println("\n\n2019 MLB Playoff Bracket:\n\n");
                        printBracket("AMERICAN LEAGUE", alTeams2019, alWinners2019, teamNames, seeds2019);
                        System.out.println("                               ---- HOU " + teamNames.getOrDefault("HOU", "Unknown Team"));
                        printBracket("NATIONAL LEAGUE", nlTeams2019, nlWinners2019, teamNames, seeds2019);
                        System.out.println("\n");

                        // 2022 Playoff Data
                        String[] alTeams2022 = {"HOU", "NYY", "CLE", "SEA", "TB", "TOR"};
                        String[] alWinners2022 = {"SEA", "CLE", "HOU", "NYY", "HOU", "HOU"};
                        String[] nlTeams2022 = {"LAD", "ATL", "STL", "NYM", "SD", "PHI"};
                        String[] nlWinners2022 = {"SD", "PHI", "PHI", "SD", "PHI", "PHI"};

                        // Validate and print 2022 bracket
                        validateTeamsAndWinners(alTeams2022, alWinners2022, teamNames, seeds2022);
                        validateTeamsAndWinners(nlTeams2022, nlWinners2022, teamNames, seeds2022);
                        System.out.println("\n\n2022 MLB Playoff Bracket:\n\n");
                        printBracket("AMERICAN LEAGUE", alTeams2022, alWinners2022, teamNames, seeds2022);
                        System.out.println("                               ---- HOU " + teamNames.getOrDefault("HOU", "Unknown Team"));
                        printBracket("NATIONAL LEAGUE", nlTeams2022, nlWinners2022, teamNames, seeds2022);
                        System.out.println("\n");

                        // 2023 Playoff Data
                        String[] alTeams2023 = {"BAL", "HOU", "MIN", "TB", "TEX", "TOR"};
                        String[] alWinners2023 = {"TEX", "MIN", "TEX", "HOU", "TEX", "TEX"};
                        String[] nlTeams2023 = {"ATL", "LAD", "MIL", "PHI", "AZ", "MIA"};
                        String[] nlWinners2023 = {"AZ", "PHI", "PHI", "AZ", "AZ", "AZ"};



                        // Validate and print 2023 bracket
                        validateTeamsAndWinners(alTeams2023, alWinners2023, teamNames, seeds2023);
                        validateTeamsAndWinners(nlTeams2023, nlWinners2023, teamNames, seeds2023);
                        System.out.println("\n\n2023 MLB Playoff Bracket:\n\n");
                        printBracket("AMERICAN LEAGUE", alTeams2023, alWinners2023, teamNames, seeds2023);
                        System.out.println("                               ---- TEX " + teamNames.getOrDefault("TEX", "Unknown Team"));
                        printBracket("NATIONAL LEAGUE", nlTeams2023, nlWinners2023, teamNames, seeds2023);
                    } catch (IllegalArgumentException e) {
                        LOGGER.log(Level.SEVERE, "Error in input data: " + e.getMessage());
                    } catch (Exception e) {
                        LOGGER.log(Level.SEVERE, "Unexpected error occurred", e);
                    }
                }



    private static Map<String, String> initializeTeamNames() {
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
                    teamNames.put("NYY", "紐約洋基");
                    teamNames.put("CLE", "克里夫蘭守護者");
                    teamNames.put("SEA", "西雅圖水手");
                    teamNames.put("STL", "聖路易紅雀");
                    teamNames.put("NYM", "紐約大都會");
                    teamNames.put("SD", "聖地牙哥教士");
                    teamNames.put("OAK", "奧克蘭運動家");
                    teamNames.put("BOS", "波士頓紅襪");
                    teamNames.put("WSH", "華盛頓國民");
                    return teamNames;
                }
                private static Map<String, Integer> initializeSeeds2019() {
                    Map<String, Integer> seeds = new HashMap<>();
                    seeds.put("HOU", 1);
                    seeds.put("NYY", 2);
                    seeds.put("MIN", 3);
                    seeds.put("OAK", 4);
                    seeds.put("TB", 5);
                    seeds.put("BOS", 6);
                    seeds.put("LAD", 1);
                    seeds.put("ATL", 2);
                    seeds.put("STL", 3);
                    seeds.put("WSH", 4);
                    seeds.put("MIL", 5);
                    seeds.put("NYM", 6);
                    return seeds;
                }

                private static Map<String, Integer> initializeSeeds2022() {
                    Map<String, Integer> seeds = new HashMap<>();
                    seeds.put("HOU", 1);
                    seeds.put("NYY", 2);
                    seeds.put("CLE", 3);
                    seeds.put("SEA", 5);
                    seeds.put("TB", 6);
                    seeds.put("TOR", 4);
                    seeds.put("LAD", 1);
                    seeds.put("ATL", 2);
                    seeds.put("STL", 3);
                    seeds.put("NYM", 4);
                    seeds.put("SD", 5);
                    seeds.put("PHI", 6);
                    return seeds;
                }

                private static Map<String, Integer> initializeSeeds2023() {
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
                    return seeds;
                }

    private static void validateTeamsAndWinners(String[] teams, String[] winners,
                                                Map<String, String> teamNames, Map<String, Integer> seeds) {
        Set<String> uniqueTeams = new HashSet<>(Arrays.asList(teams));
        if (uniqueTeams.size() != teams.length) {
            throw new IllegalArgumentException("Duplicate teams in input");
        }
        for (String team : teams) {
            if (!teamNames.containsKey(team) || !seeds.containsKey(team)) {
                throw new IllegalArgumentException("Unknown team: " + team);
            }
        }
        for (String winner : winners) {
            if (!teamNames.containsKey(winner)) {
                throw new IllegalArgumentException("Unknown winner: " + winner);
            }
        }
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