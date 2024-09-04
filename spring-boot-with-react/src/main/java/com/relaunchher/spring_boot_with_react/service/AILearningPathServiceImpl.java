package com.relaunchher.spring_boot_with_react.service;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AILearningPathServiceImpl implements AILearningPathService {
  @Resource
  private final ChatClient chatClient;
//  private ChatResponse chatResponse;

  public AILearningPathServiceImpl(ChatClient.Builder chatClientBuilder) {
    this.chatClient = chatClientBuilder.build();
  }

//  @Autowired
//  public AILearningPathServiceImpl(OpenAiChatModel openAiChatModel, ChatClient chatClient) {
//    this.chatClient = chatClient;
//  }

//  @RequestMapping(value = "ai/chat")
//  public String OpenAiChat(@RequestParam(value = "message") String message) {
////    ChatResponse response = openAiChatModel.call(new Prompt(message));
//
////     Extract the message content from the response
////    if (response != null && response.getResults() != null && !response.getResults().isEmpty()) {
////      return response.getResults().get(0).getOutput().getContent();
////    } else {
////      return "No response received from OpenAI.";
////    }
//    String response = openAiChatModel.call(message);
//    return response;
//  }

  /**
   *
   * @param message should include skill level, specific interests in Tech(checkBOX),
   *                Location, financial Resources, Availability and time commitment
   * @return
   */
  public String generateResponse(String message) {
    Prompt prompt = new Prompt("My previous experience is: " + message
        + "I am not ready to find"
        + "a job yet, please generate a learning path for me");
    return this.chatClient.prompt()
        .user(message)
        .call()
        .content();
  }


}
