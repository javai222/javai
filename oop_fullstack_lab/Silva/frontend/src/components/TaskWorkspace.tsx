import { useState, useEffect } from 'react';
import { type Task } from '../types';
import TaskForm from './TaskForm';
import TaskList from './TaskList';

export default function TaskWorkspace() {
    const [tasks, setTasks] = useState<Task[]>([]);
    const API_URL = 'http://localhost:8080/api/tasks';

    // Helper helper to fetch data cleanly
    const loadDatabaseTasks = () => {
        fetch(API_URL)
            .then((res) => {
                if (!res.ok) throw new Error('Network response was not ok');
                return res.json();
            })
            .then((data) => setTasks(data))
            .catch((err) => console.error("Error fetching tasks:", err));
    };

    // Safe execution on mount
    useEffect(() => {
        loadDatabaseTasks();
    }, []);

    const handleAddTask = async (title: string, description: string) => {
        const newTask: Task = { title, description, completed: false };
        try {
            const res = await fetch(API_URL, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(newTask),
            });
            if (res.ok) {
                loadDatabaseTasks();
            }
        } catch (err) {
            console.error("Error adding task:", err);
        }
    };

    const toggleComplete = async (task: Task) => {
        try {
            await fetch(`${API_URL}/${task.id}`, {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ ...task, completed: !task.completed }),
            });
            loadDatabaseTasks();
        } catch (err) {
            console.error("Error updating task:", err);
        }
    };

    const handleDelete = async (id?: number) => {
        if (!id) return;
        try {
            await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
            loadDatabaseTasks();
        } catch (err) {
            console.error("Error deleting task:", err);
        }
    };

    return (
        <div style={{ maxWidth: '600px', margin: '40px auto', padding: '20px', fontFamily: 'sans-serif' }}>
            <h2 style={{ textAlign: 'center', color: '#333' }}>📝 Taskify Workspace</h2>
            <TaskForm onAddTask={handleAddTask} />
            <TaskList tasks={tasks} onToggleComplete={toggleComplete} onDelete={handleDelete} />
        </div>
    );
}