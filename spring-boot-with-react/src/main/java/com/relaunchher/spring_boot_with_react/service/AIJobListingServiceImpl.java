package com.relaunchher.spring_boot_with_react.service;


import com.relaunchher.spring_boot_with_react.dao.model.JobListing;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AIJobListingServiceImpl implements AIJobListingService {

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
                .append("1: Company name: [xxx]\n")
                .append("2: Job Title: [xxx]\n")
                .append("3: Job Level: [xxx]\n")
                .append("4: Job Requirements: [xxx]\n")
                .append("5: Remote work: [yes/no]\n")
                .append("6: Provides day care: [yes/no]\n")
                .append("7: Link to application: [xxx]");


        return promptBuilder.toString();
    }

    private List<JobListing> parseJobListings(String responseContent, Integer numPostings) {
        List<JobListing> jobListings = new ArrayList<>();

        // Split response into individual job listings using a double newline as a delimiter
        String[] listings = responseContent.split("\n\n");

        for (int i = 0; i < listings.length && i < numPostings; i++) {
            String listing = listings[i];

            // Parse individual job listing data, assuming each line follows the requested format
            String[] lines = listing.split("\n");
            if (lines.length >= 6) {
                try {
                    String companyName = lines[0].split(":")[1].trim();
                    String jobTitle = lines[1].split(":")[1].trim();
                    String jobLevel = lines[2].split(":")[1].trim();
                    String jobRequirements = lines[3].split(":")[1].trim();
                    boolean isRemote = lines[4].split(":")[1].trim().equalsIgnoreCase("yes");
                    boolean providesDayCare = lines[5].split(":")[1].trim().equalsIgnoreCase("yes");
                    String applicationLink = lines.length > 6 ? lines[6].split(":")[1].trim() : "";

                    // Create JobListing object
                    JobListing jobListing = new JobListing(companyName, jobTitle, jobLevel, jobRequirements, isRemote, providesDayCare, applicationLink);
                    jobListings.add(jobListing);
                }
                catch (Exception e) {
                    System.err.println("Error parsing listing: " + listing + ". Error: " + e.getMessage());
                }
        } else {
            System.err.println("Malformed job listing: " + listing);
        }

    }

        return jobListings;

    }
}
