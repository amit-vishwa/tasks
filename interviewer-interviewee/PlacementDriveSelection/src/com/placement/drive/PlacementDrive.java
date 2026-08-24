package com.placement.drive;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public final class PlacementDrive {

    private static final Logger LOGGER = Logger.getLogger(PlacementDrive.class.getName());

    private PlacementDrive() {
    }

    static Map<Integer, Integer> assignInterviewers(
            int interviewerCount,
            Collection<Integer> candidates,
            Map<Integer, Integer> previousAssignments,
            Random random) {
        if (interviewerCount < 1) {
            throw new IllegalArgumentException("At least one interviewer is required");
        }
        if (previousAssignments != null && interviewerCount < 2 && !candidates.isEmpty()) {
            throw new IllegalArgumentException("Round two requires at least two interviewers");
        }

        Map<Integer, Integer> assignments = new HashMap<>();
        for (Integer candidate : candidates) {
            List<Integer> eligibleInterviewers = new ArrayList<>();
            for (int interviewer = 1; interviewer <= interviewerCount; interviewer++) {
                if (previousAssignments == null
                        || interviewer != previousAssignments.getOrDefault(candidate, 0)) {
                    eligibleInterviewers.add(interviewer);
                }
            }
            assignments.put(candidate, eligibleInterviewers.get(random.nextInt(eligibleInterviewers.size())));
        }
        return assignments;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            LOGGER.info("Enter total number of interviewers:");
            int interviewerCount = scanner.nextInt();
            LOGGER.info("Enter total number of interviewees:");
            int intervieweeCount = scanner.nextInt();
            if (interviewerCount < 2 || intervieweeCount < 1) {
                throw new IllegalArgumentException(
                        "Two or more interviewers and at least one interviewee are required");
            }

            List<Integer> allCandidates = new ArrayList<>();
            for (int candidate = 1; candidate <= intervieweeCount; candidate++) {
                allCandidates.add(candidate);
            }

            Random random = new Random();
            Map<Integer, Integer> roundOne = assignInterviewers(
                    interviewerCount, allCandidates, null, random);
            LOGGER.info("Round 1 assignments: " + roundOne);

            List<Integer> roundTwoCandidates = new ArrayList<>();
            for (Integer candidate : allCandidates) {
                if (candidate % 3 != 0) {
                    roundTwoCandidates.add(candidate);
                }
            }
            Map<Integer, Integer> roundTwo = assignInterviewers(
                    interviewerCount, roundTwoCandidates, roundOne, random);
            LOGGER.info("Round 2 assignments: " + roundTwo);
        }
    }
}
