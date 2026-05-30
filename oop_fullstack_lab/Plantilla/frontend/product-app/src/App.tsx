import { useState } from 'react';
import AddProduct from './components/AddProduct';
import ProductList from './components/ProductList';
import type { Product } from './types/Product';
import './App.css';

function App() {
    const [editingProduct, setEditingProduct] = useState<Product | null>(null);

    return (
        <div className="container">
            <h1>Product Manager</h1>
            <p className="subtitle">Inventory System</p>

            <div className="form">
                <AddProduct
                    editingProduct={editingProduct}
                    onCancelEdit={() => setEditingProduct(null)}
                />
            </div>

            <div className="table-wrapper">
                <div className="table-header">
                    <h3>Product Inventory</h3>
                </div>
                <ProductList onEdit={setEditingProduct} />
            </div>
        </div>
    );
}

export default App;