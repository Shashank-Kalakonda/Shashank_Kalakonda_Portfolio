import { useState } from "react";

export default function ResumeViewer() {
  const [show, setShow] = useState(false);

  return (
    <section id="resume" className="section">
      <h2>My Resume</h2>

      <div className="resume-buttons">
        <button onClick={() => setShow(!show)}>
          {show ? "Hide Resume" : "View Resume"}
        </button>

        <a
          href="http://localhost:8080/api/resume/download"
          target="_blank"
          rel="noreferrer"
        >
          Download
        </a>
      </div>

      {show && (
        <div className="pdf-container">
          <iframe
            src="http://localhost:8080/api/resume/view"
            width="100%"
            height="700px"
            title="Resume Viewer"
          />
        </div>
      )}
    </section>
  );
}