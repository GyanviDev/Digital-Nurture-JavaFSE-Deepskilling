import React, { useState } from 'react';
import ListofPlayers from './components/ListofPlayers';
import { IndianPlayersComponent } from './components/IndianPlayers';

function App() {
  // You can use a button/toggle to change this flag
  const [flag, setFlag] = useState(true);

  return (
    <div>
      <button onClick={() => setFlag(!flag)}>
        Toggle Flag (flag is {flag ? "true" : "false"})
      </button>
      <h1>Cricket App</h1>
      {flag ? (
        <div>
          <ListofPlayers />
        </div>
      ) : (
        <div>
          <IndianPlayersComponent/>
        </div>
      )}
    </div>
  );
}

export default App;
