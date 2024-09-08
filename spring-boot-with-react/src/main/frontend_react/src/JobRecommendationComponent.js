// src/components/JobRecommendation.js
import React, { useState } from 'react';
import axios from 'axios';

const JobRecommendation = () => {
  const [skills, setSkills] = useState('');
  const [interests, setInterests] = useState('');
  const [userId, setUserId] = useState(1); // Example userId
  const [response, setResponse] = useState('');

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const result = await axios.post('http://localhost:8080/api/job-recommendations', null, {
        params: {
          skills: skills,
          interests: interests,
          userId: userId
        }
      });
      // Print response to the console and set it to state
      console.log('Response from backend:', result.data);
      setResponse(result.data);
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  return (
      <div>
        <h2>Get Job Recommendations</h2>
        <form onSubmit={handleSubmit}>
          <div>
            <label>Skills:</label>
            <input
                type="text"
                value={skills}
                onChange={(e) => setSkills(e.target.value)}
            />
          </div>
          <div>
            <label>Interests:</label>
            <input
                type="text"
                value={interests}
                onChange={(e) => setInterests(e.target.value)}
            />
          </div>
          <div>
            <label>User ID:</label>
            <input
                type="number"
                value={userId}
                onChange={(e) => setUserId(Number(e.target.value))}
            />
          </div>
          <button type="submit">Get Recommendations</button>
        </form>
        <div>
          <h3>Response:</h3>
          <pre>{response}</pre>
        </div>
      </div>
  );
};

export default JobRecommendation;
