import { useState, useCallback } from 'react';

export function useSelectedOptions() {
  const [options, setOptions] = useState({
    selectBox1: '',
    selectBox2: '',
    selectBox3: '',
    selectBox4: ''
  });

  const updateOption = useCallback((boxName, value) => {
    setOptions(prevOptions => ({
      ...prevOptions,
      [boxName]: value
    }));
  }, []);

  return [options, updateOption];
}