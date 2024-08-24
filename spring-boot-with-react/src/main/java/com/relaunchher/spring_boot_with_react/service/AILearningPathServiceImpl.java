package com.relaunchher.spring_boot_with_react.service;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AILearningPathServiceImpl implements AILearningPathService {
  @Resource
//  private ;
//  private ChatClient chatClient;
  private OpenAiChatModel openAiChatModel;

  @Autowired
  public AILearningPathServiceImpl(OpenAiChatModel openAiChatModel) {
    this.openAiChatModel = openAiChatModel;
  }

  @RequestMapping(value = "ai/chat")
  public String OpenAiChat(@RequestParam(value = "message") String message) {
//    ChatResponse response = openAiChatModel.call(new Prompt(message));

//     Extract the message content from the response
//    if (response != null && response.getResults() != null && !response.getResults().isEmpty()) {
//      return response.getResults().get(0).getOutput().getContent();
//    } else {
//      return "No response received from OpenAI.";
//    }
    String response = openAiChatModel.call(message);
    return response;
  }


}
