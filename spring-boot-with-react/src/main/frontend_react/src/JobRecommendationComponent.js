import React, { useState } from 'react';
import axios from 'axios';
import './JobRecommendationComponent.css';

const JobRecommendation = () => {
  const [skills, setSkills] = useState('');
  const [interests, setInterests] = useState('');
  const [userId, setUserId] = useState(1); // Example userId
  const [jobRoles, setJobRoles] = useState([]);
  const [selectedRole, setSelectedRole] = useState('');

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

      // Process response to set job roles
      setJobRoles(result.data);
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  const handleRoleChange = (event) => {
    setSelectedRole(event.target.value);
  };

  const handleRoleSubmit = () => {
    // Handle the selected job role
    console.log('Selected Job Role:', selectedRole);
  };

  return (
      <div className="container">
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
        <div className="job-role-container">
          {jobRoles.length > 0 ? (
              <div className="radio-group">
                {jobRoles.map((role, index) => (
                    <div key={index} className="job-role-item">
                      <label>
                        <input
                            type="radio"
                            name="jobRole"
                            value={role.jobRole}
                            checked={selectedRole === role.jobRole}
                            onChange={handleRoleChange}
                        />
                        <strong>{role.jobRole}</strong>
                      </label>
                      {selectedRole === role.jobRole && (
                          <div className="job-description">
                            <p>{role.description}</p>
                          </div>
                      )}
                    </div>
                ))}
              </div>
          ) : (
              <p>No job roles available. Please submit your skills and interests.</p>
          )}
        </div>
        {selectedRole && (
            <button onClick={handleRoleSubmit}>Submit Selected Role</button>
        )}
      </div>
  );
};

export default JobRecommendation;
