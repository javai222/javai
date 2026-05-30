import { useMutation, useQueryClient } from '@tanstack/react-query';
import { deleteProduct } from '../api/productService';

export const useDeleteProduct = () => {
    const queryClient = useQueryClient();
    return useMutation({
        mutationFn: (id: number) => deleteProduct(id),
        onSuccess: () => {
            queryClient.invalidateQueries({ queryKey: ['products'] });
        },
    });
};