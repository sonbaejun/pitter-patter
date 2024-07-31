import React from 'react';
import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer } from 'recharts';
import styled from 'styled-components';

const data = [
  {
    name: '2024-07-14',
    playtime: 120,
  },
  {
    name: '2024-07-15',
    playtime: 150,
  }, {
    name: '2024-07-16',
    playtime: 160,
  }, {
    name: '2024-07-17',
    playtime: 20,
  }, {
    name: '2024-07-18',
    playtime: 80,
  }, {
    name: '2024-07-19',
    playtime: 60,
  },
];

const LayoutActivityPage = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
`;

const LayoutGraphList = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
`;

const PlaytimeGraph = styled.div`
  width: 80%;
  height: 300px; /* 적절한 높이 설정 */
`;

function ChildActivityTable() {
  return (
    <LayoutActivityPage>
      <LayoutGraphList>
        <PlaytimeGraph>
          <ResponsiveContainer width="100%" height="100%">
            <LineChart
              data={data}
              margin={{
                top: 5,
                right: 30,
                left: 20,
                bottom: 5,
              }}
            >
              <CartesianGrid strokeDasharray="3 3" />
              <XAxis dataKey="name" />
              <YAxis />
              <Tooltip />
              <Legend />
              <Line type="monotone" dataKey="playtime" stroke="#8884d8" activeDot={{ r: 8 }} />
            </LineChart>
          </ResponsiveContainer>
        </PlaytimeGraph>
      </LayoutGraphList>

      <LayoutGraphList>
        <PlaytimeGraph>
          <ResponsiveContainer width="100%" height="100%">
            <LineChart
              data={data}
              margin={{
                top: 5,
                right: 30,
                left: 20,
                bottom: 5,
              }}
            >
              <CartesianGrid strokeDasharray="3 3" />
              <XAxis dataKey="name" />
              <YAxis />
              <Tooltip />
              <Legend />
              <Line type="monotone" dataKey="playtime" stroke="#8884d8" activeDot={{ r: 8 }} />
            </LineChart>
          </ResponsiveContainer>
        </PlaytimeGraph>

        <PlaytimeGraph>
          <ResponsiveContainer width="100%" height="100%">
            <LineChart
              data={data}
              margin={{
                top: 5,
                right: 30,
                left: 20,
                bottom: 5,
              }}
            >
              <CartesianGrid strokeDasharray="3 3" />
              <XAxis dataKey="name" />
              <YAxis />
              <Tooltip />
              <Legend />
              <Line type="monotone" dataKey="playtime" stroke="#8884d8" activeDot={{ r: 8 }} />
            </LineChart>
          </ResponsiveContainer>
        </PlaytimeGraph>
      </LayoutGraphList>
    </LayoutActivityPage>
  );
}

export default ChildActivityTable;
