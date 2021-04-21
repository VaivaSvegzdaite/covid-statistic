import React from 'react';
import { Line } from 'react-chartjs-2';

const Chart = ({ data }) => {
  return (
    <div>
      <Line
        data={{
          labels: data.year_weeks,
          datasets: [
            {
              data: data.cases_week,
              label: 'Cases',
              borderColor: 'rgba(75,192,192,1)',
              borderWidth: '2',
              lineTension: 0,
              pointStyle: 'star',
              fill: false,
            },
            {
              data: data.deaths_week,
              label: 'Deaths',
              borderColor: '#3333ff',
              borderWidth: '2',
              lineTension: 0,
              pointStyle: 'star',
              fill: false,
            },
          ],
        }}
        options={{
          responsive: true,
          title: {
            text: 'Covid-19 statistic by week',
            display: true,
          },
          tooltips: {
            backgroundColor: '#606060',
          },
          legend: {
            labels: {
              fontColor: '#606060',
            },
          },
          scales: {
            xAxes: [
              {
                ticks: {
                  fontColor: '#660033',
                },
                gridLines: {
                  display: false,
                },
              },
            ],
            yAxes: [
              {
                ticks: {
                  fontColor: '#660033',
                },
              },
            ],
          },
        }}
      />
    </div>
  );
};

export default Chart;
