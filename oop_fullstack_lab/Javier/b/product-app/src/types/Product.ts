import apiClient from "./apiClient";

// ─── Type Definitions ────────────────────────────────────────────────────────

export interface Product {
    id: number;
    name: string;
    description: string;
    price: number;
    stock: number;
    category: string;
    imageUrl?: string;
    createdAt?: string;
    updatedAt?: string;
}

export interface CreateProductPayload {
    name: string;
    description: string;
    price: number;
    stock: number;
    category: string;
    imageUrl?: string;
}

export interface UpdateProductPayload extends Partial<CreateProductPayload> {}

export interface ProductListResponse {
    data: Product[];
    total: number;
    page: number;
    limit: number;
}

// ─── API Functions ────────────────────────────────────────────────────────────

/**
 * Fetch all products (with optional pagination)
 */
export const getProducts = (page = 1, limit = 10): Promise<ProductListResponse> => {
    return new Promise(async (resolve, reject) => {
        try {
            const response = await apiClient.get<ProductListResponse>("/products", {
                params: { page, limit },
            });
            resolve(response.data);
        } catch (error: any) {
            reject(error.response?.data || error.message);
        }
    });
};

/**
 * Fetch a single product by ID
 */
export const getProduct = (productId: number): Promise<Product> => {
    return new Promise(async (resolve, reject) => {
        try {
            const response = await apiClient.get<Product>(`/products/${productId}`);
            resolve(response.data);
        } catch (error: any) {
            reject(error.response?.data || error.message);
        }
    });
};

/**
 * Create a new product
 */
export const createProduct = (payload: CreateProductPayload): Promise<Product> => {
    return new Promise(async (resolve, reject) => {
        try {
            const response = await apiClient.post<Product>("/products", payload);
            resolve(response.data);
        } catch (error: any) {
            reject(error.response?.data || error.message);
        }
    });
};

/**
 * Update an existing product by ID
 */
export const updateProduct = (
    productId: number,
    payload: UpdateProductPayload
): Promise<Product> => {
    return new Promise(async (resolve, reject) => {
        try {
            const response = await apiClient.put<Product>(`/products/${productId}`, payload);
            resolve(response.data);
        } catch (error: any) {
            reject(error.response?.data || error.message);
        }
    });
};

/**
 * Delete a product by ID
 */
export const deleteProduct = (productId: number): Promise<void> => {
    return new Promise(async (resolve, reject) => {
        try {
            await apiClient.delete(`/products/${productId}`);
            resolve();
        } catch (error: any) {
            reject(error.response?.data || error.message);
        }
    });
};