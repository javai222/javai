import { useMutation, useQueryClient } from '@tanstack/react-query';
import { createProduct } from '../api/productService';
import type { Product } from '../types/Product';

export const useCreateProduct = () => {
    const queryClient = useQueryClient();
    return useMutation({
        mutationFn: (product: Product) => createProduct(product),
        onSuccess: () => {
            queryClient.invalidateQueries({ queryKey: ['products'] });
        },
    });
};