export default function GuestPage() {
  return (
    <div style={{ margin: "100px auto", textAlign: "center" }}>
      <h1>Please sign up.</h1>
      <p>You can browse available flights, but must login to book tickets.</p>
    
      <div style={{border: "1px solid #ccc", padding: 20, width: 350, margin: "30px auto"}}>
        <h3>Flight Details</h3>
        <div>Airline: Indigo</div>
        <div>From: Mumbai</div>
        <div>To: Delhi</div>
        <div>Time: 5:00PM</div>
      </div>
    </div>
  );
}
