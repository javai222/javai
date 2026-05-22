import { useState, useEffect } from 'react';
import type User from '../types/usertypes';
import { updateUserAPI } from '../api/UserService';

export const useUserList = () => {
  const [users, setUsers] = useState<User[]>([]);
  const [loading, setLoading] = useState<boolean>(false);
  const [error, setError] = useState<string | null>(null);
  const [isAdding, setIsAdding] = useState<boolean>(false);
  const [isUpdating, setIsUpdating] = useState<string | null>(null);

  useEffect(() => {
    fetchUsers();
  }, []);

  const fetchUsers = async () => {
    setLoading(true);
    setError(null);
    try {
      
      const response = await fetch('/api/users');
      if (!response.ok) {
        throw new Error(`Server error: ${response.status}`);
      }
      const rawData = await response.json();
      console.log('Raw data from backend:', rawData);

      
      if (Array.isArray(rawData) && rawData.length > 0) {
        console.log('Backend user keys:', Object.keys(rawData[0]));
      }

      const dataArray = Array.isArray(rawData) ? rawData : [rawData];
      const data: User[] = dataArray.map((user: any) => ({
        
        id: String(user.ID ?? user.id ?? user._id ?? 'Unknown'),
        name: user.name || 'Unknown',
        program: user.program || 'Unknown Program',
      }));

      setUsers(data);
      console.log('Processed users:', data);
    } catch (err) {
      const errorMsg = err instanceof Error ? err.message : 'Unknown error';
      console.error('Fetch error:', errorMsg);
      setError(errorMsg);
      setUsers([]);
    } finally {
      setLoading(false);
    }
  };

  const addUser = async (newUser: Omit<User, 'id'>) => {
    setIsAdding(true);
    setError(null);
    try {
      const response = await fetch('/api/users', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify([
          {
            name: newUser.name,
            program: newUser.program,
          },
        ]),
      });

      if (!response.ok) {
        throw new Error(`Failed to add user: ${response.status}`);
      }

      const rawData = await response.json();
      const savedUser = Array.isArray(rawData) ? rawData[0] : rawData;
      const user: User = {
        id: String(savedUser.ID ?? savedUser.id ?? 'Unknown'),
        name: savedUser.name || 'Unknown',
        program: savedUser.program || 'Unknown Program',
      };

      
      setUsers(prev => [...prev, user]);
      console.log('User added successfully:', user);
      return user;
    } catch (err) {
      const errorMsg = err instanceof Error ? err.message : 'Unknown error';
      console.error('Add user error:', errorMsg);
      setError(errorMsg);
      throw err;
    } finally {
      setIsAdding(false);
    }
  };

  const removeUser = async (id: string) => {
    setError(null);
    try {
      console.log('Deleting user with id:', id, '| type:', typeof id);

          
      const response = await fetch(`/api/users/${id}`, {
        method: 'DELETE',
      });

      if (!response.ok) {
        throw new Error(`Failed to delete user: ${response.status}`);
      }

      
      setUsers(prev => prev.filter(user => user.id !== id));
      console.log('User deleted successfully:', id);
    } catch (err) {
      const errorMsg = err instanceof Error ? err.message : 'Unknown error';
      console.error('Delete user error:', errorMsg);
      setError(errorMsg);
      throw err;
    }
  };

  /**
   * Update a user's profile and username (ID cannot be modified).
   * @param id - The user ID (immutable)
   * @param updates - Object containing name and/or program to update
   */
  const updateUser = async (
    id: string,
    updates: Partial<Omit<User, 'id'>>
  ): Promise<User> => {
    setIsUpdating(id);
    setError(null);
    try {
      // Call the API to update the user
      const updatedUserData = await updateUserAPI(id, updates);

      // Map the response to our User type
      const updatedUser: User = {
        id: String(updatedUserData.id ?? id),
        name: updatedUserData.name || 'Unknown',
        program: updatedUserData.program || 'Unknown Program',
      };

      // Update the local state
      setUsers(prev =>
        prev.map(user => (user.id === id ? updatedUser : user))
      );

      console.log('User updated successfully:', updatedUser);
      return updatedUser;
    } catch (err) {
      const errorMsg = err instanceof Error ? err.message : 'Unknown error';
      console.error('Update user error:', errorMsg);
      setError(errorMsg);
      throw err;
    } finally {
      setIsUpdating(null);
    }
  };

  return {
    users,
    loading,
    error,
    isAdding,
    isUpdating,
    fetchUsers,
    addUser,
    removeUser,
    updateUser,
  };
};