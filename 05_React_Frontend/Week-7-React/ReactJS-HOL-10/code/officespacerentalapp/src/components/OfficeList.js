import React from "react";
import OfficeCard from "./OfficeCard";

// Office data list (can come from props or here for demo)
const officeList = [
  {
    Name: "DBS",
    Rent: 50000,
    Address: "Chennai",
    img: "https://images.unsplash.com/photo-1506744038136-46273834b3fb?fit=crop&w=600&q=80"
  },
  {
    Name: "Workspace 360",
    Rent: 75000,
    Address: "Bangalore",
    img: "https://images.unsplash.com/photo-1461344577544-4e5dc9487184?fit=crop&w=600&q=80"
  },
  {
    Name: "InnoHub",
    Rent: 45000,
    Address: "Hyderabad",
    img: "https://images.unsplash.com/photo-1472851294608-062f824d29cc?fit=crop&w=600&q=80"
  },
  {
    Name: "PrimeOffices",
    Rent: 90000,
    Address: "Mumbai",
    img: "https://images.unsplash.com/photo-1448932223592-d1fc686e76ea?fit=crop&w=600&q=80"
  },
];

export default function OfficeList() {
  return (
    <div>
      {officeList.map((office, idx) => (
        <OfficeCard office={office} key={idx} />
      ))}
    </div>
  );
}
