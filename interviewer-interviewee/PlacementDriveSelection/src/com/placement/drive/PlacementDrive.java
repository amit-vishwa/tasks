package com.placement.drive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class PlacementDrive {

	private static final Logger logger = Logger.getLogger(PlacementDrive.class.getName());

	public static void createMap(Map<Integer, Integer> intervieweeInterviewerMap, Integer interviewer,
			Integer interviewee, Random random, boolean isFirstRound, Map<Integer, Integer> round2selections) {
		Integer candidate = random.nextInt(interviewee) + 1;
		Integer examiner = random.nextInt(interviewer) + 1;
		if (isFirstRound) {
			if (intervieweeInterviewerMap.containsKey(candidate))
				createMap(intervieweeInterviewerMap, interviewer, interviewee, random, true, null);
			intervieweeInterviewerMap.put(candidate, examiner);
		} else {
			if (intervieweeInterviewerMap.containsKey(candidate) || !round2selections.containsKey(candidate)
					|| round2selections.get(candidate) == examiner) {
				createMap(intervieweeInterviewerMap, interviewer, interviewee, random, false, round2selections);
			} else
				intervieweeInterviewerMap.put(candidate, examiner);
		}
	}

	public static void main(String[] args) {
		logger.info("Interview selection process:");
		Scanner s = new Scanner(System.in);
		logger.info("Enter total number of interviewers:");
		Integer interviewer = s.nextInt();
		logger.info("Enter total number of interviewees:");
		Integer interviewee = s.nextInt();
		logger.info("Interviewer: " + interviewer + ", Interviewee: " + interviewee);
		logger.info("Interview round 1:");
		Map<Integer, Integer> intervieweeInterviewerMap1 = new HashMap<Integer, Integer>();
		Random random = new Random();
		for (int i = 1; i <= interviewee; i++)
			createMap(intervieweeInterviewerMap1, interviewer, interviewee, random, true, null);
		logger.info("Interviewed for round1 " + intervieweeInterviewerMap1);
		logger.info("Interview round 2:");
		Map<Integer, Integer> round2selections = new HashMap<Integer, Integer>();
		intervieweeInterviewerMap1.forEach((key, value) -> {
			// eliminating every 3rd candidate for round 2
			if (key % 3 != 0)
				round2selections.put(key, value);
		});
		List<Integer> round2Candidates = new ArrayList<Integer>();
		round2selections.forEach((k, v) -> round2Candidates.add(k));
		logger.info("Round 2 selections " + round2Candidates);
		Map<Integer, Integer> intervieweeInterviewerMap2 = new HashMap<Integer, Integer>();
		for (int i = 1; i <= round2selections.size(); i++)
			createMap(intervieweeInterviewerMap2, interviewer, interviewee, random, false, round2selections);
		logger.info("Interviewed for round2 " + intervieweeInterviewerMap2);
		s.close();
	}

}
