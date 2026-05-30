import { useMutation, useQueryClient } from '@tanstack/react-query';
import { updateProduct } from '../api/productService';
import type { Product } from '../types/Product';

export const useUpdateProduct = () => {
    const queryClient = useQueryClient();
    return useMutation({
        mutationFn: ({ id, product }: { id: number; product: Product }) =>
            updateProduct(id, product),
        onSuccess: () => {
            queryClient.invalidateQueries({ queryKey: ['products'] });
        },
    });
};