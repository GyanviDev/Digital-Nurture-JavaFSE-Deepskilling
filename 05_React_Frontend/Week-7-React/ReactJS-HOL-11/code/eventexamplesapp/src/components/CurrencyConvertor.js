import React, { useState } from "react";

export default function CurrencyConvertor() {
  const [amount, setAmount] = useState("");
  const [currency, setCurrency] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (currency.trim().toLowerCase() === "euro") {
      // 1 Euro = 80 INR; you can use your preferred rate
      const converted = parseFloat(amount) * 80;
      alert(`Converting to Euro Amount is ${converted}`);
    }
  };

  return (
    <div>
      <h1 style={{ color: "green", fontWeight: "bold" }}>Currency Convertor!!!</h1>
      <form onSubmit={handleSubmit}>
        <label>
          Amount:{" "}
          <input
            type="number"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
          />
        </label>
        <br />
        <label>
          Currency:{" "}
          <input
            type="text"
            value={currency}
            onChange={(e) => setCurrency(e.target.value)}
          />
        </label>
        <br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}
