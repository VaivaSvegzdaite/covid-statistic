import React, { Component } from 'react';
import axios from 'axios';
import apiEndpoint from './config';
import Chart from './components/Chart';
import CountryPicker from './components/CountryPicker';
import Spinner from './layout/Spinner';

class App extends Component {
  state = {
    data: {},
    country: '',
    isLoading: false,
  };

  async componentDidMount() {
    await axios
      .get(`${apiEndpoint}/api/data/allcountriesdata`)
      .then((res) => this.setState({ data: res.data, isLoading: true }))
      .catch((err) => console.log(err));
  }

  handlerCountryChange = async (country) => {
    await axios
      .get(`${apiEndpoint}/api/data/${country}`)
      .then((res) => this.setState({ data: res.data, country: country }))
      .catch((err) => console.log(err));
  };

  render() {
    const { data, country, isLoading } = this.state;
    return (
      <div className="container mt-5">
        <h3 className="text-center">Covid-19 statistic</h3>
        <CountryPicker handlerCountryChange={this.handlerCountryChange} />
        {isLoading ? <Chart data={data} country={country} /> : <Spinner />}
      </div>
    );
  }
}
export default App;
