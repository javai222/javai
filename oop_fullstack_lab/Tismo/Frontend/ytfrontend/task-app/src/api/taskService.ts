import axios from "axios";
import type { Task } from "../types/Task";

const API_URL = "http://localhost:8080/api/tasks";

export const getAllTasks = async (): Promise<Task[]> => {
    const res = await axios.get(API_URL);
    return res.data;
};

export const addTask = async (task: Task): Promise<Task> => {
    const res = await axios.post(API_URL, task);
    return res.data;
};

export const updateTask = async (id: number, task: Task): Promise<Task> => {
    const res = await axios.put(`${API_URL}/${id}`, task);
    return res.data;
};

export const deleteTask = async (id: number): Promise<void> => {
    await axios.delete(`${API_URL}/${id}`);
};