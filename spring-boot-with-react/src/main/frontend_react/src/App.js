import React from 'react';
import UserComponent from './UserComponent';
import JobRecommendation from "./JobRecommendationComponent";

function App() {
  // You can hardcode the user ID here or get it dynamically, e.g., from URL params
  const userId = 1; // Example user ID

  return (
      // <div className="App">
      //   <h1>User Profile</h1>
      //   <UserComponent userId={userId} />
      // </div>
      <div className="App">
        <h1>reLaunchHer</h1>
        <JobRecommendation/>
      </div>
  );
}

export default App;
