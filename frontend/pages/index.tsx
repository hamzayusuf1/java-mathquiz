import axios from "axios"
import {useEffect, useState} from "react";

export default function Home () {
    const [loading, setLoading] = useState<boolean>(true)
    const [question, setQuestion] = useState();

    useEffect(() => {
        fetchRandomQuestion();
    }, []);

    const fetchRandomQuestion = async () => {
        setLoading(true)
        try {
              const response = await axios.get<Question>("http://localhost:8080/api/question");
              setQuestion(response.data);
            } catch (err) {
              setError("Failed to fetch question.");
            } finally {
              setLoading(false);
            }
    }

return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h1>Quiz App</h1>

      {loading && <p>Loading...</p>}
      {error && <p style={{ color: "red" }}>{error}</p>}

      {question && (
        <div>
          <h2>{question.title}</h2>
          <p>{question.questionText}</p>
          <ul>
            <li>A. {question.optionA}</li>
            <li>B. {question.optionB}</li>
            <li>C. {question.optionC}</li>
            <li>D. {question.optionD}</li>
          </ul>
          <button onClick={fetchRandomQuestion}>Next Question</button>
        </div>
      )}
    </div>
  );
}