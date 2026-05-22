import api from './axios';
import type User from '../types/usertypes';

// Get user by ID
export const getUser = async (id: string): Promise<User> => {
  try {
    const response = await api.get<User>(`/users/${id}`);
    return response.data;
  } catch (error) {
    return Promise.reject(error);
  }
};

// Update user information
export const updateUserAPI = async (
  id: string,
  updates: Partial<Omit<User, 'id'>>
): Promise<User> => {
  try {
    const response = await api.put<User>(`/users/${id}`, updates);
    return response.data;
  } catch (error) {
    return Promise.reject(error);
  }
};

export default getUser;
