export default function UserPage() {
  return (
    <div style={{ margin: "100px auto", textAlign: "center" }}>
      <h1>Welcome back</h1>
      <p>You’re logged in. You can book tickets below.</p>
      
      <div style={{border: "1px solid #ccc", padding: 20, width: 350, margin: "30px auto"}}>
        <h3>Book Your Flight</h3>
        <div>Airline: Indigo</div>
        <div>From: Mumbai</div>
        <div>To: Delhi</div>
        <div>Time: 5:00PM</div>
        <button style={{marginTop: 10}}>Book Ticket</button>
      </div>
    </div>
  );
}
