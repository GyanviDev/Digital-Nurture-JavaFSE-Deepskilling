import React from "react";
import OfficeList from "./components/OfficeList";

export default function App() {
  // JSX element heading
  const pageHeading = <h1 style={{ fontWeight: "bold" }}>
    Office Space , at Affordable Range
  </h1>;

  return (
    <div style={{ padding: 40 }}>
      {pageHeading}
      <br />
      <OfficeList />
    </div>
  );
}
