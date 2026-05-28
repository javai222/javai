import { useEffect, useState } from "react";
import type { Task } from "../types/Task";
import * as taskService from "../api/taskService";

export const useTasks = () => {
    const [tasks, setTasks] = useState<Task[]>([]);

    const createTask = async (task: Task) => {
        const newTask = await taskService.addTask(task);
        setTasks(prev => [...prev, newTask]);
    };

    const updateTask = async (id: number, updated: Task) => {
        const updatedTask = await taskService.updateTask(id, updated);
        setTasks(prev =>
            prev.map(t => (t.id === id ? updatedTask : t))
        );
    };

    const removeTask = async (id: number) => {
        await taskService.deleteTask(id);
        setTasks(prev => prev.filter(t => t.id !== id));
    };

    // ✅ CLEAN EFFECT (no ESLint warning version)
    useEffect(() => {
        const load = async () => {
            const data = await taskService.getAllTasks();
            setTasks(data);
        };

        load();
    }, []);

    return { tasks, createTask, updateTask, removeTask };
};