import { useState, useEffect } from 'react';
import { useCreateProduct } from '../hooks/useCreateProduct';
import { useUpdateProduct } from '../hooks/useUpdateProduct';
import type { Product } from '../types/Product';

interface Props {
    editingProduct: Product | null;
    onCancelEdit: () => void;
}

const AddProduct = ({ editingProduct, onCancelEdit }: Props) => {
    const [name, setName] = useState('');
    const [category, setCategory] = useState('');
    const [price, setPrice] = useState<number | ''>('');
    const [quantity, setQuantity] = useState<number | ''>('');

    const { mutate: createProduct } = useCreateProduct();
    const { mutate: updateProduct } = useUpdateProduct();

    useEffect(() => {
        if (editingProduct) {
            setName(editingProduct.name);
            setCategory(editingProduct.category);
            setPrice(editingProduct.price);
            setQuantity(editingProduct.quantity);
        } else {
            setName(''); setCategory(''); setPrice(''); setQuantity('');
        }
    }, [editingProduct]);

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        const product: Product = { name, category, price: Number(price), quantity: Number(quantity) };
        if (editingProduct?.id) {
            updateProduct({ id: editingProduct.id, product });
        } else {
            createProduct(product);
        }
        setName(''); setCategory(''); setPrice(''); setQuantity('');
        onCancelEdit();
    };

    return (
        <div>
            <h2>{editingProduct ? 'Edit Product' : 'Add New Product'}</h2>
            <div className="form-grid">
                <input placeholder="Product Name" value={name}
                       onChange={e => setName(e.target.value)} required />
                <input placeholder="Category" value={category}
                       onChange={e => setCategory(e.target.value)} required />
                <input type="number" placeholder="Price (₱)" value={price}
                       onChange={e => setPrice(e.target.value === '' ? '' : Number(e.target.value))} required />
                <input type="number" placeholder="Quantity" value={quantity}
                       onChange={e => setQuantity(e.target.value === '' ? '' : Number(e.target.value))} required />
            </div>
            <div className="btn-row">
                <button className="btn-add" onClick={handleSubmit}>
                    {editingProduct ? 'Update Product' : 'Add Product'}
                </button>
                {editingProduct && (
                    <button className="btn-cancel" type="button" onClick={onCancelEdit}>Cancel</button>
                )}
            </div>
        </div>
    );
};

export default AddProduct;