import { useProducts } from '../hooks/useProducts';
import { useDeleteProduct } from '../hooks/useDeleteProduct';
import type { Product } from '../types/Product';

interface Props {
    onEdit: (product: Product) => void;
}

const ProductList = ({ onEdit }: Props) => {
    const { data: products, isLoading, isError } = useProducts();
    const { mutate: deleteProduct } = useDeleteProduct();

    if (isLoading) return <p className="empty">Loading products...</p>;
    if (isError) return <p className="empty">Error loading products!</p>;

    return (
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Category</th>
                <th>Price</th>
                <th>Quantity</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            {products?.length === 0 ? (
                <tr><td colSpan={5} className="empty">No products yet. Add one above!</td></tr>
            ) : (
                products?.map(product => (
                    <tr key={product.id}>
                        <td><strong>{product.name}</strong></td>
                        <td><span className="cat-badge">{product.category}</span></td>
                        <td><span className="price">₱{product.price.toLocaleString()}</span></td>
                        <td><span className="qty-badge">{product.quantity}</span></td>
                        <td>
                            <button className="btn-edit" onClick={() => onEdit(product)}>Edit</button>
                            <button className="btn-delete" onClick={() => deleteProduct(product.id!)}>Delete</button>
                        </td>
                    </tr>
                ))
            )}
            </tbody>
        </table>
    );
};

export default ProductList;