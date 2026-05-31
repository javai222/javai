import React, { useState } from 'react';

interface TaskFormProps {
    onAddTask: (title: string, description: string) => void;
}

export default function TaskForm({ onAddTask }: TaskFormProps) {
    const [title, setTitle] = useState('');
    const [description, setDescription] = useState('');

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        if (!title.trim()) return;
        onAddTask(title, description);
        setTitle('');
        setDescription('');
    };

    return (
        <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', gap: '10px', marginBottom: '30px' }}>
            <input
                type="text" placeholder="Task Title" value={title}
                onChange={(e) => setTitle(e.target.value)} style={{ padding: '8px' }}
            />
            <input
                type="text" placeholder="Description (Optional)" value={description}
                onChange={(e) => setDescription(e.target.value)} style={{ padding: '8px' }}
            />
            <button type="submit" style={{ padding: '10px', background: '#007bff', color: '#fff', border: 'none', cursor: 'pointer' }}>
                Add Task
            </button>
        </form>
    );
}