import React, { useState } from 'react';

function SelectComponent({ options, handleSelect }) {
  const [selectedValue, setSelectedValue] = useState('default');

  const handleChange = (event) => {
    setSelectedValue(event.target.value);
    handleSelect(event.target.value);
  };

  return (
      <select value={selectedValue} onChange={handleChange}>
        {options.map(option => (
            <option key={option.value} value={option.value} disabled={option.disabled}>
              {option.label}
            </option>
        ))}
      </select>
  );
}

export default SelectComponent;
