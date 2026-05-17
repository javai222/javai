// src/api/productService.ts
import apiClient from "./axios";

// GET all products
const getProducts = async () => {
    return new Promise(async (resolve, reject) => {
        try {
            const response = await apiClient.get(`/api/products`);
            resolve(response.data);
        } catch (error: any) {
            reject(error.response?.data || error.message);
        }
    });
};

// GET single product
const getProduct = async (productId: number) => {
    return new Promise(async (resolve, reject) => {
        try {
            const response = await apiClient.get(`/api/products/${productId}`);
            resolve(response.data);
        } catch (error: any) {
            reject(error.response?.data || error.message);
        }
    });
};

// DELETE product
const deleteProduct = async (productId: number) => {
    return new Promise(async (resolve, reject) => {
        try {
            const response = await apiClient.delete(`/api/products/${productId}`);
            resolve(response.data);
        } catch (error: any) {
            reject(error.response?.data || error.message);
        }
    });
};

// PUT update product
const updateProduct = async (productId: number, payload: any) => {
    return new Promise(async (resolve, reject) => {
        try {
            const response = await apiClient.put(`/api/products/${productId}`, payload);
            resolve(response.data);
        } catch (error: any) {
            reject(error.response?.data || error.message);
        }
    });
};

export { getProducts, getProduct, deleteProduct, updateProduct };