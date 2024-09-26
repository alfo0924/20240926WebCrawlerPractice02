package org.example;

public class MLBPlayoffs2022 {
    public static void main(String[] args) {
        String[] teams = {
                "SEA 90", "HOU 106", "CLE 92", "TB  86", "NYY 99",
                "SD  89", "STL 93", "PHI 87", "NYM 101", "LAD 111"
        };

        String[] winners = {
                "HOU", "CLE", "NYY", "SD", "PHI", "LAD", "HOU", "PHI", "HOU", "PHI"
        };

        System.out.println("(AMERICAN LEAGUE)");
        printBracket(teams, winners, 0, 5);
        System.out.println("                               ---- HOU");
        printBracket(teams, winners, 5, 10);
        System.out.println("(NATIONAL LEAGUE)");
    }

    private static void printBracket(String[] teams, String[] winners, int start, int end) {
        System.out.println(teams[start] + " -----");
        System.out.println(teams[start + 1] + " ----- " + winners[start / 5] + " -----");
        System.out.println("        " + teams[start + 2] + " ----- " + winners[start / 5 + 2]);
        System.out.println(teams[start + 2] + " -----");
        System.out.println(teams[start + 3] + " ----- " + teams[start + 2].substring(0, 3) + " -----  ");
        System.out.println("        " + teams[start + 4] + " ----- " + winners[start / 5 + 1] + " ----- " + winners[start / 5 + 3]);
        if (start == 0) {
            System.out.println("                               ---- " + winners[6]);
        }
    }
}