import axiosInstance from './axios';
import type { Product } from '../types/Product';

export const getProducts = async (): Promise<Product[]> => {
    const response = await axiosInstance.get('/products');
    return response.data;
};

export const createProduct = async (product: Product): Promise<Product> => {
    const response = await axiosInstance.post('/products', product);
    return response.data;
};

export const updateProduct = async (id: number, product: Product): Promise<Product> => {
    const response = await axiosInstance.put(`/products/${id}`, product);
    return response.data;
};

export const deleteProduct = async (id: number): Promise<void> => {
    await axiosInstance.delete(`/products/${id}`);
};