import React, {useState} from 'react';
import { Chatbot } from "react-chatbot-kit";

import "../App.css"
import ActionProvider from "./ActionProvider";
import Config from "./Config";
import MessageParser from "./MessageParser";
import ActionProviderContext from "./ActionProviderContext";

function About() {

  return (
        <div className="chatbox">
          <h1 className="chatbox-header">About Page</h1>
            <Chatbot config={Config} messageParser={MessageParser}
                     actionProvider={ActionProvider}/>
        </div>
  );
}


export default About;