import React from 'react';
import UserComponent from './UserComponent';
import LearningPath from './components/LearningPath';
import ReactDOM from 'react-dom';
import { BrowserRouter } from 'react-router-dom';
import { Route, Routes } from 'react-router-dom';
import NavigationButton from "./components/NavigationButton";
import Home from "./components/Home";
import About from "./components/About";
function App() {
  // You can hardcode the user ID here or get it dynamically, e.g., from URL params
  const userId = 1; // Example user ID
  console.log(1);
  return (
      <BrowserRouter>
        <div>
          <NavigationButton /> {/* Button to navigate to the About page */}
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/about" element={<About />} />
          </Routes>
        </div>
      </BrowserRouter>
  );
}

export default App;
