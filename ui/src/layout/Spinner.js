import React from 'react';
import spinner from './spinner.gif';

export default () => (
  <React.Fragment>
    <img
      src={spinner}
      style={{ width: '200px', margin: 'auto', display: 'block' }}
      alt="Loading..."
    />
  </React.Fragment>
);
