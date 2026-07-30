import React from "react";
import '../App.css';

export default function OfficeCard({ office }) {
  // Color logic for Rent
  const rentClass = office.Rent <= 60000 ? "textRed" : "textGreen";

  return (
    <div style={{ marginBottom: 40 }}>
      <img
        src={office.img}
        alt="Office Space"
        width="300"
        height="200"
        style={{ display: "block" }}
      />
      <h1>Name: {office.Name}</h1>
      <h3 className={rentClass}>Rent: Rs. {office.Rent}</h3>
      <h3>Address: {office.Address}</h3>
    </div>
  );
}
