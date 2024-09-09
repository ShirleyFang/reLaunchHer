import React, { useState, useEffect } from 'react';

function UserComponent({ userId }) {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

    useEffect(() => {
        console.log(`Fetching user data for userId: ${userId}`); // Debug log
        fetch(`/user/${userId}`)
            .then(response => {
                console.log('Response:', response); // Debug log
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                console.log('Data received:', data); // Debug log
                setUser(data);
                setLoading(false);
            })
            .catch(error => {
                console.error('Fetch error:', error); // Debug log
                setError(error);
                setLoading(false);
            });
    }, [userId]);


    if (loading) return <p>Loading user data...</p>;
  if (error) return <p>Error: {error.message}</p>;

  return (
      <div>
        <h2>User Information</h2>
        <p><strong>ID:</strong> {user.id}</p>
        <p><strong>Name:</strong> {user.name}</p>
        <p><strong>Username:</strong> {user.userName}</p>
        <p><strong>Email:</strong> {user.email}</p>
        <p><strong>Gender:</strong> {user.gender}</p>
        <p><strong>Age:</strong> {user.age}</p>
      </div>
  );
}

export default UserComponent;
