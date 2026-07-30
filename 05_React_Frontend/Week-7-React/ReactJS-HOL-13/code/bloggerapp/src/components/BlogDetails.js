import React from "react";

export default function BlogDetails() {
  return (
    <div>
      <h2 style={{ fontWeight: "bold" }}>Blog Details</h2>
      <div>
        <span style={{ fontWeight: "bold", fontSize: "1.15em" }}>React Learning</span>
        <div style={{ fontWeight: "bold" }}>Stephen Biz</div>
        <div style={{ marginBottom: 16 }}>Welcome to learning React!</div>
      </div>
      <div>
        <span style={{ fontWeight: "bold", fontSize: "1.15em" }}>Installation</span>
        <div style={{ fontWeight: "bold" }}>Schewzdenier</div>
        <div>You can install React from npm.</div>
      </div>
    </div>
  );
}
