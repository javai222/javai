import { useState } from 'react';
import type { Product } from '../types/Product';
import './ProductList.css';

interface ProductListProps {
  products: Product[];
  loading: boolean;
  error: string | null;
  refresh: () => void;
  editProduct: (id: number, product: Omit<Product, 'id'>) => Promise<void>;
  removeProduct: (id: number) => Promise<void>;
}

export default function ProductList({ products, loading, error, refresh, editProduct, removeProduct }: ProductListProps) {
  const [editingId, setEditingId] = useState<number | null>(null);
  const [editForm, setEditForm] = useState<Omit<Product, 'id'>>({ name: '', price: 0, description: '', quantity: 0 });
  const [saving, setSaving] = useState(false);

  const startEdit = (product: Product) => {
    setEditingId(product.id);
    setEditForm({
      name: product.name,
      price: product.price,
      description: product.description,
      quantity: product.quantity,
    });
  };

  const cancelEdit = () => {
    setEditingId(null);
    setEditForm({ name: '', price: 0, description: '', quantity: 0 });
  };

  const handleEditChange = (field: keyof Omit<Product, 'id'>, value: string) => {
    setEditForm((prev) => ({
      ...prev,
      [field]: field === 'price' ? parseFloat(value) || 0 : field === 'quantity' ? parseInt(value) || 0 : value,
    }));
  };

  const saveEdit = async (id: number) => {
    try {
      setSaving(true);
      await editProduct(id, editForm);
      setEditingId(null);
    } catch {
      alert('Failed to update product.');
    } finally {
      setSaving(false);
    }
  };

  const handleDelete = async (id: number) => {
    if (!confirm('Are you sure you want to delete this product?')) return;
    try {
      await removeProduct(id);
    } catch {
      alert('Failed to delete product.');
    }
  };

  if (loading) {
    return (
      <div className="product-list-loading">
        <div className="spinner" />
        <p>Loading products...</p>
      </div>
    );
  }

  if (error) {
    return (
      <div className="product-list-error">
        <span className="error-icon">!</span>
        <p>{error}</p>
        <button onClick={refresh} className="retry-btn">Retry</button>
      </div>
    );
  }

  if (products.length === 0) {
    return (
      <div className="product-list-empty">
        <span className="empty-icon">&#128230;</span>
        <p>No products found.</p>
      </div>
    );
  }

  return (
    <section className="product-list">
      <div className="product-list-header">
        <h2 className="product-list-title">Our Products</h2>
        <button onClick={refresh} className="refresh-btn" disabled={loading}>
          <span className={`refresh-icon ${loading ? 'spinning' : ''}`}>&#x21bb;</span>
          Refresh
        </button>
      </div>
      <div className="product-grid">
        {products.map((product) => (
          <article className="product-card" key={product.id} id={`product-${product.id}`}>
            {editingId === product.id ? (
              <div className="edit-form">
                <div className="form-group">
                  <label>Name</label>
                  <input
                    type="text"
                    value={editForm.name}
                    onChange={(e) => handleEditChange('name', e.target.value)}
                  />
                </div>
                <div className="form-row">
                  <div className="form-group">
                    <label>Price ($)</label>
                    <input
                      type="number"
                      step="0.01"
                      min="0.01"
                      value={editForm.price || ''}
                      onChange={(e) => handleEditChange('price', e.target.value)}
                    />
                  </div>
                  <div className="form-group">
                    <label>Quantity</label>
                    <input
                      type="number"
                      min="0"
                      value={editForm.quantity ?? ''}
                      onChange={(e) => handleEditChange('quantity', e.target.value)}
                    />
                  </div>
                </div>
                <div className="form-group">
                  <label>Description</label>
                  <textarea
                    value={editForm.description}
                    onChange={(e) => handleEditChange('description', e.target.value)}
                    rows={2}
                  />
                </div>
                <div className="edit-actions">
                  <button className="save-btn" onClick={() => saveEdit(product.id)} disabled={saving}>
                    {saving ? 'Saving...' : 'Save'}
                  </button>
                  <button className="cancel-btn" onClick={cancelEdit} disabled={saving}>
                    Cancel
                  </button>
                </div>
              </div>
            ) : (
              <>
                <div className="product-card-header">
                  <div className="header-left">
                    <span className="product-id">#{product.id}</span>
                    <span className={`product-stock ${product.quantity ? 'in-stock' : 'out-of-stock'}`}>
                      {product.quantity ? 'In Stock' : 'Out of Stock'}
                    </span>
                  </div>
                  <div className="product-actions">
                    <button className="icon-btn edit-btn" onClick={() => startEdit(product)} title="Edit">
                      &#9998;
                    </button>
                    <button className="icon-btn delete-btn" onClick={() => handleDelete(product.id)} title="Delete">
                      &#10005;
                    </button>
                  </div>
                </div>
                <h3 className="product-name">{product.name}</h3>
                <p className="product-desc">{product.description}</p>
                <div className="product-card-footer">
                  <span className="product-price">${product.price.toFixed(2)}</span>
                  <span className="product-qty">Qty: {product.quantity ?? 0}</span>
                </div>
              </>
            )}
          </article>
        ))}
      </div>
    </section>
  );
}
