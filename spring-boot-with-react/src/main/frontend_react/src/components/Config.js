// config.js
import SelectComponent from './SelectComponent';
import {createChatBotMessage } from 'react-chatbot-kit';


const options1 = [
  { value: "default", label: "Please select an option", disabled: true },
  { value: 'entry', label: 'Entry Level' },
  { value: 'intermediate', label: 'Intermediate Level' },
  { value: 'advanced', label: 'Advanced Level' },
  { value: 'not sure', label: 'Not Sure' }
];

const options2 = [
  { value: "default", label: "Please select an option", disabled: true },
  { value: 'part time', label: 'Part-time' },
  { value: 'Full-time', label: 'Full-time' },
];

const options3 = [
  {value: "default", label: "Please select an option", disabled: true },
  { value: 'online', label: 'Online' },
  { value: 'in person', label: 'In-person' },
];

const options4 = [
  { value: "default", label: "Please select an option", disabled: true },
  { value: 'free', label: 'free' },
  { value: 'non-free', label: 'non-free' },
];

const Config = {
  initialMessages: [createChatBotMessage(`Hello! What would you like to do?`, {
    widget: "selectBox1",
  })],
  widgets: [
    {
      widgetName: "selectBox1",
      widgetFunc: (props) => <SelectComponent {...props} options={options1} handleSelect={props.actionProvider.handleSelectOption1} />,
    },
    {
      widgetName: "selectBox2",
      widgetFunc: (props) => <SelectComponent {...props} options={options2} handleSelect={props.actionProvider.handleSelectOption2} />,
    },
    {
      widgetName: "selectBox3",
      widgetFunc: (props) => <SelectComponent {...props} options={options3} handleSelect={props.actionProvider.handleSelectOption3} />,
    },
    {
      widgetName: "selectBox4",
      widgetFunc: (props) => <SelectComponent {...props} options={options4} handleSelect={props.actionProvider.handleSelectOption4} />,
    },
  ],

};


export default Config