'use client'

import axios from "axios"

import {useEffect, useState} from "react";

import {Question} from "../../../types/question";

export default function Home () {
    const [loading, setLoading] = useState<boolean>(true)
    const [question, setQuestion] = useState<Question | null>(null);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        fetchRandomQuestion();
    }, []);

    const fetchRandomQuestion = async () => {
        setLoading(true)
        try {
            const response = await axios.get<Question>("http://localhost:8080/api/question");
            setQuestion(response.data);
            console.log(response.data)
        } catch (err) {
            setError("Failed to fetch question.");
            console.error(err)
        } finally {
            setLoading(false);
        }
    }

    return (
        <div className={"w-full h-screen bg-sky-100"}>
        <div className={"text-center p-6"}>
            <h1 className={"bold text-xl text-gray-900 mb-4"}>Quiz App</h1>

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
        </div>
    );
}