import axios from "axios";

const BASE_URL = "http://localhost:8080/products";

export const getProducts = () => axios.get(BASE_URL);
export const addProduct = (data: any) => axios.post(BASE_URL, data);
export const updateProduct = (id: number, data: any) =>
    axios.put(`${BASE_URL}/${id}`, data);
export const deleteProduct = (id: number) =>
    axios.delete(`${BASE_URL}/${id}`);