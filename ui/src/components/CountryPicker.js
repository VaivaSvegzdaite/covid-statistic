import React, { useState, useEffect } from 'react';
import axios from 'axios';
import apiEndpoint from '../config';

const CountryPicker = ({ handlerCountryChange }) => {
  const [countries, setCountries] = useState([]);

  useEffect(() => {
    axios
      .get(`${apiEndpoint}/api/data/countries`)
      .then((res) => setCountries(res.data))
      .catch((err) => console.log(err));
  }, []);

  return (
    <form className="form text-center my-4">
      <select
        className="text-light bg-secondary"
        onChange={(e) => handlerCountryChange(e.target.value)}
      >
        <option className="py-2" value="">
          Worldwide
        </option>
        {countries.map((country, i) => (
          <option key={i} value={country}>
            {country}
          </option>
        ))}
      </select>
    </form>
  );
};
export default CountryPicker;
