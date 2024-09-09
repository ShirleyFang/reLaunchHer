package com.relaunchher.spring_boot_with_react.service;


import com.relaunchher.spring_boot_with_react.dao.model.JobListing;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AIJobListingServiceImpl implements AIJobListingService {

    private static final Pattern companyPattern = Pattern.compile("^Company Name: (.+)$");
    private static final Pattern jobTitlePattern = Pattern.compile("^Job Title: (.+)$");
    private static final Pattern jobLevelPattern = Pattern.compile("^Job Level: (.+)$");
    private static final Pattern jobRequirementsPattern = Pattern.compile("^Job Requirements: (.+)$");
    private static final Pattern remotePattern = Pattern.compile("^Remote Work: (yes|no)$");
    private static final Pattern dayCarePattern = Pattern.compile("^Provides Day Care: (yes|no)$");
    private static final Pattern linkPattern = Pattern.compile("^Link to application: (.+)$");

    @Autowired
    private final OpenAiChatModel openAiChatModel;

    public AIJobListingServiceImpl(OpenAiChatModel openAiChatModel) {
        this.openAiChatModel = openAiChatModel;
    }

    @Override
    public List<JobListing> getJobListings(Integer numPostings, String jobTitle, String jobLevel, Boolean remoteIsRequired, Boolean dayCareIsRequired) {

        String prompt = this.generatePrompt(numPostings, jobTitle, jobLevel, remoteIsRequired, dayCareIsRequired);

        ChatResponse chatResponse = openAiChatModel.call(new Prompt(prompt));

        if (chatResponse != null && chatResponse.getResults() != null && !chatResponse.getResults().isEmpty()) {
            String response = chatResponse.getResults().get(0).getOutput().getContent();
            return this.parseJobListings(response, numPostings);
        } else {
            return new ArrayList<>();
        }

    }

    private String generatePrompt(Integer numPostings, String jobTitle, String jobLevel, Boolean remoteIsRequired, Boolean dayCareIsRequired) {
        StringBuilder promptBuilder = new StringBuilder();
        promptBuilder.append("Your job is to generate ")
                .append(numPostings)
                .append(" job postings that best fit the requirements. ")
                .append("This person you are generating job listings for is a current housewife and wants to get back into the workforce. ")
                .append("They are looking for a role as a ")
                .append(jobTitle)
                .append(" and the job level they are looking for is ")
                .append(jobLevel)
                .append(". ");

        if (remoteIsRequired) {
            promptBuilder.append("A remote position is required. ");
        } else {
            promptBuilder.append("A remote position is not required. ");
        }

        if (dayCareIsRequired) {
            promptBuilder.append("The company must provide daycare. ");
        } else {
            promptBuilder.append("The company does not have to provide daycare. ");
        }

        promptBuilder.append("Please provide the job listings in the following format:\n")
                .append("Company Name: [xxx]\n")
                .append("Job Title: [xxx]\n")
                .append("Job Level: [xxx]\n")
                .append("Job Requirements: [xxx]\n")
                .append("Remote Work: [yes/no]\n")
                .append("Provides Day Care: [yes/no]\n")
                .append("Link to application: [xxx]");

        return promptBuilder.toString();
    }

    private List<JobListing> parseJobListings(String responseContent, Integer numPostings) {
        List<JobListing> jobListings = new ArrayList<>();

        // Split response into individual job listings
        String[] listings = responseContent.split("\n\n");

        for (int i = 0; i < listings.length && i < numPostings; i++) {
            String listing = listings[i];

            String companyName = "N/A";
            String jobTitle = "N/A";
            String jobLevel = "N/A";
            String jobRequirements = "N/A";
            boolean isRemote = false;
            boolean providesDayCare = false;
            String applicationLink = "N/A";

            String[] lines = listing.split("\n");

            for (String line : lines) {

                Matcher companyMatcher = companyPattern.matcher(line);
                Matcher titleMatcher = jobTitlePattern.matcher(line);
                Matcher levelMatcher = jobLevelPattern.matcher(line);
                Matcher requirementsMatcher = jobRequirementsPattern.matcher(line);
                Matcher remoteMatcher = remotePattern.matcher(line);
                Matcher dayCareMatcher = dayCarePattern.matcher(line);
                Matcher linkMatcher = linkPattern.matcher(line);

                if (companyMatcher.matches()) {
                    companyName = companyMatcher.group(1);
                } else if (titleMatcher.matches()) {
                    jobTitle = titleMatcher.group(1);
                } else if (levelMatcher.matches()) {
                    jobLevel = levelMatcher.group(1);
                } else if (requirementsMatcher.matches()) {
                    jobRequirements = requirementsMatcher.group(1);
                } else if (remoteMatcher.matches()) {
                    isRemote = remoteMatcher.group(1).equalsIgnoreCase("yes");
                } else if (dayCareMatcher.matches()) {
                    providesDayCare = dayCareMatcher.group(1).equalsIgnoreCase("yes");
                } else if (linkMatcher.matches()) {
                    applicationLink = linkMatcher.group(1);
                }

            }

            JobListing jobListing = new JobListing(companyName, jobTitle, jobLevel, jobRequirements, isRemote, providesDayCare, applicationLink);
            jobListings.add(jobListing);
        }

        return jobListings;

    }
}
