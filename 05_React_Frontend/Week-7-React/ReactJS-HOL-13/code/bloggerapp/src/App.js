import React from "react";
import "./App.css";
import CourseDetails from "./components/CourseDetails";
import BookDetails from "./components/BookDetails";
import BlogDetails from "./components/BlogDetails";

export default function App() {
  return (
    <div className="main-container">
      <div className="column"><CourseDetails /></div>
      <div className="separator" />
      <div className="column"><BookDetails /></div>
      <div className="separator" />
      <div className="column"><BlogDetails /></div>
    </div>
  );
}
