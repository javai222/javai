import apiClient from './axios';
import type { Student } from '../types/Student'; // 👈 Adds the missing definition!

export const getStudents = async (): Promise<Student[]> => {
    try {
        const response = await apiClient.get('/api/student/create');
        return response.data;
    } catch (error) {
        console.error('Error fetching students:', error);
        throw error;
    }
};