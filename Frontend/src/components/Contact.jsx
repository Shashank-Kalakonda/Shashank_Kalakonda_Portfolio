import { useState } from "react";

export default function Contact() {
  const [form, setForm] = useState({
    name: "",
    email: "",
    message: ""
  });

  const submit = async () => {
    try {
      const response = await fetch("http://localhost:8080/api/contact", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(form)
      });

      if (!response.ok) throw new Error("Failed");

      alert("Message sent!");
    } catch (err) {
      alert("Failed to send message");
      console.error(err);
    }
  };

  return (
    <section id="contact" className="section contact-section">
      <h2>Contact Me</h2>

      <div className="contact-form">
        <input
          placeholder="Your Name"
          value={form.name}
          onChange={(e) => setForm({ ...form, name: e.target.value })}
        />

        <input
          placeholder="Your Email"
          value={form.email}
          onChange={(e) => setForm({ ...form, email: e.target.value })}
        />

        <textarea
          placeholder="Your Message"
          value={form.message}
          onChange={(e) => setForm({ ...form, message: e.target.value })}
        />

        <button type="button" onClick={submit}>
          Send Message
        </button>
      </div>
    </section>
  );
}