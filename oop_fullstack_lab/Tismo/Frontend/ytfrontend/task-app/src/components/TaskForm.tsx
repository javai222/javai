import { useState } from "react";
import type { Task } from "../types/Task";

interface Props {
    onAdd: (task: Task) => void;
}

const TaskForm = ({ onAdd }: Props) => {
    const [title, setTitle] = useState("");

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();

        if (!title.trim()) return;

        onAdd({
            title,
            completed: false,
        });

        setTitle("");
    };

    return (
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                placeholder="Enter task..."
                value={title}
                onChange={e => setTitle(e.target.value)}
            />
            <button type="submit">Add</button>
        </form>
    );
};

export default TaskForm;