import React, { useState } from "react";
import CurrencyConvertor from "./components/CurrencyConvertor";

export default function App() {
  const [count, setCount] = useState(5);

  function incrementAndSayHello() {
    setCount(count + 1);
    sayHello("Member1");
  }

  function sayHello(msg) {
    alert("Hello! " + msg);
  }

  function decrement() {
    setCount(count - 1);
  }

  function sayWelcome(msg) {
    alert(msg);
  }

  function handlePress(event) {
    alert("I was clicked");
  }

  return (
    <div style={{ margin: 20 }}>
      <div>{count}</div>
      <button onClick={incrementAndSayHello}>Increment</button>
      <button onClick={decrement}>Decrement</button>
      <button onClick={() => sayWelcome("welcome")}>Say welcome</button>
      <button onClick={handlePress}>Click on me</button>
      <CurrencyConvertor />
    </div>
  );
}
