import React from 'react';

const T20Players = ["Mr. Sachin", "Mr. Dhoni", "Mr. Virat"];
const RanjiTrophyPlayers = ["Mr. Jadeja", "Mr. Raina", "Mr. Rohit"];
const IndianPlayers = [...T20Players, ...RanjiTrophyPlayers]; 


export function OddPlayers({ arr }) {
  const [first, , third, , fifth] = arr;
  return (
    <div>
      <li> First : {first} </li>
      <li> Third : {third} </li>
      <li> Fifth : {fifth} </li>
    </div>
  );
}


// EvenPlayers component
export function EvenPlayers({ arr }) {
  const [, second, , fourth, , sixth] = arr;
  return (
    <div>
      <li> Second : {second} </li>
      <li> Fourth : {fourth} </li>
      <li> Sixth : {sixth} </li>
    </div>
  );
}


export  function IndianPlayersComponent() {
  return (
    <div>
          <h2>Odd Team Players</h2>
          <OddPlayers arr={IndianPlayers} />
          <h2>Even Team Players</h2>
          <EvenPlayers arr={IndianPlayers} />
      <h1>List of Indian Players (Merged)</h1>
      <ul>
        {IndianPlayers.map((p, i) => (
          <li key={i}>{p}</li>
        ))}
      </ul>
      <hr />
    </div>
  );
}

