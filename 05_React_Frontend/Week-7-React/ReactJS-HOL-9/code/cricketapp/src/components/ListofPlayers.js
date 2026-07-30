import React from 'react';

const players = [
  { name: 'Sachin', score: 80 },
  { name: 'Dravid', score: 65 },
  { name: 'Sehwag', score: 90 },
  { name: 'Kohli', score: 62 },
  { name: 'Rohit', score: 73 },
  { name: 'Dhoni', score: 99 },
  { name: 'Yuvraj', score: 58 },
  { name: 'Shami', score: 67 },
  { name: 'Bumrah', score: 55 },
  { name: 'Jadeja', score: 77 },
  { name: 'Ashwin', score: 85 }
];


const filteredPlayers = players.filter(player => player.score < 70);

export default function ListofPlayers() {
  return (
    <div>
        <h1>List of Players</h1>
      <ul>
        {players.map((p, i) => (
          <li key={i}>
            {p.name} {p.score}
          </li>
        ))}
      </ul>
      <h2>Players with score below 70</h2>
      {filteredPlayers.map((item, idx) => (
        <div key={idx}>
          <li>
            Mr. {item.name} <span>{item.score}</span>
          </li>
        </div>
      ))}
    </div>
  );
}
