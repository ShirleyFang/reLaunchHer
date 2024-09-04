import ActionProviderContext from "./ActionProviderContext";
import {useContext} from "react";

class ActionProvider {

  constructor(createChatBotMessage, setStateFunc, createClientMessage) {
      this.createChatBotMessage = createChatBotMessage;
      this.setState = setStateFunc;
      this.selectedOptions = {
        selectBox1: 'entry',
        selectBox2: 'part time',
        selectBox3: 'online',
        selectBox4: 'free'
      };
  }

  handleServerResponse = (response) => {
    const message = this.createChatBotMessage(response);
    this.updateChatbotState(message);
  };


  handleSelectOption1 = (value) => {
    this.selectedOptions.selectBox1 = value;
    const message = this.createChatBotMessage(`You selected from box 1: ${value}
    .\nWhat is your time commitment?:`, { widget: "selectBox2" });
    this.updateChatbotState(message);
  };

  handleSelectOption2 = (value) => {
    this.selectedOptions.selectBox2 = value;
    const message = this.createChatBotMessage(`You selected from box 2: ${value}
    .\nWhat is your preference learn style?`,  { widget: "selectBox3" });
    this.updateChatbotState(message);
  };

  handleSelectOption3 = (value) => {
    this.selectedOptions.selectBox3 = value;

    const message = this.createChatBotMessage(`You selected from box 2: ${value}.
    \nWhat is your preference financial resources?`,
        { widget: "selectBox4" });
    this.updateChatbotState(message);
  };

  handleSelectOption4 = (value) => {
    this.selectedOptions.selectBox4 = value;
    const message = this.createChatBotMessage(`You selected from box 2: ${value}`);
    this.sendDataToBackend();
    console.log('Response from server:', this.selectedOptions);
  };

  updateChatbotState(message) {
    this.setState(prevState => ({
      ...prevState,
      messages: [...prevState.messages, message]
    }));
  }

  sendDataToBackend = async () => {
    const response = await fetch('http://localhost:3000/about', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(this.selectedOptions)
    });
    // const responseData = await response.json();
    const responseData = await response.text();

    console.log('Response from server:', {message: responseData});
    this.handleServerResponse(responseData);
    this.createChatBotMessage("Data sent successfully.");
  };
}

export default ActionProvider;