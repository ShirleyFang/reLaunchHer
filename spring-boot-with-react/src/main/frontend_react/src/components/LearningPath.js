import React from 'react';
import { Chatbot } from 'react-chatbot-kit';
import NavigationButton from "./NavigationButton";

function LearningPath() {
  return (<div className="chatBox">
    <header className="chatBox-header">
      <chatbot />
    </header>
  </div>
  );
}

export default LearningPath;