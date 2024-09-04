import React from 'react';
import { useNavigate } from 'react-router-dom';

function NavigationButton() {
  const navigate = useNavigate();

  function handleClick() {
    navigate('/about'); // Navigates to the About page
  }

  return <button onClick={handleClick}>Go to About</button>;
}

export default NavigationButton;
